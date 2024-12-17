package prac_1216.inheritanceprac;

public class Child extends Parent {
    public String childValue = "child value";

    // 부모 클래스의 생성자를 따라한 자식 클래스 생성자
    public Child(String publicValue) {
        super(publicValue);
    }

    public Child(String publicValue, String childValue) {
        super(publicValue);
        this.childValue = childValue;
    }

    public void childMethod() {
        System.out.println("child method");
    }

    @Override
    public void publicMethod() {
        super.publicMethod();
        System.out.println("Child public method");
    }
}
