package it.accenture.multithreading.exercise;

public class Consumer implements Runnable{
    private Colore colore;
    private int rotoliConsumati = 0;
    private Bagno bagno;

    public Consumer(Colore colore, Bagno bagno) {
        this.colore = colore;
        this.bagno = bagno;
    }

    @Override
    public void run() {
        int n = 0;
        String name = Thread.currentThread().getName();
        while (n < 10) {
            try {
                synchronized (bagno) {
                    while (bagno.mancaRotolo(colore)) {
                        System.out.println(name+" entering wait");
                        bagno.wait();
                        System.out.println(name+" exiting wait");
                        //System.out.println("Bad luck: no data");
                    }
                    bagno.prendiRotolo(colore);
                    System.out.println("Usato rotolo "+colore);
                    n++;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
