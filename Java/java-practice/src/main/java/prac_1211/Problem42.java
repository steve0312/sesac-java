package prac_1211;

/*
DailyAlgo
문제 42번. 문자열 제거하기
*/
public class Problem42 {
    public static void main(String[] args) {
        System.out.println(solution("hello world", ""));
    }

    public static String solution(String word, String target) {
        String answer = "";

        answer = word.replace(target, "");

        return answer;
    }
}
