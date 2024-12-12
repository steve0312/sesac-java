package prac_1210;

import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {
        int number = 10;

        int[] numbers1;
        numbers1 = new int[5];

        // 배열 선언과 초기화 분리
        int[] numbers2;
        numbers2 = new int[]{1, 2, 3, 4, 5};

        // 배열 선언과 동시에 초기화
        int[] numbers3 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.toString(numbers2));
        System.out.println(Arrays.toString(numbers3));

        // 배열 주소 값 비교
        System.out.println(numbers2 == numbers3);
        // 배열 실제 값 비교
        System.out.println(Arrays.equals(numbers2, numbers3));

        System.out.println(numbers1.length);

        char[] chars = {'a', 'b', 'c', 'd'};
        for(int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        System.out.println("======");

        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }
}
