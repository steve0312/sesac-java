package prac_1210;

/*
DailyAlgo 23번
문제 : 각 자릿수의 합 구하기
 */
public class Problem23 {
    public static void main(String[] args) {
        System.out.println(solution(12345));
    }

    public static int solution(long number) {
        int answer = 0;
        int sum = 0;

        while(number > 0) {
            sum += (number % 10);
            number /= 10;
        }

        answer = sum;

        return answer;
    }
}
