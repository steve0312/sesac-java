package prac_1211;

/*
DailyAlgo
문제 35번. 문자열의 덧셈
*/
public class Problem35 {
    public static void main(String[] args) {
        System.out.println(solution("hello", "world"));
    }

    public static String solution(String word1, String word2) {
        String answer = "";

        answer = String.join("", word1, word2);

        return answer;
    }
}
