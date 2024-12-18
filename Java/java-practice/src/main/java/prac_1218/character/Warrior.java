package prac_1218.character;

public class Warrior extends Character implements RageUsable {
    private int rage;
    private static final int MAX_RAGE = 100;

    public Warrior(String name) {
        super(name);
        this.health = 120;
        this.maxHealth = 120;
        this.rage = 0;
    }

    @Override
    public void attack() {
        System.out.println("공격");

        increaseRage();

        if(rage ==  MAX_RAGE) {
            rageAttack();
        }
    }

    // 캐릭터간 공격 기능을 다루기 위한 메서드 오버라이딩
    @Override
    public void attack(Character target) {
        System.out.println(name + "-> " + target.name + " 공격");
        target.takeDamage(30);
    }

    // 공격했을 떄 데미지 처리
    @Override
    public void takeDamage(int amount) {
        health -= amount;
    }

    // 레벨업
    @Override
    public void levelUp() {
        level += 1;
        maxHealth += 30;
        System.out.println("레벨 업");
    }

    // 기본 분노 상승
    @Override
    public void increaseRage() {
        rage = Math.min(MAX_RAGE, rage + 10);
    }

    // 입력 값만큼 분노 상승
    @Override
    public void increaseRage(int amount) {
        rage = Math.min(MAX_RAGE, rage + amount);
    }

    // 분노 게이지 조회
    @Override
    public int getRageStatus() {
        return rage;
    }

    // 분노 게이지 최대치일 때 분노 공격
    @Override
    public void rageAttack() {
        System.out.println("분노 100% 공격");
        rage = 0;
    }
}
