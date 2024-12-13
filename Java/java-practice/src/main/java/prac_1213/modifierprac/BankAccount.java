package prac_1213.modifierprac;

public class BankAccount {
    private int balance;
    private String password;

    // 계좌 생성
    public BankAccount(String password) {
        this.balance = 0;
        this.password = password;
    }

    // 입금
    public void deposit(int money) {
        if(money <= 0) {
            System.out.println("0원 이하의 금액은 입금할 수 없습니다. 입금할 금액을 다시 입력하세요!");
        }

        balance += money;
    }

    // 출금 (비밀번호 확인 필요)
    public void withdraw(int money, String password) {
        if(this.password.equals(password)) {
            if(money <= 0) {
                System.out.println("0원 이하의 금액은 출금할 수 없습니다. 출금할 금액을 다시 입력하세요!");
            } else if (balance < money) {
                System.out.println("잔액이 부족합니다. 출금할 금액을 다시 입력하세요!");
            }

            balance -= money;
        }
    }

    // 잔액 조회 (비밀번호 확인 필요)
    public int getBalance(String password) {
        if(this.password.equals(password)) {
            return balance;
        }

        return -1;
    }
}
