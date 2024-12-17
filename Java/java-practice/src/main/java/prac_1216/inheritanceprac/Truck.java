package prac_1216.inheritanceprac;

public class Truck extends Vehicle {
    protected static final int MAX_FUEL = 250;
    protected int loadCount;

    public Truck(String modelName) {
        super(modelName);
        this.loadCount = 0;
    }

    // 짐 상차
    public int addLoad(int amount) {
        loadCount += amount;
        return loadCount;
    }

    // 최대 연료량 조회
    @Override
    public int getMaxFuel() {
        return MAX_FUEL;
    }
}
