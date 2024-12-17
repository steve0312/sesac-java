package prac_1216.inheritanceprac;

public class Bus extends Vehicle {
    protected static final int MAX_FUEL = 300;
    protected int passengerCount;

    public Bus(String modelName) {
        super(modelName);
        this.passengerCount = 0;
    }

    // 승객 탑승
    public int addPassenger(int amount){
        passengerCount += amount;
        return passengerCount;
    }

    // 최대 연료량 조회
    @Override
    public int getMaxFuel(){
        return MAX_FUEL;
    }
}