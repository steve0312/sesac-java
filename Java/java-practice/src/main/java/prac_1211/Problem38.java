package prac_1211;

/*
DailyAlgo
문제 38번. 문자열 뒤집기
*/
public class Problem38 {
    public static void main(String[] args) {
        System.out.println(solution("hello"));
    }

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder(word);
        String answer = "";

        answer = sb.reverse().toString();

        return answer;
    }
}
