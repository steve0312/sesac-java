package prac_1218.librarysystem;

public class Pbook extends Book implements CallNumberUsable {
    private String callNumber;

    public Pbook(String title, String callNumber) {
        super(title);
        this.callNumber = callNumber;
    }

    // 대출 메서드 오버라이딩
    @Override
    public void dataLoan() {
        if(!isLoanAvailable) {
            System.out.println("이미 대출 중인 도서입니다.");
            return;
        }

        isLoanAvailable = false;
        System.out.println(title + " : 대출되었습니다.");
    }

    // 반납 메서드 오버라이딩
    @Override
    public void dataReturn() {
        isLoanAvailable = true;
        System.out.println(title + " : 반납되었습니다.");
    }

    // 청구기호 조회 메서드 오버라이딩 (전자책은 물리적 위치 정보가 필요없어서 종이책에서만 구현)
    @Override
    public String getCallNumber() {
        return callNumber;
    }
}
