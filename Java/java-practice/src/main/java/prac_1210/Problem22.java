package prac_1210;

/*
DailyAlgo
문제 22번. 자릿수 구하기
*/
public class Problem22 {
    public static void main(String[] args) {
        System.out.println(solution(12345));
    }

    public static int solution(long number) {
        int answer = 0;
        int count = 0;

        while(number > 0) {
            number /= 10;
            count++;
        }

        answer = count;

        return answer;
    }
}
