package prac_1217.interfaceprac.animal;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void shout() {
        System.out.println("왈왈");
    }
}
