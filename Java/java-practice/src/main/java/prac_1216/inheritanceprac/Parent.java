package prac_1216.inheritanceprac;

public class Parent {
    public String publicValue = "public value";
    private String privateValue = "private value";
    protected String protectedValue = "protected value";

    public Parent(String publicValue) {
        this.publicValue = publicValue;
    }

    public void publicMethod() {
        System.out.println("Parent public method");
    }
}
