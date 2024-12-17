package prac_1217.interfaceprac.vehicle;

public class Truck extends Vehicle implements Load {
    private static final int MAX_FUEL = 250;
    private int loadAmount;

    public Truck(String name) {
        super(name);
        this.loadAmount = 0;
    }

    // 엑셀 및 연료 감소량(연비) 메서드 오버라이딩
    @Override
    public void increaseSpeed() {
        if(fuelAmount <= 0) {
            return;
        }

        fuelAmount -= 30;
        speed += 10;

        System.out.println("현재 속도는 " + speed + "이고, 현재 연료량은 " + fuelAmount + "입니다.");
    }

    // 인자로 받은 값만큼 짐의 양 증가
    @Override
    public void addLoad(int amount) {
        loadAmount += amount;
    }

    // 현재 짐의 양 조회
    @Override
    public int getLoadStatus() {
        return loadAmount;
    }

    // 최대 연료량 조회 메서드 오버라이딩
    @Override
    public int getMaxFuel() {
        return MAX_FUEL;
    }
}
