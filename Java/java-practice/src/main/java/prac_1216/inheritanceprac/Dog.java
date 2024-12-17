package prac_1216.inheritanceprac;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void shout() {
        System.out.println(name + "가 짖는다.");
    }
}
