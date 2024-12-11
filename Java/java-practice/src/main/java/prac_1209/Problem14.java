package prac_1209;

/*
DailyAlgo
문제 14번. 성적 판별하기
*/
public class Problem14 {
    public static void main(String[] args) {
        System.out.println(solution(45));
    }

    public static String solution(int score) {
        String answer = "";

        if(score >= 90) {
            answer = "A";
        } else if(80 <= score && score < 90) {
            answer = "B";
        } else if(70 <= score && score < 80) {
            answer = "C";
        } else if(60 <= score && score < 70) {
            answer = "D";
        } else {
            answer = "F";
        }

        return answer;
    }
}
