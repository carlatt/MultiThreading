package it.accenture.multithreading.exercise;

;

public class Program {
    public static void main(String[] args) {
        Bagno bagno = new Bagno();
        Thread consumerRosso = new Thread(new Consumer(Colore.ROSSO, bagno));
        consumerRosso.setName("Rosso");
        Thread consumerBianco = new Thread(new Consumer(Colore.BIANCO, bagno));
        consumerBianco.setName("Bianco");
        Thread consumerBlu = new Thread(new Consumer(Colore.BLU, bagno));
        consumerBlu.setName("Blu");

        Thread producer = new Thread(new Producer(bagno));

        producer.start();
        consumerRosso.start();
        consumerBianco.start();
        consumerBlu.start();


        try {
            consumerBlu.join();
            consumerBianco.join();
            consumerRosso.join();
            producer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
