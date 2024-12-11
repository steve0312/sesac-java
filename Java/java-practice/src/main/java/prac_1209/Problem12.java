package prac_1209;

/*
DailyAlgo
문제 12번. 부호 판별하기
*/
public class Problem12 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static String solution(int number) {
        String answer = "";

        if(number > 0) {
            answer = "POSITIVE";
        } else if(number < 0) {
            answer = "NEGATIVE";
        } else {
            answer = "ZERO";
        }

        return answer;
    }
}
