package prac_1223.exceptionprac;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(0 / 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
            System.out.println("error!");
        }

        try {
            // 문제 상황이 발생했다고 가정
            if(true) {
                throw new RuntimeException("error message");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("runtime error!");
        }

        try {
            func();
        } catch(RuntimeException e) {
            System.out.println("error in func");
        }
    }
//    public static void func() throws RuntimeException {
    public static void func() {
        System.out.println("func 실행");

        throw new RuntimeException("func error");
    }
}
