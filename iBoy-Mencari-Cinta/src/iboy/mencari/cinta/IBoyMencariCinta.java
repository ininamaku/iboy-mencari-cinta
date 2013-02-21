package iboy.mencari.cinta;

import java.util.List;
import java.util.Vector;
import struktur.data.*;
import java.util.Random;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IBoyMencariCinta {

    List<Jadwal> jadwalIboy;
    List<Barang> listOfBarang;      //0..N
    List<Kandidat> listOfKandidat;  //N+1..Max
    List<Jadwal> jadwalKandidat;
    IBoy iboy;
    int jumlahminggu;
    int jumlahKandidat;
    Jadwal bestJadwal; 
    int maxEn;
    
    private int random(int maxIndex) {
        Random R = new Random();
        return R.nextInt(maxIndex);
    }

    private int isBarang(String id) {
        for (int i = 0; i < listOfBarang.size(); i++) {
            if (id.compareTo(listOfBarang.get(i).getKode()) == 0) {
                //System.out.println("ID Barang yang dicek : " + listOfBarang.get(i).getKode());
                return i;
            }
        }
        return -1;
    }

    private int isKandidat(String id) {
        for (int i = 0; i < listOfKandidat.size(); i++) {
            if (id.compareTo(listOfKandidat.get(i).getKandidat_id()) == 0) {
                // System.out.println("ID Kandidat yang dicek : " + listOfKandidat.get(i).getKandidat_id() );
                return i;

            }
        }
        return -1;
    }

    private void ReStock() {
        for (int i = 0; i < listOfBarang.size(); i++) {
            Barang barang = listOfBarang.get(i);
            barang.resetbarang();
        }
    }

    private void ResetJamKandidat() {
        for (int i = 0; i < listOfKandidat.size(); i++) {
            Kandidat k = listOfKandidat.get(i);
            k.resetjam();
        }
    }

    /*
     * Belum di tes
     */
    public ValidationResult validateJadwal(Jadwal jadwal) {
        ValidationResult val;
        IBoy iboyClone = iboy.clone();
        String currentActivity = new String();
        for (int i = 0; i < jadwal.getJumlahMinggu() * 7; i++) {
            for (int j = 0; j < 10; j++) {
                //System.out.println("Energi iboy : " + iboyClone.getEnergy());
                currentActivity = jadwal.getDayHour(i, j);
                int barangIdx = isBarang(currentActivity);
                int kandidatIdx = isKandidat(currentActivity);
                if (kandidatIdx != -1) {
                    //System.out.println("Cek kandidat");
                    if (jadwalKandidat.get(kandidatIdx).getDayHour(i, j).compareTo("0") == 0) {
                        val = ValidationResult.CreateValidationResult(ValidationResult.INVALID_GIRL, iboyClone, i, j);
                        return val;
                    }

                    if (!iboyClone.bisaDikencani(listOfKandidat.get(kandidatIdx))) {
                        val = ValidationResult.CreateValidationResult(ValidationResult.INVALID_GIRL, iboyClone, i, j);
                        return val;
                    } else {
                        //System.out.println("lagi kencan niye");
                        iboyClone.Kencani(listOfKandidat.get(kandidatIdx));
                    }
                } else if (barangIdx != -1) {
                    //System.out.println("cek barang");
                    if (!iboyClone.beliBarang(listOfBarang.get(barangIdx))) {
                        val = ValidationResult.CreateValidationResult(ValidationResult.INVALID_GIFT, iboyClone, i, j);
                        return val;
                    }
                }
            }
            ResetJamKandidat();
            ReStock();
            iboyClone.nextDay();
        }
        val = ValidationResult.CreateValidationResult(ValidationResult.VALIDATION_OK, iboyClone, 0, 0);
        return val;
    }

    /*
     * Fitness function \m/
     * method countEnlightment dipakai jika jadwal valid
     */
    public int countEnlightment(Jadwal jadwal) {
        String currentActivity = new String();
        int enlightment = 0;

        for (int i = 0; i < jadwal.getJumlahMinggu() * 7; i++) {
            for (int j = 0; j < 10; j++) {
                currentActivity = jadwal.getDayHour(i, j);
                int kandidatIdx = isKandidat(currentActivity);
                if (kandidatIdx != -1) {
                    enlightment += listOfKandidat.get(kandidatIdx).getEnlightenment();
                }
            }
        }
        return enlightment;
    }

    /*
     * Belum di tes
     */
    public void initialize(int jumlahMinggu) {
        jadwalIboy = new Vector<Jadwal>();
        for (int i = 0; i < 4; i++) { //jumlah populasi
            //System.out.println("Populasi ke- " + i);
            IBoy iboyClone = iboy.clone();
            Jadwal tempJadwal = new Jadwal(jumlahMinggu);

            for (int j = 0; j < jumlahMinggu * 7; j++) { //day ke berapa
                //System.out.println("Day-" + j);
                for (int k = 0; k < 10; k++) { //jam ke berapa
                    int hasilRandom = random(listOfBarang.size() + listOfKandidat.size());
                    String tempID = new String();
                    if (hasilRandom < listOfBarang.size()) {
                        if (!iboyClone.beliBarang(listOfBarang.get(hasilRandom))) {
                            tempID = "0";
                        } else {
                            tempID = listOfBarang.get(hasilRandom).getKode();
                        }
                    } else {
                        Kandidat tempKandidat = listOfKandidat.get(hasilRandom - listOfBarang.size());
                        tempID = tempKandidat.getKandidat_id();
                        if (jadwalKandidat.get(hasilRandom - listOfBarang.size()).getDayHour(j, k).compareTo("0") == 0) {
                            tempID = "0"; //kandidat sibuk
                        } else {
                            if (iboyClone.bisaDikencani(tempKandidat)) {
                                tempID = tempKandidat.getKandidat_id();
                                iboyClone.Kencani(tempKandidat);
                            } else {
                                tempID = "0";
                            }
                        }
                    }

                    tempJadwal.setDayHour(j, k, tempID);
                }

                ResetJamKandidat();
                ReStock();
                iboyClone.nextDay();
            }

            jadwalIboy.add(tempJadwal);
        }
    }

    public void parseInput(String origin) {
        iboy = new IBoy();
        listOfBarang = new Vector<Barang>();
        listOfKandidat = new Vector<Kandidat>();

        try {
            StringBuilder text = new StringBuilder();
            Scanner scanner = new Scanner(new FileInputStream(origin));
            try {
                while (scanner.hasNextLine()) {
                    text.append(scanner.nextLine()).append("\n");
                }
            } finally {
                scanner.close();
            }
            String n = new String(text);
            String line[] = n.split("[\n]");
            String firstLineSplit[] = line[0].split(" ");
            iboy.setMoney(Integer.parseInt(firstLineSplit[0]));
            iboy.SetMoneyPerDay(Integer.parseInt(firstLineSplit[1]));
            jumlahminggu = new Integer(Integer.parseInt(firstLineSplit[2]));
            iboy.SetEnergy(Integer.parseInt(firstLineSplit[3]));
            jumlahKandidat = new Integer(Integer.parseInt(line[1]));
            for (int i = 0; i < jumlahKandidat; i++) {
                String lineSplit[] = line[2 + i].split(" ");
                Kandidat kandidat = new Kandidat(new Integer(i + 1).toString(), Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]));
                if (!lineSplit[3].equals("-")) {
                    for (int j = 1; j <= lineSplit[3].length(); j++) {
                        kandidat.addPrereq(lineSplit[3].substring(j - 1, j));
                        //System.out.println(lineSplit[3].substring(j - 1, j));
                    }
                }
                listOfKandidat.add(kandidat);
            }
            int jumlahBarang = new Integer(Integer.parseInt(line[jumlahKandidat + 2]));
            for (int i = 0; i < jumlahBarang; i++) {
                String lineSplit[] = line[jumlahKandidat + 3 + i].split(" ");
                Barang barang = new Barang();
                barang.setKode(lineSplit[0]);

                barang.setHarga(Integer.parseInt(lineSplit[1]));
                barang.setRestock(Integer.parseInt(lineSplit[2]));
                listOfBarang.add(barang);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IBoyMencariCinta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void parseJadwal(String origin) {
        jadwalKandidat = new Vector<Jadwal>();
    
        try {
            StringBuilder text = new StringBuilder();
            Scanner scanner = new Scanner(new FileInputStream(origin));
            try {
                while (scanner.hasNextLine()) {
                    text.append(scanner.nextLine()).append("\n");
                }
            } finally {
                scanner.close();
            }
            String n = new String(text);
            String kandidat[] = n.split("[\n]");
            int hari;
            int jam;
            for (int i = 0; i < jumlahKandidat; i++) {
                hari = 0;
                jam = 0;
                Jadwal jadwalKand = new Jadwal(jumlahminggu);
                for (int j = 1; j <= kandidat[i].length(); j++) {
                    jadwalKand.setDayHour(hari, jam, kandidat[i].substring(j - 1, j));
                    jam++;
                    if (jam > 9) {
                        hari++;
                        jam = 0;
                    }
                }
                jadwalKandidat.add(jadwalKand);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IBoyMencariCinta.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    public void selection() {
        int[] en = new int[4];
        int index = 0;
        int minEn = 99999;
        int minIdx = 0;
        int[] crossIdx = new int[4];

        //for each populasi jadwal, hitung enlightment & hitung englightment terkecil
        for (int i = 0; i < 4; i++) {
            en[i] = countEnlightment(jadwalIboy.get(i));
            //System.out.println("en - "+i+" = " + en[i]);
            if (en[i] < minEn) {
                minIdx = i;
                minEn = en[i];
            }
        }

        //cari index untuk crossOver
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            if (i != minIdx) {
                if ((i + 1 != minIdx) && (i + 1 < 4)) {
                    crossIdx[temp] = i;
                    temp++;
                    crossIdx[temp] = i + 1;
                    temp++;
                } else if ((i + 2 != minIdx) && (i + 2 < 4)) {
                    crossIdx[temp] = i;
                    temp++;
                    crossIdx[temp] = i + 2;
                    temp++;
                }
            }
        }

        //crossOver Jadwal crossIdx[0] & Jadwal crossIdx[1]
        List<Jadwal> crossedJadwalA = CrossOver(jadwalIboy.get(crossIdx[0]), jadwalIboy.get(crossIdx[1]));
        //crossOver Jadwal crossIdx[2] & Jadwal crossIdx[3]
        List<Jadwal> crossedJadwalB = CrossOver(jadwalIboy.get(crossIdx[2]), jadwalIboy.get(crossIdx[3]));

        jadwalIboy.clear();
        jadwalIboy.addAll(crossedJadwalA);
        jadwalIboy.addAll(crossedJadwalB);
        //System.out.println("minEn = " + minEn + " minIdx = " + minIdx);
    }

    public List<Jadwal> CrossOver(Jadwal jadwalA, Jadwal jadwalB) {
        int crossIndex = random(jumlahminggu * 7 * 10);
        List<Jadwal> crossedJadwal = new Vector<Jadwal>();
        Jadwal jadwalA_ = new Jadwal(jumlahminggu);
        Jadwal jadwalB_ = new Jadwal(jumlahminggu);
        for (int day = 0; day < jumlahminggu * 7; day++) {
            for (int hour = 0; hour < 10; hour++) {
                if (crossIndex > (day * 10 + hour)) {
                    jadwalA_.setDayHour(day, hour, jadwalA.getDayHour(day, hour));
                    jadwalB_.setDayHour(day, hour, jadwalB.getDayHour(day, hour));
                    //System.out.println("crossIndex = " + crossIndex);
                    //System.out.println("day & hour = " + day + " " + hour);
                } else {
                    jadwalB_.setDayHour(day, hour, jadwalA.getDayHour(day, hour));
                    jadwalA_.setDayHour(day, hour, jadwalB.getDayHour(day, hour));
                }
            }
        }
        crossedJadwal.add(jadwalA_);
        crossedJadwal.add(jadwalB_);

        /*
        System.out.println("Before : ");
        jadwalA.printJadwal();
        System.out.println("-------------");
        jadwalB.printJadwal();
        
        System.out.println("After : ");
        jadwalA_.printJadwal();
        System.out.println("Validate A : " + validateJadwal(jadwalA_));
        System.out.println("-------------");
        jadwalB_.printJadwal();
        System.out.println("Validate B : " + validateJadwal(jadwalB_));
         */
        return crossedJadwal;
    }

    public void Mutate(Jadwal jadwal) {
        String s;
        int idx;
        int id;
        ValidationResult valres = validateJadwal(jadwal);
            switch (valres.type) {
                case ValidationResult.VALIDATION_OK:
                    int d = random(jadwal.getJumlahMinggu()*7);
                    int j = random(10);
                    s = jadwal.getDayHour(d, j);
                    idx = isKandidat(s);
                    if(idx != 1) {
                        idx = 0;
                        jadwal.setDayHour(d, j, listOfKandidat.get(idx).getKandidat_id());
                    }
                    id = (idx + 1) % listOfKandidat.size(); 
                    
                    while (id != idx) {
                        jadwal.setDayHour(d, j, listOfKandidat.get(id).getKandidat_id());
                        if (validateJadwal(jadwal).type == ValidationResult.VALIDATION_OK) {
                            break;
                        }
                        id = (id + 1) % listOfKandidat.size();
                    }
                    if (id == idx) {
                        jadwal.setDayHour(d, j, "0");
                    }
                    if(validateJadwal(jadwal).type != ValidationResult.VALIDATION_OK)
                        Mutate(jadwal);
                    break;
                case ValidationResult.INVALID_GIRL:
                    s = jadwal.getDayHour(valres.d, valres.h);
                    idx = isKandidat(s);
                    id = (idx + 1) % listOfKandidat.size();
                    while (id != idx) {
                        jadwal.setDayHour(valres.d, valres.h, listOfKandidat.get(id).getKandidat_id());
                        if (validateJadwal(jadwal).type == ValidationResult.VALIDATION_OK) {
                            break;
                        }
                        id = (id + 1) % listOfKandidat.size();
                    }
                    if (id == idx) {
                        jadwal.setDayHour(valres.d, valres.h, "0");
                    }
                    if(validateJadwal(jadwal).type != ValidationResult.VALIDATION_OK)
                        Mutate(jadwal);
                    break;
                case ValidationResult.INVALID_GIFT:
                    s = jadwal.getDayHour(valres.d, valres.h);
                    idx = isBarang(s);
                    id = (idx + 1) % listOfBarang.size();
                    while (id != idx) {
                        jadwal.setDayHour(valres.d, valres.h, listOfBarang.get(id).getKode());
                        if (validateJadwal(jadwal).type == ValidationResult.VALIDATION_OK) {
                            break;
                        }
                        id = (id + 1) % listOfBarang.size();
                    }
                    if (id == idx) {
                        jadwal.setDayHour(valres.d, valres.h, "0");
                    }
                    if(validateJadwal(jadwal).type != ValidationResult.VALIDATION_OK)
                        Mutate(jadwal);
                    break;
            }
    }
    
    public void Mutation() {
        
        for (int i = 0; i < jadwalIboy.size(); i++) {
            Jadwal jadwal = jadwalIboy.get(i);
            Mutate(jadwal);
        }
    }

    public void printIboy() {
        iboy.printData();
    }

    public String printIboy2() {
        return iboy.printData2();
    }
    
    
    public void geneticAlgo(int loopCount) {
        //initialize(jumlahminggu); 
        int maxEnlightment = 0;
        int temp; 
        
        if (loopCount == -1) {
            while (true) {
                selection();
                Mutation();
                for (int i = 0; i < jadwalIboy.size(); i++) {
                    //untuk populasi ke-i
                    temp = countEnlightment(jadwalIboy.get(i));
                    if (temp>maxEnlightment) {
                        maxEnlightment = temp;
                        bestJadwal = jadwalIboy.get(i);
                    }
                }
            }
        }
        else {
            for (int i=0; i<loopCount; i++) {
                selection();
                Mutation();
                for (int j = 0; j < jadwalIboy.size(); j++) {
                    //untuk populasi ke-i
                    temp = countEnlightment(jadwalIboy.get(j));
                    if (temp>maxEnlightment) {
                        maxEnlightment = temp;
                        bestJadwal = jadwalIboy.get(j);
                    }
                }
            }
        }
        
        maxEn = maxEnlightment;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IBoyMencariCinta ibot = new IBoyMencariCinta();
        ibot.parseInput("input.txt"); // read input & parse
        ibot.parseJadwal("jadwal.txt"); // read input & parse
        
        for (int i=0; i< ibot.jumlahKandidat; i++) {
            System.out.println("Kandidat " + i);
            for (int j=0; j<ibot.listOfKandidat.get(i).getPrereq().size(); j++) {
                System.out.println("Preq " + ibot.listOfKandidat.get(i).getPrereq().get(j));            
            }
        }
        
        ibot.printIboy();
        
        ibot.initialize(ibot.jumlahminggu);
           
        for (int i = 0; i < ibot.jadwalIboy.size(); i++) {
            System.out.print("POPULASI ke-" + i);
            ibot.jadwalIboy.get(i).printJadwal();
            System.out.println("Validate jadwal : " + ibot.validateJadwal(ibot.jadwalIboy.get(i)).type);
        }

        for (int i = 0; i < ibot.jadwalIboy.size(); i++) {
            System.out.println(ibot.jadwalIboy.get(i));
        }
        
        ibot.geneticAlgo(2);
        
        /*
        for (int i = 0; i < ibot.jadwalIboy.size(); i++) {
            System.out.print("POPULASI ke-" + i);
            ibot.jadwalIboy.get(i).printJadwal();
            System.out.println("Validate jadwal : " + ibot.validateJadwal(ibot.jadwalIboy.get(i)).type);
            System.out.println("Enlightment : " + ibot.countEnlightment(ibot.jadwalIboy.get(i)));
        } 
        for (int i=0; i< ibot.jumlahKandidat; i++) {
            System.out.println("Kandidat " + i);
            for (int j=0; j<ibot.listOfKandidat.get(i).getPrereq().size(); j++) {
                System.out.println("Preq " + ibot.listOfKandidat.get(i).getPrereq().get(j));            
            }
        }
        */

        /* Print result */
        System.out.println();
        System.out.println("Max Enlightment : " + ibot.maxEn);
        System.out.println("Best Schedule : ");
        ibot.bestJadwal.printJadwal();
    }
}
