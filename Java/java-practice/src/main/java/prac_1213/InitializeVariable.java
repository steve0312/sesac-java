package prac_1213;

public class InitializeVariable {
    public static void main(String[] args) {
        // 인스턴스 변수에 명시적인 초기화
        V1 v1 = new V1();
        System.out.println(v1.value);

        System.out.println("=======");

        // 인스턴스 변수에 생성자를 통한 초기화
        V2 v2 = new V2();
        System.out.println(v2.value);

        System.out.println("=======");

        // 인스턴스 변수에 초기화 블록을 통한 초기화
        V3 v3 = new V3();
        System.out.println(v3.value);
    }
}

class V1 {
    // 명시적인 초기화
    static int staticValue = 30;
    int value = 10;
    String word = "Text";

}

class V2 {
    int value;
    String word;

    // 생성자를 통한 초기화
    public V2() {
        this(10, "Text");
    }

    public V2(int value, String word) {
        this.value = value;
        this.word = word;
    }
}

class V3 {
    static int staticValue;

    int value;
    String word;

    // static 초기화 블록
    static {
        if(true) {
            staticValue = 30;
        } else {
            staticValue = 50;
        }
    }

    // 인스턴스 초기화 블록
    {
        if(true) {
            this.value = 10;
        } else {
            this.value = 0;
        }

        this.word = "Text";
    }
}