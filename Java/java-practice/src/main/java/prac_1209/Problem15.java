package prac_1209;

/*
DailyAlgo
문제 15번. 윤년 판별하기
*/
public class Problem15 {
    public static void main(String[] args) {
        System.out.println(solution(2024));
    }

    public static String solution(int year) {
        String answer = "";

        // 400으로 나누어 떨어지면 윤년
        // 100으로 나누어 떨어지면 윤년이 아님
        // 4로 나누어 떨어지면 윤년
        // 나머지는 윤년이 아님
        if(year % 400 == 0) {
            answer = "YES";
        } else if(year % 100 == 0) {
            answer = "NO";
        } else if(year % 4 ==0) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        return answer;
    }
}
