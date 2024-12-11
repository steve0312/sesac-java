package prac_1209;

/*
DailyAlgo
문제 13번. 범위 내 숫자 판별하기
*/
public class Problem13 {
    public static void main(String[] args) {
        System.out.println(solution(5, 1, 10));
    }

    public static String solution(int number, int start, int end) {
        String answer = "";

        if(start <= number && number <= end) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        return answer;
    }
}
