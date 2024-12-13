package prac_1211;

/*
DailyAlgo
문제 31번. 문자열의 길이 구하기
*/
public class Problem31 {
    public static void main(String[] args) {
        System.out.println(solution("hello"));
    }

    public static int solution(String word) {
        int answer = 0;

        answer = word.length();

        return answer;
    }
}
