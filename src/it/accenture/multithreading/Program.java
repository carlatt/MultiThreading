package it.accenture.multithreading;

public class Program {
    public static void main(String[] args) {
        GoodNightThread t = new GoodNightThread();
        Thread t2 = new Thread(new GoodAfternoonRunnable());
        //t.setPriority(Thread.MAX_PRIORITY);
        t.start();
        t2.start();

        Thread t3 = new Thread(()->{
            for (int i = 0; i<1000; i++){
                System.out.println("hello lambda");
            }
        });

        t3.start();
        try {
            Thread.sleep(5000);
            t.terminate();
            for (int i=0; i<10000;i++){
                System.out.println("hello world "+i);
                //Thread.yield();

            }
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
