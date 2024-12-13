package prac_1213.modifierprac;

public class Person {
    private String name;
    public int age;
    double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    private void run() {
        System.out.println("달리기");
    }

    public void walk() {
        System.out.println("걷기");
    }

    void study() {
        System.out.println("공부하기");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
