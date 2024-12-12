package prac_1210;

import java.util.Arrays;

/*
DailyAlgo 57번
문제 : 배열의 곱셈
 */
public class Problem57 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        System.out.println(Arrays.toString(solution(numbers, 3)));
    }

    public static int[] solution(int[] numbers, int n) {
        int[] answer = new int[numbers.length * n];
        int index = 0;

        // 내 풀이1
//        for(int i = 0; i < n; i++) {
//            for (int number : numbers) {
//                answer[index] = number;
//                index++;
//            }
//        }

        // 내 풀이2
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < numbers.length; j++) {
                answer[j+(numbers.length*i)] = numbers[j];
            }
        }

        return answer;
    }
}
