package prac_1218.character;

public class Mage extends Character implements ManaUsable {
    private int mana;
    private static final int MAX_MANA = 100;

    public Mage(String name) {
        super(name);
        this.maxHealth = 70;
        this.health = 70;
        this.mana = 0;
    }

    @Override
    public void attack() {
        System.out.println("공격");

        if(mana == MAX_MANA) {
            manaAttack();
        }
    }

    // 캐릭터간 공격 기능을 다루기 위한 메서드 오버라이딩
    @Override
    public void attack(Character target) {
        System.out.println(name + "-> " + target.name + "에 대해 공격");
        target.takeDamage(20);
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
        maxHealth += 15;
        System.out.println("레벨 업");
    }

    // 기본 마나 상승
    @Override
    public void increaseMana() {
        mana = Math.min(MAX_MANA, mana + 30);
    }

    // 입력 값만큼 마나 상승
    @Override
    public void increaseMana(int amount) {
        mana = Math.min(MAX_MANA, mana + amount);
    }

    // 마나 조회
    @Override
    public int getManaStatus() {
        return mana;
    }

    // 마나가 최대치일 때 마나 공격
    @Override
    public void manaAttack() {
        System.out.println("마나 100% 공격");

        mana = 0;
    }
}
