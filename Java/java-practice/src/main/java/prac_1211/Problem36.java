package prac_1211;

/*
DailyAlgo
문제 36번. 문자열의 곱셈
*/
public class Problem36 {
    public static void main(String[] args) {
        System.out.println(solution("abc", 3));
    }

    public static String solution(String word, int n) {
        StringBuilder sb = new StringBuilder();
        String answer = "";

        for(int i = 0; i < n; i++) {
            sb.append(word);
        }

        answer = sb.toString();

        return answer;
    }
}
