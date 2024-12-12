package prac_1210;

import java.util.Arrays;

/*
DailyAlgo 58번
문제 : 배열 자르기
 */
public class Problem58 {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 6};
        System.out.println(Arrays.toString(solution(numbers, 0, 2)));
    }

    public static int[] solution(int[] numbers, int start, int end) {
        int[] answer = new int[end - start + 1];

//        for(int i = 0; i < numbers.length; i++) {
//            if(start < i && i <= end) {
//                answer[i] = numbers[i];
//            }
//        }

        for(int i = start; i <= end; i++) {
            answer[i - start] = numbers[i];
        }

        return answer;
    }
}
