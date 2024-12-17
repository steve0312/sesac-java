package prac_1217.interfaceprac.animal;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Animal 문제 ===");

        Dog dog = new Dog("해피", 10,"시바견");
        dog.shout();

        Cat cat = new Cat("인절미", 3);
        cat.shout();
        cat.grr();

        makeThemSound(dog);
        makeThemSound(cat);
    }

    public static void makeThemSound(Animal animal) {
        System.out.println("소리내봐");
        animal.shout();
    }
}
