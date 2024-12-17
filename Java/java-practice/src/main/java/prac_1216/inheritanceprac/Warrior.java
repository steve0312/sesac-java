package prac_1216.inheritanceprac;

public class Warrior extends Character {
    private int rage;
    private static final int MAX_RAGE =100;

    public Warrior(String name) {
        super(name);
        this.health = 120;
        this.maxHealth = 120;
        this.rage = 0;
    }

    // 공격 시에도 분노게이지 상승 및 분노 공격 가능
    @Override
    public void attack(){
        System.out.println("공격!");
        rage += 10;

        if (rage >= 50){
            System.out.println("분노 공격!");
        }

    }

    public void rageUp(){
        rage += 50;
        System.out.println("분노게이지 상승!");
    }

    // 전사에 적합하게 레벨업 메서드 오버라이딩
    @Override
    public void levelUp(){
        super.levelUp();
        maxHealth += 30;
        health += 30;
    }
}