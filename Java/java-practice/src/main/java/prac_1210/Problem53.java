package prac_1210;

/*
DailyAlgo 53번
문제 : 특정 구간마다 배열의 원소 선택하기
 */
public class Problem53 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        System.out.println(solution(numbers, 2));
    }

    public static int[] solution(int[] numbers, int step) {
        int[] answer = {};
        int[] temp = new int[numbers.length];
        int count = 0;

        for(int i = 0; i < numbers.length; i += step) {
            temp[count] = numbers[i];
            count++;
        }

        answer = new int[count];

        for(int i = 0; i < count; i++) {
            answer[i] = temp[i];
        }

        return answer;
    }
}
