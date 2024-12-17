package prac_1217.interfaceprac.vehicle;

public abstract class Vehicle {
    private String name;
    protected int speed;
    protected int fuelAmount;
    private final int MAX_FUEL = 100;

    public Vehicle(String name) {
        this.name = name;
        this.speed = 0;
        this.fuelAmount = 0;
    }

    // 엑셀을 밟고 연료 감소되는 건 차량 종류에 따라 달라질 수 있으므로(연비) 추상 메서드로 표현
    public abstract void increaseSpeed();

    // 연료 주입
    public void increaseFuel(int amount) {
        fuelAmount += amount;

        if(fuelAmount >= getMaxFuel()) {
            fuelAmount = getMaxFuel();
        }
    }

    // 최대 연료량 조회
    public int getMaxFuel() {
        return MAX_FUEL;
    }
}
