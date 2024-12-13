package prac_1211;

/*
DailyAlgo
문제 41번. 문자열 수정하기
*/
public class Problem41 {
    public static void main(String[] args) {
        System.out.println(solution("hello world", "world", "python"));
    }

    public static String solution(String word, String oldString, String newString) {
        String answer = "";

        if(word.contains(oldString)) {
            answer = word.replace(oldString, newString);
        }

        return answer;
    }
}
