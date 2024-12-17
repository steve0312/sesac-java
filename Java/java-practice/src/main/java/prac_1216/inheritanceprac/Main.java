package prac_1216.inheritanceprac;

public class Main {
    public static void main(String[] args) {
        Person.introduce();
        Student.introduce();

        Student s = new Student();
        s.study();

        System.out.println("==========");

        System.out.println("=== Parent 인스턴스 ===");
        Parent parent = new Parent("Parent Public value");
        System.out.println(parent.publicValue);
//        System.out.println(parent.parentValue);
        System.out.println(parent.protectedValue);
        parent.publicMethod();

        System.out.println("=== Child 인스턴스 ===");
        Child child = new Child("Child Public value");
        System.out.println(child.publicValue);
//        System.out.println(child.privateValue);
        System.out.println(child.protectedValue);
        child.publicMethod();
        child.childMethod();

        System.out.println("============");

        System.out.println("Animal 문제 구현");
        Animal ani = new Animal("덕덕", 5);
        ani.shout();

        Dog d = new Dog("댕댕이", 7, "시바견");
        d.shout();

        Cat c = new Cat("냥냥이", 3);
        c.shout();
        c.sick();

        System.out.println("============");

        System.out.println("Vehicle 문제 구현");

        Vehicle avante = new Vehicle("Avante");
        avante.addFuel(20);
        avante.increaseSpeed(19);
        System.out.println(avante.speed);
        System.out.println(Vehicle.MAX_FUEL);


        System.out.println();
        System.out.println("Bus");

        Bus county = new Bus("County");
        county.addFuel(30);
        county.increaseSpeed(13);
        System.out.println("county.speed = " + county.speed);
        System.out.println("Bus.MAX_FUEL = " + Bus.MAX_FUEL);
        System.out.println("county.addPassenger(3) = " + county.addPassenger(3));
        county.addFuel(400);
        System.out.println("county.fuel = " + county.fuel);

        System.out.println("============");

        System.out.println("Character 문제 구현");

        Character basic = new Character("basic");
        basic.attack();

        Warrior warrior = new Warrior("Warrior");
        System.out.println(warrior.health);
        warrior.attack();
        warrior.rageUp();
        warrior.attack();

        Mage mage = new Mage("Mage");
        System.out.println(mage.health);
        mage.attack();
        mage.manaUp();
        mage.attack();
    }
}
