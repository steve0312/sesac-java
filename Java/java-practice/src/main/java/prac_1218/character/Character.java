package prac_1218.character;

public abstract class Character {
    protected String name;
    protected int level;
    protected int health;   // 현재 체력을 확인하기 위한 변수
    protected int maxHealth;    // 레벨업에서 사용하기 위한 변수

    public Character(String name) {
        this.name = name;
        this.level = 1;
    }

    // 레벨업
    public abstract void levelUp();
    public abstract void attack();

    // 캐릭터간 공격 기능을 다루기 위한 메서드
    public abstract void attack(Character character);
    public abstract void takeDamage(int amount);

    // 캐릭터의 현재 상태 조회
    public void showInfo() {
        System.out.println("현재 레벨 : " + level);
        System.out.println("현재 체력 : " + health);
    }
}
