package prac_1216.inheritanceprac;

public class Vehicle {
    protected String modelName;
    protected int speed;
    protected int fuel;
    protected static final int MAX_FUEL = 100;

    public Vehicle(String modelName) {
        this.modelName = modelName;
        this.speed = 0;
        this.fuel = 0;
    }

    // 엑셀
    public int increaseSpeed(int amount){
        if (amount <= fuel){
            speed += amount;
            fuel -= amount;
        }
        return speed;
    }

    // 연료 주입
    public int addFuel(int amount) {
        fuel += amount;
        if (fuel > getMaxFuel()){
            fuel = getMaxFuel();
        }
        return fuel;
    }

    // 최대 연료량 조회
    public int getMaxFuel(){
        return MAX_FUEL;
    }
}