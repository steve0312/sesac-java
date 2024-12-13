package prac_1211;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Algorithm");

        sb.reverse();
        String reverseWord = sb.toString();

        System.out.println(reverseWord);
    }
}
