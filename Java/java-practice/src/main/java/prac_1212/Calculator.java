package prac_1212;

public class Calculator {
    private int x;
    private int y;
    private String operator;

    public Calculator(int x, int y, String operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }

    public void binaryOperate() {
        switch(this.operator) {
            case "+":
                System.out.println(this.x + this.y);
                break;
            case "-":
                System.out.println(this.x - this.y);
                break;
            case "*":
                System.out.println(this.x * this.y);
                break;
            case "/":
                System.out.println((double)this.x / this.y);
                break;
        }
    }
}
