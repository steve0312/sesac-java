package prac_1210;

/*
DailyAlgo
문제 19번. 범위 내 짝수의 합 구하기
*/
public class Problem19 {
    public static void main(String[] args) {
        System.out.println(solution(1, 10));
    }

    public static int solution(int start, int end) {
        int answer = 0;

        for(int i = start; i <= end; i++) {
            if(i % 2 == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
