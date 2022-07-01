package it.accenture.multithreading.raceCondition;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private final List<String> data;
    private final Random random;

    public Consumer(List<String> data) {
        this.data = data;
        this.random = new Random();
    }

    @Override
    public void run() {
        int n = 0;
        String name = Thread.currentThread().getName();
        while (n < 10) {
            int seconds = random.nextInt(6);
            try {
                TimeUnit.SECONDS.sleep(seconds);
                synchronized (data) {
                    while (data.isEmpty()) {
                        System.out.println(name+" entering wait");
                        data.wait();
                        System.out.println(name+" exiting wait");
                        //System.out.println("Bad luck: no data");
                    }
                    String s = data.remove(0);
                    System.out.println(s + " " + n);
                    n++;

                }


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

