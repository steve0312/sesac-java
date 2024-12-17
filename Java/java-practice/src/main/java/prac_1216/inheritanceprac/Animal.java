package prac_1216.inheritanceprac;

public class Animal {
    protected String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void shout() {
        System.out.println("소리치다.");
    }
}
