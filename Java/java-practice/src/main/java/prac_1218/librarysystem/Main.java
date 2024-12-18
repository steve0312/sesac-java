package prac_1218.librarysystem;

public class Main {
    public static void main(String[] args) {
        Ebook ebook = new Ebook("자바 완전 정복");
        ebook.dataLoan();
        ebook.download();
        ebook.dataReturn();
    }
}
