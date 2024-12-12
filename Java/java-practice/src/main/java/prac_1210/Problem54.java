package prac_1210;

import java.util.Arrays;

/*
DailyAlgo 54번
문제 : 배열 회전하기
 */
public class Problem54 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution(numbers, 1)));
    }

    public static int[] solution(int[] numbers, int direction) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            int element = numbers[i];
            int newIndex = (i + direction + numbers.length) % numbers.length;
            answer[newIndex] = element;
        }

        return answer;
    }
}
