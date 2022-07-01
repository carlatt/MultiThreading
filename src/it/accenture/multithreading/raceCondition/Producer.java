package it.accenture.multithreading.raceCondition;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
    private List<String> data;
    private Random random;

    public Producer(List<String> data) {
        this.data = data;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int seconds = random.nextInt(6);
            try {
                TimeUnit.SECONDS.sleep(seconds);
                synchronized (data){
                    data.add("Pippo con gusto");
                    System.out.println("aggiunto");
                    data.notifyAll();
                    System.out.println("sbloccato");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
