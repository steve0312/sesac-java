package prac_1219.composition.weapon;

public class Main {
    public static void main(String[] args) {
        Character character = new Character();

        Gun gun = new Gun();
        Sword sword = new Sword();

        // 무기 없이 공격
        character.attack();

        // 총을 가지고 공격
        character.setWeapon(gun);
        character.attack();

        // 검으로 공격
        character.setWeapon(sword);
        character.attack();
    }
}
