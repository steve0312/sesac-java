package prac_1219.composition.engine;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Engine 문제 ===");
        Engine e10 = new Engine(120);
        Engine e20 = new Engine(180);

        Car avante = new Car("아반떼", e10);
        System.out.println("현재 속도 : " + avante.getSpeed());
        avante.accelerate();
        System.out.println("현재 속도 : " + avante.getSpeed());
        System.out.println();

        Car sportage = new Car("스포티지", e20);
        System.out.println("현재 속도 : " + sportage.getSpeed());
        sportage.accelerate();
        System.out.println("현재 속도 : " + sportage.getSpeed());
    }
}
