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
    private int enlightenment;
    private int energi;
    private int maxjam;
    private int sisajam;
    private List<String> prereq;
    private boolean[][] jadwal = new boolean[7][10];
    
    public Kandidat()
    {
    }
    
    public Kandidat(int a,int b, int c)
    {
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
