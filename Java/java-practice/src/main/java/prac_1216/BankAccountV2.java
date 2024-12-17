package prac_1216;

public class BankAccountV2 {
    private int balance;
    private String password;

    public BankAccountV2(String password) {
        this.password = password;
        this.balance = 0;
    }

    // 입금
    public void deposit(int amount) {
        if(!validateAmount(amount)) {
            System.out.println("입금 불가합니다.");
            return;
        }

        balance += amount;
        System.out.println(amount + "원이 입금됨");
    }

    // 출금 (비밀번호 확인 필요)
    public void withdraw(int amount, String password) {
        // 비밀번호 확인
        if(!validatePassword(password)) {
            return;
        }

        // 금액 확인
        if(!validateAmount(amount)) {
            System.out.println("출금 불가합니다.");
            return;
        }

        // 출금하려는 금액이 잔고보다 큰 경우
        if(amount > balance) {
            return;
        }

        balance -= amount;
    }

    // 잔액 조회 (비밀번호 확인 필요)
    public int getBalance(String password) {
        // 비밀번호 확인
        if(!validatePassword(password)) {
            // 첫 번째 처리 방법 : 의미 없는 값을 return
            System.out.println("비밀번호가 일치하지 않습니다.");
            return -1;
            // 두 번째 처리 방법 : 에러 핸들링
        }

        System.out.println(balance);
        return balance;
    }

//    private boolean validateAmount(int amount, int minAmount) {
//        if(amount > minAmount) {
    // 입금된 금액이 적절한지(0원보다 큰 지) 체크
    private boolean validateAmount(int amount) {
        if(amount > 0) {
            return true;
        } else {
            System.out.println("0원 이하의 금액은 불가능합니다.");
            return false;
        }
    }

    // 입력한 비밀번호가 적절한지 체크
    private boolean validatePassword(String password) {
//        if(this.password.equals(password)) {
//            return true;
//        } else {
//            return false;
//        }
        return this.password.equals(password);
    }

    // 생성 시 비밀번호 유효성 체크 (이미 존재하는 비밀번호인지?)
    // 체크 조건 : length가 3이하면 실패, 4 이상이면 성공
    public static boolean validateInitialPassword(String password) {
        if(password.length() >= 4) {
            return true;
        } else {
            System.out.println("입력된 비밀번호가 짧습니다. 4자리 이상의 비밀번호를 입력해주세요.");
            return false;
        }
    }
}
