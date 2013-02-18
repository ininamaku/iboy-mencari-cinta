
package iboy.mencari.cinta;

import java.util.List;
import java.util.Vector;
import struktur.data.*;
import java.util.Random;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
    
    private int random (int maxIndex) {
        Random R = new Random();
        return R.nextInt(maxIndex);
    }
    
    private int isBarang (String id) {
        for (int i=0; i<listOfBarang.size(); i++) {
            if (id.compareTo(listOfBarang.get(i).getKode()) == 0) {
                return i;
            }
        }
        return -1;
    }
    
    private int isKandidat (String id) {
        for (int i=0; i<listOfKandidat.size(); i++) {
            if (id.compareTo(listOfKandidat.get(i).getKandidat_id()) == 0) {
                return i;
                
            }
        }
        return -1;
    }
    
    /*
     * Belum di tes
     */
    public int validateJadwal (Jadwal jadwal) {
        IBoy iboyClone = iboy.clone();
        String currentActivity = new String(); 
        for (int i=0; i<jadwal.getJumlahMinggu() * 7; i++) {
            for (int j=0; j<10; j++) {
                currentActivity = jadwal.getDayHour(i, j);
                int barangIdx = isBarang(currentActivity);
                int kandidatIdx = isKandidat(currentActivity);
                if (kandidatIdx != -1) {
                    if (jadwalKandidat.get(kandidatIdx).getDayHour(i, j).compareTo("0") == 0) {
                        return i;
                    }
                    if (! iboyClone.bisaDikencani(listOfKandidat.get(kandidatIdx))) {
                        return i; 
                    }
                    else {
                        iboyClone.Kencani(listOfKandidat.get(kandidatIdx));
                    }
                }
                else
                if (barangIdx != -1) {
                    if (! iboyClone.beliBarang(listOfBarang.get(barangIdx))) {
                        return i; 
                    }   
                }
            }
            iboyClone.nextDay();
        }
        return -1;
    }
    
    /*
     * Fitness function \m/
     * method countEnlightment dipakai jika jadwal valid
     */
    public int countEnlightment (Jadwal jadwal) {
        IBoy iboyClone = iboy.clone();
        String currentActivity = new String();
        int enlightment = 0; 
        
        for (int i=0; i<jadwal.getJumlahMinggu() * 7; i++) {
            for (int j=0; j<10; j++) {
                currentActivity = jadwal.getDayHour(i, j);
                int kandidatIdx = isKandidat(currentActivity);
                if (kandidatIdx != -1) {
                    enlightment += listOfKandidat.get(kandidatIdx).getEnlightenment();
                }
            }
            iboyClone.nextDay();
        }
        return enlightment;
    }
    
    
    /*
     * Belum di tes
     */
    public void initialize (int jumlahMinggu) {
        jadwalIboy = new Vector<Jadwal>();
        for (int i=0; i<4; i++) { //jumlah populasi
            Jadwal tempJadwal = new Jadwal(jumlahMinggu);
            for (int j=0; j<jumlahMinggu*7; j++) { //day ke berapa
                for (int k=0; k<10; k++) { //jam ke berapa
                    int hasilRandom = random(listOfBarang.size() + listOfKandidat.size());
                    String tempID = new String();
                    if (hasilRandom < listOfBarang.size()) {
                        tempID = listOfBarang.get(hasilRandom).getKode();
                    }
                    else {
                        tempID = listOfKandidat.get(hasilRandom-listOfBarang.size()).getKandidat_id();
                        if (jadwalKandidat.get(hasilRandom-listOfBarang.size()).getDayHour(j, k).compareTo("0") == 0) {
                            tempID = "0";
                        }
                    }
                    tempJadwal.setDayHour(j,k,tempID);                
                }
            }
            
            jadwalIboy.add(tempJadwal);
        }
    }
	
    public void Parser(){
       iboy = new IBoy();
       listOfBarang = new Vector<Barang>();  
       listOfKandidat = new Vector<Kandidat>();
       jadwalKandidat = new Vector<Jadwal>();
       
       try {
            StringBuilder text = new StringBuilder();
            Scanner scanner = new Scanner(new FileInputStream("input.txt"));
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
            for (int i=0;i<jumlahKandidat; i++){
                String lineSplit[] = line[2+i].split(" ");
                Kandidat kandidat = new Kandidat(new Integer(i).toString(),Integer.parseInt(lineSplit[0]),Integer.parseInt(lineSplit[1]),Integer.parseInt(lineSplit[2]));
                if (lineSplit[3].equals("-")){
                    for(int j=1;j<lineSplit[3].length();j++){
                        kandidat.addPrereq(lineSplit[3].substring(j-1,j));
                    }
                }
                listOfKandidat.add(kandidat);  
            }    
            int jumlahBarang = new Integer(Integer.parseInt(line[jumlahKandidat+2]));
            for (int i=0;i<jumlahBarang; i++){
                String lineSplit[] = line[jumlahKandidat+3+i].split(" ");
                Barang barang = new Barang();
                barang.setKode(lineSplit[0]);
                
                barang.setHarga(Integer.parseInt(lineSplit[1]));
                barang.setRestock(Integer.parseInt(lineSplit[2]));
                listOfBarang.add(barang);
                }
            }
   
       
        catch (FileNotFoundException ex) {
            Logger.getLogger(IBoyMencariCinta.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       try {
            StringBuilder text = new StringBuilder();
            Scanner scanner = new Scanner(new FileInputStream("jadwal.txt"));
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
            for (int i=0;i<jumlahKandidat;i++){
                hari=0;jam=0;
                Jadwal jadwalKand = new Jadwal (jumlahminggu);
                for(int j=1;j<kandidat[i].length();j++){
                    jadwalKand.setDayHour(hari,jam, kandidat[i].substring(j-1,j));
                    jam++;
                    if (jam>9){
                        hari++;
                        jam=0;
                    }
                }
                jadwalKandidat.add(jadwalKand);
            }
        }
   
        catch (FileNotFoundException ex) {
            Logger.getLogger(IBoyMencariCinta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        IBoyMencariCinta ibot = new IBoyMencariCinta();
        ibot.Parser();
         /* Construct iboy dll here */

        /* read input */
            
        /* call genetic algo */

        /* the result print to output file */
    }
}