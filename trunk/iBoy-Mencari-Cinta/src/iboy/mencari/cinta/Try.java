/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Try.java
 *
 * Created on Feb 19, 2013, 2:51:10 PM
 */

package iboy.mencari.cinta;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author kaniaazrina
 */
public class Try extends javax.swing.JFrame {

    private Thread tread;
    private Thread tread2;
    private boolean init;
    private boolean start;
    private boolean start2;
    private int currentHasil;
    private int currentJam;
    private int currentGold;
    private int currentEn;
    private int speed;
    private int speed2;
    private JFileChooser chooser1;
    private JFileChooser chooser2;
    private int currentKandidat;
    private IBoyMencariCinta ibot;
    private String dir = System.getProperty("user.dir");
    int maxEnlightment = 0;
    int temp;
    int loopCount;
    /** Creates new form Try */
    public Try() {
        initComponents();
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        chooser1 = new JFileChooser();
        chooser2 = new JFileChooser();
        currentKandidat = 1;
        currentHasil = 0;
        currentJam = 0;
        currentGold = 0;
        currentEn = 0;
        speed = 1000;
        speed2 = 1000;
        init = false;
        loopCount = 0;
        ibot = new IBoyMencariCinta();
    }

    public void dataKandidat(int no)
    {
        switch (no)
        {
            case 0 : {jTextField6.setText("Kania"); jTextField7.setText(printprereq(0)); break;}
            case 1 : {jTextField6.setText("Sharon"); jTextField7.setText(printprereq(1)); break;}
            case 2 : {jTextField6.setText("Mamon"); jTextField7.setText(printprereq(2)); break;}
            case 3 : {jTextField6.setText("Nunu"); jTextField7.setText(printprereq(3)); break;}
            case 4 : {jTextField6.setText("Frilla"); jTextField7.setText(printprereq(4)); break;}
            case 5 : {jTextField6.setText("Fira"); jTextField7.setText(printprereq(5)); break;}
            case 6 : {jTextField6.setText("Monca"); jTextField7.setText(printprereq(6)); break;}
            case 7 : {jTextField6.setText("Agnes"); jTextField7.setText(printprereq(7)); break;}
            case 8 : {jTextField6.setText("Gaby"); jTextField7.setText(printprereq(8)); break;}
            case 9 : {jTextField6.setText("Dwi"); jTextField7.setText(printprereq(9)); break;}
            case 10 : {jTextField6.setText(""); jTextField7.setText(""); break;}
        }    
    }
    
    public String printprereq(int no)
    {
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<ibot.listOfKandidat.get(no).getPrereq().size(); j++) {
                sb.append(nama_barang(ibot.listOfKandidat.get(no).getPrereq().get(j)) + ",");
        }
        
        return sb.toString();
    }
    
    public String nama_barang(String c)
    {
        String hasil = new String();
        switch (c)
        {
            case "A" : {hasil = "Red Rose"; break;}
            case "B" : {hasil = "Godiva Chocolate"; break;}
            case "C" : {hasil = "24 Carat Gold"; break;}
            case "D" : {hasil = "Cartier Ring"; break;}
            case "E" : {hasil = "Hermes Bag"; break;}
            case "F" : {hasil = "Adidas Sneakers"; break;}
            case "G" : {hasil = "Burberry Shawl"; break;}
            case "H" : {hasil = "Loubutin Heels"; break;}
            case "I" : {hasil = "Alexander McQueen Dress"; break;}
            case "J" : {hasil = "Tiffany & Co Bracelet"; break;}
            case "K" : {hasil = "Aigner Watch"; break;}
            case "L" : {hasil = "Chanel Nail Polish"; break;}
            case "M" : {hasil = "Victoria's Secret Lingerie"; break;}
            case "N" : {hasil = "L 'Occitane Body Wash"; break;}
            case "O" : {hasil = "Borjuois Mascara"; break;}
            case "P" : {hasil = "Make Up Forever Foundation"; break;}
            case "Q" : {hasil = "Bobbi Brown Gel Eyeliner"; break;}
            case "R" : {hasil = "YSL Lipstick"; break;}
            case "S" : {hasil = "Guerlain Blusher"; break;}
            case "T" : {hasil = "L'oreal Hair Color"; break;}
            case "U" : {hasil = "Maidenform Thights"; break;}
            case "V" : {hasil = "Mac Book Pro"; break;}
            case "W" : {hasil = "iPhone 5"; break;}
            case "X" : {hasil = "Debenhams Gift Card"; break;}
            case "Y" : {hasil = "Fuji Instax Polaroid"; break;}
            case "Z" : {hasil = "Canon EOS 5D Camera"; break;}
        }
        
        return hasil;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(java.awt.Color.black);
        setPreferredSize(new java.awt.Dimension(800, 700));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);
        jPanel1.add(jTextField34);
        jTextField34.setBounds(580, 220, 80, 20);
        jPanel1.add(jTextField35);
        jTextField35.setBounds(580, 250, 80, 20);
        jPanel1.add(jTextField36);
        jTextField36.setBounds(580, 290, 80, 20);
        jPanel1.add(jTextField37);
        jTextField37.setBounds(580, 320, 80, 20);
        jPanel1.add(jTextField38);
        jTextField38.setBounds(580, 360, 80, 20);
        jPanel1.add(jTextField39);
        jTextField39.setBounds(580, 400, 80, 20);
        jPanel1.add(jTextField40);
        jTextField40.setBounds(420, 90, 210, 20);
        jPanel1.add(jTextField41);
        jTextField41.setBounds(420, 130, 210, 20);

        jButton9.setText("Browse");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(650, 90, 80, 20);

        jButton10.setText("Browse");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(650, 130, 80, 20);

        jButton11.setText("open");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(430, 160, 110, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuts.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 620));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 620));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel2.setLayout(null);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(460, 100, 40, 20);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(540, 100, 90, 20);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(680, 100, 50, 20);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(460, 150, 50, 20);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(640, 150, 90, 20);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(590, 340, 120, 20);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(590, 400, 120, 20);
        jPanel2.add(jTextField9);
        jTextField9.setBounds(550, 510, 40, 30);
        jPanel2.add(jTextField10);
        jTextField10.setBounds(160, 80, 50, 20);
        jPanel2.add(jTextField11);
        jTextField11.setBounds(220, 80, 50, 20);
        jPanel2.add(jTextField12);
        jTextField12.setBounds(280, 80, 50, 20);
        jPanel2.add(jTextField13);
        jTextField13.setBounds(340, 80, 50, 20);
        jPanel2.add(jTextField14);
        jTextField14.setBounds(160, 120, 50, 20);
        jPanel2.add(jTextField15);
        jTextField15.setBounds(220, 120, 50, 20);
        jPanel2.add(jTextField16);
        jTextField16.setBounds(280, 120, 50, 20);
        jPanel2.add(jTextField17);
        jTextField17.setBounds(340, 120, 50, 20);
        jPanel2.add(jTextField18);
        jTextField18.setBounds(160, 170, 50, 20);
        jPanel2.add(jTextField19);
        jTextField19.setBounds(220, 170, 50, 20);
        jPanel2.add(jTextField20);
        jTextField20.setBounds(280, 170, 50, 20);
        jPanel2.add(jTextField21);
        jTextField21.setBounds(340, 170, 50, 20);

        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField22);
        jTextField22.setBounds(160, 220, 50, 20);
        jPanel2.add(jTextField23);
        jTextField23.setBounds(220, 220, 50, 20);
        jPanel2.add(jTextField24);
        jTextField24.setBounds(280, 220, 50, 20);
        jPanel2.add(jTextField25);
        jTextField25.setBounds(340, 220, 50, 20);
        jPanel2.add(jTextField26);
        jTextField26.setBounds(160, 280, 50, 20);
        jPanel2.add(jTextField27);
        jTextField27.setBounds(220, 280, 50, 20);
        jPanel2.add(jTextField28);
        jTextField28.setBounds(280, 280, 50, 20);
        jPanel2.add(jTextField29);
        jTextField29.setBounds(340, 280, 50, 20);
        jPanel2.add(jTextField30);
        jTextField30.setBounds(170, 350, 110, 20);

        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField31);
        jTextField31.setBounds(170, 380, 110, 20);
        jPanel2.add(jTextField32);
        jTextField32.setBounds(170, 420, 110, 20);
        jPanel2.add(jTextField33);
        jTextField33.setBounds(80, 480, 280, 20);

        jButton3.setText("<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(230, 540, 50, 23);

        jButton4.setText(">");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(290, 540, 50, 23);

        jButton5.setText("Play");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(80, 540, 60, 23);

        jButton6.setText("Pause");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(150, 540, 70, 23);

        jButton13.setText("<<");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13);
        jButton13.setBounds(230, 510, 50, 23);

        jButton14.setText(">>");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(290, 510, 50, 23);

        jButton12.setText("Find Solution");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12);
        jButton12.setBounds(80, 510, 120, 23);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(440, 190, 260, 90);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(450, 330, 140, 120);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 600);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/next.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\M500-S430\\Desktop\\iboy-mencari-cinta\\iBoy-Mencari-Cinta\\src\\back.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jButton2)
                .add(558, 558, 558)
                .add(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (speed >= 1000){
            speed = speed - 500;
        }
        else if (speed <= 500)
        {   
            if (speed-100 <= 0)
            {
                speed = 100;
            }
            else
                speed = speed - 100;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        //String dir = System.getProperty("user.dir");
        chooser1.setCurrentDirectory(new File(dir));
        int ret = chooser1.showOpenDialog(this);
        if(ret == JFileChooser.APPROVE_OPTION){
        File f = chooser1.getSelectedFile();
        jTextField40.setText(f.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        //String dir = System.getProperty("user.dir");
        chooser2.setCurrentDirectory(new File(dir));
        int ret = chooser2.showOpenDialog(this);
        if(ret == JFileChooser.APPROVE_OPTION){
        File f = chooser2.getSelectedFile();
        jTextField41.setText(f.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        ibot.parseInput(jTextField40.getText());
        ibot.parseJadwal(jTextField41.getText());
        jTextField34.setText(ibot.iboy.getMoney()+"");
        jTextField35.setText(ibot.iboy.getMoneyPerDay()+"");
        jTextField36.setText(ibot.jumlahminggu+"");
        jTextField37.setText(ibot.iboy.getMaxEnergy()+"");
        jTextField38.setText(ibot.jumlahKandidat+"");
        jTextField39.setText(ibot.listOfBarang.size()+"");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        start = true;
        tread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (start)
                {
                    //isi dengan jalan program
                    if (currentHasil < ibot.bestJadwal.getMaxDay())
                    {
                        if (currentJam < 10)
                        {
                            jTextField1.setText(currentJam + 10 + ".00");
                            jTextField2.setText(currentHasil + 1 + "");
                            jTextField3.setText(ibot.iboy.getMoney() + "");
                            jTextField4.setText(currentHasil/7 + 1 + "");
                            switch (ibot.bestJadwal.getDayHour(currentHasil, currentJam))
                            {
                                case "0" : {jTextField5.setText("iboy bengong"); jLabel3.setIcon(new ImageIcon(dir+"/src/energy.png")); jLabel4.setIcon(new ImageIcon("")); jTextField6.setText(""); break;}
                                case "1" : {currentEn=currentEn+ibot.listOfKandidat.get(0).getEnlightenment(); jTextField5.setText("Kania's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/kania.png")); dataKandidat(0); break;}
                                case "2" : {currentEn=currentEn+ibot.listOfKandidat.get(1).getEnlightenment(); jTextField5.setText("Sharon's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/sharon.png")); dataKandidat(1); break;}
                                case "3" : {currentEn=currentEn+ibot.listOfKandidat.get(2).getEnlightenment(); jTextField5.setText("Mamon's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/mamon.png")); dataKandidat(2); break;}
                                case "4" : {currentEn=currentEn+ibot.listOfKandidat.get(3).getEnlightenment(); jTextField5.setText("Nunu's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/nunu.png")); dataKandidat(3); break;}
                                case "5" : {currentEn=currentEn+ibot.listOfKandidat.get(4).getEnlightenment(); jTextField5.setText("Frilla's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/Girls.png")); dataKandidat(4); break;}
                                case "6" : {currentEn=currentEn+ibot.listOfKandidat.get(5).getEnlightenment(); jTextField5.setText("Fira's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/fira.png")); dataKandidat(5); break;}
                                case "7" : {currentEn=currentEn+ibot.listOfKandidat.get(6).getEnlightenment(); jTextField5.setText("Monca's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/moncha.png")); dataKandidat(6); break;}
                                case "8" : {currentEn=currentEn+ibot.listOfKandidat.get(7).getEnlightenment(); jTextField5.setText("Agnes's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/agnes.png")); dataKandidat(7); break;}
                                case "9" : {currentEn=currentEn+ibot.listOfKandidat.get(8).getEnlightenment(); jTextField5.setText("Gaby's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/gaby.png")); dataKandidat(8); break;}
                                case "10" : {currentEn=currentEn+ibot.listOfKandidat.get(9).getEnlightenment(); jTextField5.setText("Dwi's turn"); jLabel3.setIcon(new ImageIcon(dir+"/src/love.png")); jLabel4.setIcon(new ImageIcon(dir+"/src/dwi.png")); dataKandidat(9); break;}
                                default : {jTextField5.setText(nama_barang(ibot.bestJadwal.getDayHour(currentHasil, currentJam))); jLabel3.setIcon(new ImageIcon(dir+"/src/shop.png")); jLabel4.setIcon(new ImageIcon("")); dataKandidat(10); break;}
                            }
                            jTextField9.setText(currentEn+"");
                            currentJam = currentJam + 1;
                        }
                        else{
                            currentJam = 0;
                            currentHasil = currentHasil + 1;
                        } 
                    }
                    else{
                        start = false;
                    }
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Try.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        tread.start();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        start = false;
        tread.stop();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if (!init)
        {
            ibot.initialize(ibot.jumlahminggu);
            maxEnlightment = 0;
            jTextField14.setText(ibot.initJadwal.get(0)+"");
            jTextField15.setText(ibot.initJadwal.get(1)+"");
            jTextField16.setText(ibot.initJadwal.get(2)+"");
            jTextField17.setText(ibot.initJadwal.get(3)+"");
            currentGold = ibot.iboy.getMoney();
        }
                    
        start2 = true;
        tread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (start2)
                {
                    //isi dengan jalan program
                    if (loopCount < 100)
                    {
                        jTextField30.setText(loopCount + 1 + "");
                        ibot.selection();
                        
                        jTextField18.setText(ibot.selectionJadwal.get(0)+"");
                        jTextField19.setText(ibot.selectionJadwal.get(1)+"");
                        jTextField20.setText(ibot.selectionJadwal.get(2)+"");
                        jTextField21.setText(ibot.selectionJadwal.get(3)+"");
                        
                        jTextField22.setText(ibot.crossOverJadwal.get(0)+"");
                        jTextField23.setText(ibot.crossOverJadwal.get(1)+"");
                        jTextField24.setText(ibot.crossOverJadwal.get(2)+"");
                        jTextField25.setText(ibot.crossOverJadwal.get(3)+"");
                     
                        ibot.Mutation();
                        
                        for (int j = 0; j < ibot.jadwalIboy.size(); j++) {
                            //untuk populasi ke-i
                            ibot.mutationJadwal.add(ibot.jadwalIboy.get(j));
                            temp = ibot.countEnlightment(ibot.jadwalIboy.get(j));
                            if (temp>maxEnlightment) {
                                maxEnlightment = temp;
                                ibot.bestJadwal = ibot.jadwalIboy.get(j);
                            }
                        }
                        
                        jTextField10.setText(ibot.countEnlightment(ibot.jadwalIboy.get(0))+"");
                        jTextField11.setText(ibot.countEnlightment(ibot.jadwalIboy.get(1))+"");
                        jTextField12.setText(ibot.countEnlightment(ibot.jadwalIboy.get(2))+"");
                        jTextField13.setText(ibot.countEnlightment(ibot.jadwalIboy.get(3))+"");
                        
                        jTextField26.setText(ibot.mutationJadwal.get(0)+"");
                        jTextField27.setText(ibot.mutationJadwal.get(1)+"");
                        jTextField28.setText(ibot.mutationJadwal.get(2)+"");
                        jTextField29.setText(ibot.mutationJadwal.get(3)+"");
                        
                        loopCount = loopCount + 1;
                        
                        jTextField31.setText(maxEnlightment + "");
                        jTextField32.setText(ibot.bestJadwal.printJadwal2());
                    }
                    else
                    {
                        ibot.maxEn = maxEnlightment;
                        jTextField33.setText(ibot.bestJadwal.printJadwal2());
                        start2 = false;
                    }
                    
                    try {
                        Thread.sleep(speed2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Try.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        tread2.start();
                    
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (speed >= 500){
            speed = speed + 500;
        }
        else
        {   speed = speed + 100;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if (speed2 >= 500){
            speed2 = speed2 + 500;
        }
        else
        {   speed2 = speed2 + 100;
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if (speed2 >= 1000){
            speed2 = speed2 - 500;
        }
        else if (speed2 <= 500)
        {   
            if (speed2-100 <= 0)
            {
                speed2 = 100;
            }
            else
                speed2 = speed2 - 100;
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Try().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

}