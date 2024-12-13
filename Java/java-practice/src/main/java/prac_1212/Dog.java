package prac_1212;

public class Dog {
    // 개체 수는 공통 데이터 개념이므로 정적 변수로 선언
    static int count;
    private String breed;
    private String name;

    public Dog(String breed, String name) {
        this.breed = breed;
        this.name = name;
        count++;
    }

    public void seat() {
        System.out.println("견종이 " + this.breed + "인 " + this.name + "는 앉았다.");
    }

    public void hand() {
        System.out.println("견종이 " + this.breed + "인 " + this.name + "는 손을 줬다.");
    }
}
