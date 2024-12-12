package prac_1210;

/*
DailyAlgo 25번
문제 : 모든 약수의 총합 구하기
 */
public class Problem25 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int number) {
        int answer = 0;
        int sum = 0;

        for(int i = 1; i <= number; i++) {
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    sum += j;
                }
            }
        }

        answer = sum;

        return answer;
    }
}
