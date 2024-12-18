package prac_1218.librarysystem;

public class Ebook extends Book implements Downloadable {
    private boolean isDownloadAvailable;

    public Ebook(String title) {
        super(title);
        this.isDownloadAvailable = false;
    }

    // 대출 메서드 오버라이딩
    @Override
    public void dataLoan() {
        if(!isLoanAvailable) {
            System.out.println("이미 대출 중인 도서입니다.");
            return;
        }

        isLoanAvailable = false;
        isDownloadAvailable = true;
        System.out.println(title + " : 대출되었습니다.");
    }

    // 반납 메서드 오버라이딩
    @Override
    public void dataReturn() {
        isLoanAvailable = true;
        isDownloadAvailable = false;
        System.out.println(title + " : 반납되었습니다.");
    }

    @Override
    public void download() {
        if(isDownloadAvailable) {
            System.out.println(title + " : 다운로드되었습니다.");
        }
    }
}
