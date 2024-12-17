package prac_1217.interfaceprac;

import prac_1217.interfaceprac.animal.Animal;
import prac_1217.interfaceprac.animal.Cat;
import prac_1217.interfaceprac.animal.Dog;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.calculateArea());

        Shape rectangle2 = new Rectangle();

        Triangle triangle = new Triangle();
        System.out.println(triangle.calculateArea());
    }
}