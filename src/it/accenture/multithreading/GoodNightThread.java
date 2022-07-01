package it.accenture.multithreading;

public class GoodNightThread extends Thread {
    private volatile boolean mustContinue = true;
    @Override
    public void run() {
        for (int i = 0; i < 10000 && mustContinue; i++) {
            System.out.println("    good night world " + i);
            //Thread.yield();

        }
    }

    public void terminate(){
        mustContinue = false;
    }
}
