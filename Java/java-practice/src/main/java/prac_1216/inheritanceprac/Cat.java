package prac_1216.inheritanceprac;

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void sick() {
        System.out.println(name + "가 아프다.");
    }

    @Override
    public void shout() {
        System.out.println(name + "가 냐옹한다.");
    }
}
