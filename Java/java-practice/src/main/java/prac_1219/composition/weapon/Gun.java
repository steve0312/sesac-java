package prac_1219.composition.weapon;

public class Gun extends Weapon implements SpecialAttackable {
    public Gun() {
//        super();
        this.setAttackPower(50);
        this.setStrength(100);
    }

    // 추가 공격
    @Override
    public void extraAttack() {
        System.out.println("총으로 추가 공격");

        this.setStrength(this.getStrength() - this.getAttackPower());
    }

    // 특별 공격
    @Override
    public void specialAttack() {
        System.out.println("필살기 : 개틀링건 발사!");
    }
}
