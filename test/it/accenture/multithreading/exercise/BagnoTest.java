package it.accenture.multithreading.exercise;

import static org.junit.jupiter.api.Assertions.*;

class BagnoTest {
    Bagno b = new Bagno();


    @org.junit.jupiter.api.Test
    void prendiRotolo() {
        b.addRotolo(new Rotolo(Colore.BLU));
        b.addRotolo(new Rotolo(Colore.BIANCO));
        b.addRotolo(new Rotolo(Colore.ROSSO));
        b.addRotolo(new Rotolo(Colore.ROSSO));
        b.addRotolo(new Rotolo(Colore.BLU));
        b.addRotolo(new Rotolo(Colore.BLU));

        var x = b.prendiRotolo(Colore.ROSSO);
        assertEquals(5, b.getRotoli().size());
    }
}