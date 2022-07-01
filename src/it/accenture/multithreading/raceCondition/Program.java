package it.accenture.multithreading.raceCondition;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        List<String> ls = new ArrayList<>();
        Consumer c = new Consumer(ls);
        Thread consumerThread = new Thread(c);
        Producer p = new Producer(ls);
        Thread producerThread = new Thread(p);
        producerThread.setName("PR");
        Thread consumer2 = new Thread(new Consumer(ls));
        consumerThread.setName("C1");
        consumer2.setName("C2");
        //producerThread.setDaemon(true);
        //consumerThread.setDaemon(true);
        //consumer2.setDaemon(true);
        consumerThread.start();
        consumer2.start();
        producerThread.start();

        producerThread.join();
        consumer2.join();
        consumerThread.join();
        System.out.println(ls.size());

    }
}
