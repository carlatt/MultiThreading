package it.accenture.multithreading.deadlock;

import java.util.concurrent.TimeUnit;

public class ResourceOne {
    private String s1 = "Pippo";
    private  String s2 = "Pluto";
    private int c1;
    private int c2;
    public void m1(){
        if (c1>2){
            return;
        }
        c1++;
        synchronized (s1){
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("in m1 exiting sleep");
                m2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void m2(){
        if (c2>2){
            return;
        }
        c2++;
        synchronized (s2){
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("in m2 exiting sleep");
                m1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
