package prac_1219.composition.weapon;

public class Character implements SpecialAttackable {
    private Weapon weapon;
    private int healthPoint;

    public Character() {
        this.healthPoint = 100;
    }

    // 무기 소지 여부에 따라 기본 공격 혹은 추가 공격 진행
    public void attack() {
        if(weapon == null) {
            System.out.println("기본 공격");
        } else {
            weapon.extraAttack();
        }
    }

    // 무기 변경 가능
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // 특별 공격
    @Override
    public void specialAttack() {
        System.out.println("스페셜 공격");

        if(weapon instanceof SpecialAttackable) {
            ((SpecialAttackable) weapon).specialAttack();
        }
    }
}
