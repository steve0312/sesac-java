package prac_1209;

/*
DailyAlgo
문제 11번. 짝홀 판별하기
*/
public class Problem11 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static String solution(int number) {
        String answer = "";

        if(number % 2 == 0) {
            answer = "짝수";
        } else {
            answer = "홀수";
        }

        return answer;
    }
}
