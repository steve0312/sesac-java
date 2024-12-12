package prac_1210;

import java.util.Arrays;

/*
DailyAlgo 59번
문제 : 배열 뒤집기
 */
public class Problem59 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        // 배열을 뒤집어서 출력
        for(int i = numbers.length-1; i >= 0; i--) {
            answer[numbers.length-1-i] = numbers[i];
        }

        return answer;
    }
}
