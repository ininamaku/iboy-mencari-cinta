package struktur.data;


import java.util.List;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fauzan
 */
public class IBoy {

    private int money;
    private int moneyPerDay;
    private int energy;
    private int maxEnergy;
    public int enlightment;
    List<String> listOfBarang;

    public IBoy() {
        money = 0;
        moneyPerDay = 0;
        energy = 0;
        maxEnergy = 0;
        enlightment = 0;
        listOfBarang = new Vector<String>();
    }


    public IBoy clone() {
        IBoy ib = new IBoy();
        ib.money = money;
        ib.moneyPerDay = moneyPerDay;
        ib.energy = energy;
        ib.maxEnergy = maxEnergy;
        ib.enlightment = enlightment;
        ib.listOfBarang = new Vector<String>(listOfBarang);
        return ib;
    }

    public int getEnergy() {
        return energy;
    }

    public int getEnlightment() {
        return enlightment;
    }

    public List<String> getListOfBarang() {
        return listOfBarang;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getMoney() {
        return money;
    }

    public int getMoneyPerDay() {
        return moneyPerDay;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }

    public void setMoneyPerDay(int moneyPerDay) {
        this.moneyPerDay = moneyPerDay;
    }

    public void SetEnergy(int energy) {
        this.energy = energy;
        this.maxEnergy = energy;
    }

    public void SetMoney(int _money) {
        money = _money;
    }
    
    public void SetMoneyPerDay(int _money) {
        moneyPerDay = _money;
    }

    /**
     *
     * @param barang
     * @return kalo bisa beli barang true kalo enggak cukup uang false
     */
    public boolean beliBarang(Barang barang) {
        if(money < barang.getHarga() || barang.getSisabarang() <= 0) return false;
        energy -= 1;
        String kode = barang.getKode();
        money -= barang.getHarga();
        listOfBarang.add(kode);
        return true;
    }

    public boolean punyaBarang(String kode) {
        return listOfBarang.contains(kode);
    }

    /**
     *
     * @param kode Kode barang harus ada, sebelum pake cek pake punyaBarang()
     */
    public void useBarang(String kode) {
        listOfBarang.remove(kode);
    }

    public boolean bisaDikencani(Kandidat kandidat) {
        boolean prereqDipenuhi = true;
        List<String> s = kandidat.getPrereq();
        for(int i =0; i< s.size(); i++) {
            prereqDipenuhi = prereqDipenuhi && listOfBarang.contains(s.get(i));
            if(!prereqDipenuhi) break;
        }
        return (kandidat.getSisajam() > 0 && prereqDipenuhi && !gakKuat());
    }
    
    /**
     * Kalo mau pake cek dulu si Kandidat sisa jam sama prereqnya.
     * Cek pake bisaDikencani()
     * @param kandidat
     */
    public void Kencani(Kandidat kandidat) {
        energy -= kandidat.getEnergi();
        enlightment = kandidat.getEnlightenment();
        kandidat.setSisajam(kandidat.getSisajam()-1);
        List<String> s = kandidat.getPrereq();
        for(int i =0; i< s.size(); i++) {
            listOfBarang.remove(s.get(i));
        } 
    }

    public boolean gakKuat() {
        return (energy <= 0);
    }

    public void nextDay() {
        energy = maxEnergy;
        money += moneyPerDay;
    }

    public void printData() {
        System.out.println("Energy      : " + getEnergy());
        System.out.println("Enlightment : " + getEnlightment());
        System.out.println("Max Energy  : " + getMaxEnergy());
        System.out.println("Money       : " + getMoney());
        System.out.println("Money/day   : " + getMoneyPerDay());
        //System.out.println("Gift List   :" + getListOfBarang());
    }
    
    public String printData2() {
        return "Energy      : " + getEnergy() + "\n" +
                "Enlightment : " + getEnlightment() + "\n" +
                "Max Energy  : " + getMaxEnergy() + "\n" +
                "Money       : " + getMoney()+ "\n" +
                "Money/day   : " + getMoneyPerDay();
        
        //System.out.println("Gift List   :" + getListOfBarang());
    }
}
