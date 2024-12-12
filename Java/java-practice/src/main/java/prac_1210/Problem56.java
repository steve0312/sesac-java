package prac_1210;

import java.util.Arrays;

/*
DailyAlgo 56번
문제 : 배열의 덧셈
 */
public class Problem56 {
    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3};
        int[] numbers2 = {4, 5, 6};

        System.out.println(Arrays.toString(solution(numbers1, numbers2)));

    }

    public static int[] solution(int[] numbers1, int[] numbers2) {
        int[] answer = new int[numbers1.length + numbers2.length];

        for(int i = 0; i < numbers1.length + numbers2.length; i++) {
            if(i < numbers1.length) {
                answer[i] = numbers1[i];
            } else {
                answer[i] = numbers2[i-numbers1.length];
            }
        }

        return answer;
    }
}
