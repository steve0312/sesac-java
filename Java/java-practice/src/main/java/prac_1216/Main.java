package prac_1216;

public class Main {
    public static void main(String[] args) {
        BankAccountV2 myAccount = new BankAccountV2("abc123");

        // 입금 및 잔액 조회
        myAccount.deposit(100000);
        myAccount.getBalance("abc123");

        // 출금 및 잔액 조회
        myAccount.withdraw(10000,"abc123");
        myAccount.getBalance("abc123");

        // 틀린 비밀번호 입력
        myAccount.getBalance("hahaha");

        System.out.println("==========");

        // 비밀번호 유효성을 체크해서 계좌 생성 여부 결정
        String myPassword = "abc";
        if(!BankAccountV2.validateInitialPassword(myPassword)) {
            System.out.println("계좌 생성 실패");
        } else {
            new BankAccountV2(myPassword);
        }
    }
}
