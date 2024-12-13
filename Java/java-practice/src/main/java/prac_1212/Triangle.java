package prac_1212;

public class Triangle {
    private int width;
    private int height;

    public Triangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void calculatePerimeter() {
        System.out.println("삼각형의 둘레 길이는 " + (this.width * 3));
    }

    public void calculateArea() {
        System.out.println("삼각형의 넓이는 " + (double)(this.width * this.height)/2);
    }
}
