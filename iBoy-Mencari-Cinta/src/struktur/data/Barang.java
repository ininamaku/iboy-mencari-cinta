package struktur.data;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M500-S430
 */
public class Barang {
    private String kode;
    private int harga;
    private int restock;
    private int waktu; //waktu beli persatuan barang
    private int sisabarang;
    
    public Barang()
    {
    }
    
    public Barang(String a,int b,int c,int d)
    {
        kode = a;
        harga = b;
        restock = c;
        waktu = d;
        sisabarang = c;
    }
    
    public String getKode()
    {
        return kode;
    }
    
    public int getHarga()
    {
        return harga;
    }
    
    public int getRestock()
    {
        return restock;
    }
    
    public int getWaktu()
    {
        return waktu;
    }
    
    public int sisabarang()
    {
        return sisabarang;
    }
    
    public void setKode(String newkode)
    {
        kode = newkode;
    }
    
    public void setHarga(int newharga)
    {
        harga = newharga;
    }
    
    public void setRestock(int newrestock)
    {
        restock = newrestock;
    }
    
    public void setWaktu(int newwaktu)
    {
        waktu = newwaktu;
    }
    
    public void resetbarang()
    {
        sisabarang = restock;
    }
}
