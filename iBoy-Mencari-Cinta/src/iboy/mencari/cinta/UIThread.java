package iboy.mencari.cinta;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UIThread extends Thread {
    public int time = 1000;
    public boolean running=true;
    
    public void run() {
        while (running) { 
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(UIThread.class.getName()).log(Level.SEVERE, null, ex);
            }
         //ibot.geneticAlgo(100000);
         
           
       } 
    }
    
    public void pause(){
        running = false;
    }
    
    public void play(){
        running = true;
    }
    
    public void speedUp(){
        if (time>0){
            time-=200;
        }
    }
    
    public void speedDown(){
        if (time<2000){
            time+=200;
        }
    }
}
