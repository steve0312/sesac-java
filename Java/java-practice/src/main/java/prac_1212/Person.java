package prac_1212;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void personInfo() {
        System.out.println("이름은 " + this.name + "이고, 나이는 " + this.age + "입니다.");
    }
}
