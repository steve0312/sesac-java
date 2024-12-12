package prac_1210;

/*
DailyAlgo
문제 20번. 범위 내 배수의 합 구하기
*/
public class Problem20 {
    public static void main(String[] args) {
        System.out.println(solution(10, 20, 3));
    }

    public static int solution(int start, int end, int number) {
        int answer = 0;

        for(int i = start; i <= end; i++) {
            if(i % number == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
