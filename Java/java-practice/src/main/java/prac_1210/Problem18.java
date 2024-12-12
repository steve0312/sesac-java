package prac_1210;

/*
DailyAlgo
문제 18번. 범위 내 총합 구하기
*/
public class Problem18 {
    public static void main(String[] args) {
        System.out.println(solution(1, 10));
    }

    public static int solution(int start, int end) {
        int answer = 0;

        for(int i = start; i <= end; i++) {
            answer += i;
        }

        return answer;
    }
}
