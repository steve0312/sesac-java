package prac_1211;

/*
DailyAlgo
문제 39번. 펠린드롬 판별하기
*/
public class Problem39 {
    public static void main(String[] args) {
        System.out.println(solution("racecar"));
    }

    public static boolean solution(String word) {
        boolean answer = true;
        StringBuilder sb = new StringBuilder();

        sb.append(word);
        String temp = sb.reverse().toString();

        if(word.equals(temp)) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}
