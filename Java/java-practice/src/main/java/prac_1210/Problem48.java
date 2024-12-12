package prac_1210;

/*
DailyAlgo 48번
문제 : 배열 원소의 총합 구하기
 */
public class Problem48 {
    public static void main(String[] args) {
        int[] numbers = {-200, -10, 0, 10, 200};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        int sum = 0;

        for (int number : numbers) {
            sum+= number;
        }

        answer = sum;

        return answer;
    }
}
