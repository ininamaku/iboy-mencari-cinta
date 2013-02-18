package struktur.data;


import java.util.List;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M500-S430
 */
public class Kandidat {
    private String kandidat_id;
    private int enlightenment;
    private int energi;
    private int maxjam;
    private int sisajam;
    private List<String> prereq; //string kode barang
    private boolean[][] jadwal = new boolean[7][10]; //cuekin aja
    
    public Kandidat()
    {
    }
    
    public Kandidat(String id, int a,int b, int c)
    {
        kandidat_id = id; 
        enlightenment = a;
        energi = b;
        maxjam = c;
        sisajam = c;
        prereq = new Vector<String>();
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j<10; j++)
            {
                jadwal[i][j] = false;
            }
        }
    }

    public String getKandidat_id() {
        return kandidat_id;
    }

    public boolean[][] getJadwal() {
        return jadwal;
    }
    
    public int getEnlightenment()
    {
        return enlightenment;
    }
    
    public int getEnergi()
    {
        return energi;
    }
    
    public int getMaxjam()
    {
        return maxjam;
    }
    
    public int getSisajam()
    {
        return sisajam;
    }
    
    public List<String> getPrereq()
    {
        return prereq;
    }
    
    public boolean getJadwal(int hari,int jam)
    {
        return jadwal[hari][jam];
    }

    public void setKandidat_id(String kandidat_id) {
        this.kandidat_id = kandidat_id;
    }

    public void setJadwal(boolean[][] jadwal) {
        this.jadwal = jadwal;
    }

    public void setPrereq(List<String> prereq) {
        this.prereq = prereq;
    }
    
    public void setEnlightenment(int newen)
    {
        enlightenment = newen;
    }
    
    public void setEnergi(int newenergi)
    {
        energi = newenergi;
    }
    
    public void setMaxjam(int newjam)
    {
        maxjam = newjam;
    }
    
    public void addPrereq(String kodeBarang)
    {
        prereq.add(kodeBarang);
    }
    
    public void setJadwal(int hari,int jam)
    {
        jadwal[hari][jam] = true;
    }
    
    public void resetjam()
    {
        sisajam = maxjam;
    }

    public void setSisajam(int sisajam) {
        this.sisajam = sisajam;
    }

    
}
