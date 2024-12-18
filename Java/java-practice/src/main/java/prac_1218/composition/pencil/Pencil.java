package prac_1218.composition.pencil;

public class Pencil {
    private String color;

    public Pencil(String color) {
        this.color = color;
    }

    public void write(String letter) {
        System.out.println(color + "색상으로 " + letter + "를 썼다.");
    }
}
