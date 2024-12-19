package prac_1219.composition.weapon;

public class Sword extends Weapon implements SpecialAttackable {
    public Sword() {
//        super();
        this.setAttackPower(30);
        this.setStrength(150);
    }

    // 추가 공격
    @Override
    public void extraAttack() {
        System.out.println("검으로 추가 공격");

        this.setStrength(this.getStrength() - this.getAttackPower());
    }

    // 특별 공격
    @Override
    public void specialAttack() {
        System.out.println("필살기 : 삼단 베기!");
    }
}
