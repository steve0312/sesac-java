package prac_1219.composition.weapon;

public abstract class Weapon implements Attackable {
    // 공격력
    private int attackPower;
    // 내구력
    private int strength;

    public Weapon() {
        this.attackPower = 0;
        this.strength = 0;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    // 추가 공격
    public abstract void extraAttack();
}
