package prac_1211;

/*
DailyAlgo
문제 37번. 문자열 자르기
*/
public class Problem37 {
    public static void main(String[] args) {
        System.out.println(solution("hello", 1, 3));
    }

    public static String solution(String word, int start, int end) {
        String answer = "";

        answer = word.substring(start, end+1);

        return answer;
    }
}
