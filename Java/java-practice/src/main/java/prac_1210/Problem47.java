package prac_1210;

/*
DailyAlgo 47번
문제 : 배열 원소의 최대값 찾기
 */
public class Problem47 {
    public static void main(String[] args) {
        int[] numbers = {-401, -2, 0, -11, -120};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        int maxNum = 0;

        for (int number : numbers) {
            if(number > maxNum) {
                maxNum = number;
            }
        }

        answer = maxNum;

        return answer;
    }
}
