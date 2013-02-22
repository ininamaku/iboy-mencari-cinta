package struktur.data;

public class Jadwal {
    Day[] day;
    int jumlahMinggu; 
    
    public Jadwal (int jumlahMinggu_) {
        jumlahMinggu = jumlahMinggu_;
        
        day = new Day[7*jumlahMinggu];
        for (int i=0; i<7*jumlahMinggu; i++) {
            day[i] = new Day();
        }
    }
    
    /* 
     * Mengeset hour tertentu pada suatu d menjadi str
     */
    public void setDayHour (int d, int h, String str) {
        day[d].hour[h] = str;
    }

    public int getJumlahMinggu() {
        return jumlahMinggu;
    }
    
    /* 
     * Get isi dari hour tertentu pada suatu d 
     */
    public String getDayHour (int d, int h) {
        return day[d].hour[h];
    }

    public Day[] getDay() {
        return day;
    }
    
    /* 
     * Print jadwal iBoy selama 1 minggu 
     */
    public void printJadwal() {
        System.out.println("Jadwal iBoy");
        for (int i = 0; i<day.length; i++) {
            for (int j=0; j<10; j++) {
                System.out.print(day[i].hour[j]);
            }
        }
        System.out.println("");
    }
    
    @Override
    public String toString(){
       String result = "";
       for (int i = 0; i<day.length; i++) {
            for (int j=0; j<10; j++) {
                result+=day[i].hour[j];
            }
        }
       return result;
    }
}
