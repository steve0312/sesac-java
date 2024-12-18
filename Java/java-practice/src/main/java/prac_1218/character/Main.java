package prac_1218.character;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Warrior1 ===");
        Warrior warrior = new Warrior("워리어1");

        warrior.attack();
        warrior.increaseRage(100);
        warrior.attack();
        warrior.showInfo();

        System.out.println("=== Mage ===");
        Mage mage = new Mage("메이지");
        mage.showInfo();

        System.out.println("=== Warrior2 ===");
        Warrior warrior2 = new Warrior("워리어2");

        warrior.attack(warrior2);
        warrior.attack(mage);
        mage.showInfo();
    }
}
