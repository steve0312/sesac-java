package prac_1217.interfaceprac.vehicle;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 버스 ===");
        Bus bus = new Bus("마을버스");

        bus.addPassenger(3);
        System.out.println("현재 승객 수 : " + bus.getPassengerStatus());

        bus.increaseFuel(100);
        bus.increaseSpeed();

        System.out.println("=== 트럭 ===");
        Truck truck = new Truck("봉고");

        truck.addLoad(30);
        System.out.println("현재 짐의 양 : " + truck.getLoadStatus());

        truck.increaseFuel(70);
        truck.increaseSpeed();;
    }
}
