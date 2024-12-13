package prac_1213.modifierprac;

public class Main {
    public static void main(String[] args) {
        System.out.println("Person 구현 테스트");
        // 사람 인스턴스 생성
        Person p = new Person("sangho", 20, 180);

        // 인스턴스 변수 출력
        System.out.println(p.getName());
        System.out.println(p.age);
        System.out.println(p.height);
        System.out.println();

        // 인스턴스 메서드 출력
//        p.run();
        p.walk();
        p.study();

        System.out.println("==========");

        System.out.println("BankAccount 구현 테스트");
        // 계좌 인스턴스 생성
        BankAccount myAccount = new BankAccount("1234");

        // 계좌 초기 생성 후 틀린 비밀번호로 잔액 조회
        System.out.println("잔액 조회 : " + myAccount.getBalance("123"));
        // 계좌 초기 생성 후 맞는 비밀번호로 잔액 조회
        System.out.println("잔액 조회 : " + myAccount.getBalance("1234"));

        // 0원 입금 시도
        myAccount.deposit(0);

        // 100000원 입금
        myAccount.deposit(100000);
        // 계좌 잔액 조회
        System.out.println("잔액 조회 : " + myAccount.getBalance("1234"));

        // 틀린 비밀번호로 30000원 출금 시도
        myAccount.withdraw(30000, "123");
        System.out.println("잔액 조회 : " + myAccount.getBalance("1234"));
        // 맞는 비밀번호로 30000원 출금 시도
        myAccount.withdraw(30000,"1234");
        System.out.println("잔액 조회 : " + myAccount.getBalance("1234"));

        // 0원 출금 시도
        myAccount.withdraw(0,"1234");

        // 90000원 출금 시도
        myAccount.withdraw(90000, "1234");
    }
}
