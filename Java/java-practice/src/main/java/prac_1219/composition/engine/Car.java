package prac_1219.composition.engine;

public class Car {
    private String modelName;
    private Engine engine;
    private int speed;

    public Car(String modelName, Engine engine) {
        this.modelName = modelName;
        this.engine = engine;
        this.speed = 0;
    }

    public void accelerate() {
        System.out.println("가속을 시작합니다.");

        int amount = engine.getHorsePower()/10;
        speed += (amount + 10);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
