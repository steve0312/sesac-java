package prac_1212;

public class Car {
    private String modelName;
    private int speed;

    public Car(String modelName) {
        this.modelName = modelName;
    }

    public int speedUp() {
        return this.speed += 10;
    }

    public int speedDown() {
        if(this.speed != 0) {
            this.speed -= 10;
        }
        return this.speed;
    }

    public void carInfo() {
        System.out.println("모델명은 " + this.modelName + "이고, 현재 속도는 " + this.speed + "입니다.");
    }
}
