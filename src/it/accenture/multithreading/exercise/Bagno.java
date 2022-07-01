package it.accenture.multithreading.exercise;

import java.util.ArrayList;
import java.util.List;

public class Bagno {
    private List<Rotolo> rotoli = new ArrayList<>();

    public Bagno(List<Rotolo> rotoli) {
        this.rotoli = rotoli;
    }

    public Bagno() {}

    public void addRotolo(Rotolo r){
        rotoli.add(r);
    }

    public List<Rotolo> getRotoli() {
        return rotoli;
    }

    public boolean mancaRotolo(Colore colore) {
        return rotoli.stream().filter(rotolo -> rotolo.getColore()==colore).toList().isEmpty();
    }

    public void prendiRotolo(Colore colore) {
        var x = rotoli.stream().filter(rotolo -> rotolo.getColore()==colore).findFirst().get();
        rotoli.remove(x);
        //return x;
    }
}
