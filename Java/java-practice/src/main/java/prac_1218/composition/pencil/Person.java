package prac_1218.composition.pencil;

public class Person {
    private String name;
    private Pencil pencil;
    private Pencil[] pencils;

    public Person(String name, Pencil pencil) {
        this.name = name;
        this.pencil = pencil;
    }

    public Person(String name, Pencil[] pencils) {
        this.name = name;
        this.pencils = pencils;
    }

    public void write(String letter) {
        pencil.write(letter);
    }

    public void writeMany(String letter) {
        for (Pencil p : pencils) {
            p.write(letter);
        }
    }

    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }
}
