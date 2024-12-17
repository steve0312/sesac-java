package prac_1216.inheritanceprac;

public class Mage extends Character {
    private int mana;
    private static final int MAX_MANA = 100;

    public Mage(String name) {
        super(name);
        this.health = 70;
        this.maxHealth = 70;
        this.mana = 0;
    }

    @Override
    public void attack() {
        System.out.println("공격!");

        mana -= 10;

        if(mana >= 50) {
            System.out.println("필살기 공격!");
        }
    }

    public void manaUp() {
        mana += 50;
        System.out.println("마나 상승!");
    }

    @Override
    public void levelUp() {
        super.levelUp();
        maxHealth += 15;
        health += 15;
    }
}
