package it.accenture.multithreading.exercise;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
    private Bagno bagno;
    private Random random = new Random();
    private int rossi = 0;
    private int bianchi = 0;
    private int blu = 0;

    private int numRotoli = 10;

    public Producer(Bagno bagno) {
        this.bagno = bagno;
    }


    @Override
    public void run() {
        while (rossi<numRotoli | bianchi<numRotoli | blu<numRotoli) {
            int seconds = random.nextInt(5)+1;
            int colorChoose = random.nextInt(3);

            try {
                TimeUnit.SECONDS.sleep(seconds);
                synchronized (bagno){
                    System.out.println("ciao, produco carta igienica");
                    if((rossi < numRotoli) & (colorChoose == 0)){
                        bagno.addRotolo(new Rotolo(Colore.ROSSO));
                        rossi++;
                    } else if ((bianchi < numRotoli) & (colorChoose == 1)) {
                        bagno.addRotolo(new Rotolo(Colore.BIANCO));
                        bianchi++;
                    } else if ((blu < numRotoli) & (colorChoose == 2)){
                        bagno.addRotolo(new Rotolo(Colore.BLU));
                        blu++;
                    } else {
                        System.out.println("else");
                        bagno.notifyAll();
                        continue;
                    }
                    System.out.println("aggiunto");
                    bagno.notifyAll();
                    System.out.println("sbloccato");
                    seconds = random.nextInt(5)+1;
                    TimeUnit.SECONDS.sleep(seconds);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
