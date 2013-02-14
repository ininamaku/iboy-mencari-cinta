package struktur.data;

public class Jadwal {
    Day[] day = new Day[7];

    Jadwal() {
        for (int i=0; i<7; i++) {
            day[i] = new Day();
        }
    }
    
    /* 
     * Mengeset hour tertentu pada suatu d menjadi str
     */
    void setDayHour (int d, int h, String str) {
        day[d].hour[h] = str;
    }
    
    /* 
     * Get isi dari hour tertentu pada suatu d 
     */
    String getDayHour (int d, int h) {
        return day[d].hour[h];
    }
    
    /* 
     * Print jadwal iBoy selama 1 minggu 
     */
    void printJadwal() {
        System.out.println("Jadwal iBoy");
        for (int i = 0; i<7; i++) {
            for (int j=0; j<10; j++) {
                System.out.print(day[i].hour[j] + " ");
            }
            System.out.println("");
        }
    }
}
