package prac_1217.interfaceprac.vehicle;

public class Bus extends Vehicle implements Passenger {
    private static final int MAX_FUEL = 300;
    private int passengerNum;

    public Bus(String name) {
        super(name);
        this.passengerNum = 0;
    }

    // 엑셀 및 연료 감소량(연비) 메서드 오버라이딩
    @Override
    public void increaseSpeed() {
        if(fuelAmount <= 0) {
            return;
        }

        fuelAmount -= 50;
        speed += 10;

        System.out.println("현재 속도는 " + speed + "이고, 현재 연료량은 " + fuelAmount + "입니다.");
    }

    // 인자로 받은 값만큼 승객 수 증가
    @Override
    public void addPassenger(int amount) {
        passengerNum += amount;
    }

    // 현재 승객 수 조회
    @Override
    public int getPassengerStatus() {
        return passengerNum;
    }

    // 최대 연료량 조회 메서드 오버라이딩
    @Override
    public int getMaxFuel() {
        return MAX_FUEL;
    }
}
