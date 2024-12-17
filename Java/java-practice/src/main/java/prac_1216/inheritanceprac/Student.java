package prac_1216.inheritanceprac;

public class Student extends Person {
//    String name;
//    int age;
    int studentNum;

    // 오버라이드 된 메서드
    public static void introduce() {
        System.out.println("hello i'm student");
    }

    public void study() {
        System.out.println("studying");
    }
}
