package prac_1212;

public class Main {
    public static void main(String[] args) {
        // 사람 인스턴스 생성
        Person p = new Person("상호", 20);
        // 사람 정보 출력
        p.personInfo();

        System.out.println("=======");

        // 강아지 인스턴스 생성
        Dog d1 = new Dog("시바견","시바");
        // 앉기 명령 전달
        d1.seat();
        // 손달라는 명령 전달
        d1.hand();

        System.out.println("=======");

        // 정삼각형 인스턴스 생성
        Triangle t = new Triangle(3, 5);
        // 삼각형의 둘레 계산
        t.calculatePerimeter();
        // 삼각형의 넓이 계산
        t.calculateArea();

        System.out.println("=======");

        // 자동차 아반떼 인스턴스 생성
        Car c = new Car("Avante");

        // 가속 3번
        c.speedUp();
        c.speedUp();
        c.speedUp();

        // 감속 1번 (브레이크)
        c.speedDown();

        // 최종 자동차 정보 출력
        c.carInfo();

        System.out.println("=======");

        // MP3플레이어 iPod 인스턴스 생성
        MP3Player mp = new MP3Player("iPod");

        // MP3가 꺼져있으므로 켬
        mp.pushPowerButton();

        // 볼륨 3번 증가
        mp.volumeUp();
        mp.volumeUp();
        mp.volumeUp();
        mp.volumeUp();

        // 볼륨 1번 감소
        mp.volumeDown();

        // MP3 플레이어 정보 출력
        mp.MP3Info();

        // MP3가 켜져있으므로 끔
        mp.pushPowerButton();
        // MP3 플레이어 정보 출력
        mp.MP3Info();

        System.out.println("=======");

        // 계산기 인스턴스 생성
        Calculator cl = new Calculator(8, 5, "/");

        // 계산 결과 출력
        cl.binaryOperate();

        System.out.println("=======");

        // 메서드에만 값을 전달하는 계산기 인스턴스 생성
        Calculator2 c2 = new Calculator2();

        System.out.println(c2.add(10, 4));
        System.out.println(c2.minus(30, 12));
        System.out.println(Calculator2.staticAdd(10, 15));

        System.out.println("=======");

        // 사각형 인스턴스 생성
        Rectangle rec1 = new Rectangle(10, 4);
        System.out.println(Rectangle.angleCount);
        // 근데 아래와 같이 쓰면 인스턴스 변수인지 클래스 변수인지 헷갈리므로 위에 처럼 쓰는 것이 보통
        System.out.println(rec1.angleCount);

        System.out.println("=======");

        // 개체 수 데이터를 포함하는 Dog 인스턴스 생성
        Dog d2 = new Dog("푸들", "뽀삐");
        System.out.println(Dog.count);

        Dog d3 = new Dog("허스키", "스키");
        System.out.println(Dog.count);
    }
}
