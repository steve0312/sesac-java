package prac_1211;

/*
DailyAlgo
문제 34번. 문자열 포매팅
*/
public class Problem34 {
    public static void main(String[] args) {
        System.out.println(solution("hello"));
    }

    public static String solution(String word) {
        String answer = "";

        answer = String.format("%s is %d", word, word.length());

        return answer;
    }
}
