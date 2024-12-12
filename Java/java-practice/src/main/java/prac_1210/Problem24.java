package prac_1210;

/*
DailyAlgo 24번
문제 : 구구단 결과 합 구하기
 */
public class Problem24 {
    public static void main(String[] args) {
        System.out.println(solution(4, 5));
    }

    public static int solution(int start, int end) {
        int answer = 0;
        int sum = 0;

        for(int i = start; i <= end; i++) {
            for (int j = 1; j <= 9; j++) {
                sum += i * j;
            }
        }

        answer = sum;

        return answer;
    }
}
