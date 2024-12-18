package prac_1218.composition.pencil;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Pencil 문제 ===");
        Pencil red = new Pencil("빨강");

        Person steve = new Person("스티브", red);
        steve.write("안녕");

        Pencil blue = new Pencil("파랑");
        steve.setPencil(blue);

        Pencil yellow = new Pencil("노랑");
        System.out.println();

        Pencil[] pencils = { red, blue, yellow };
        Person minsu = new Person("민수", pencils);

        minsu.writeMany("반갑소");
    }
}
