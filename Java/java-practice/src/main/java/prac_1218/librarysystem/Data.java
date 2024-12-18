package prac_1218.librarysystem;

public abstract class Data {
    protected String title;
    private int dataId;
    protected boolean isLoanAvailable;

    public Data(String title) {
        this.title = title;
        this.dataId++;
        this.isLoanAvailable= true;
    }

    public abstract void dataLoan();
    public abstract void dataReturn();
}
