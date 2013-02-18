
package iboy.mencari.cinta;

import java.util.List;
import java.util.Vector;
import struktur.data.*;
import java.util.Random;

public class IBoyMencariCinta {
    List<Jadwal> jadwalIboy; 
    List<Barang> listOfBarang;      //0..N
    List<Kandidat> listOfKandidat;  //N+1..Max
    List<Jadwal> jadwalKandidat;
    IBoy iboy; 
    
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
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Construct iboy dll here */
        
        /* read input */
        
        /* call genetic algo */
 
        /* the result print to output file */
    }
}
