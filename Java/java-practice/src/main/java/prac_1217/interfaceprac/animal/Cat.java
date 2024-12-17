package prac_1217.interfaceprac.animal;

public class Cat extends Animal implements Grrable {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void shout() {
        System.out.println("냐옹");
    }

    @Override
    public void grr() {
        System.out.println("그르르");
    }
}
