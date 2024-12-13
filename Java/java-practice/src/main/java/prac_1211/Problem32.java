package prac_1211;

/*
DailyAlgo
문제 32번. 문자열에서 특정 문자 개수 구하기
*/
public class Problem32 {
    public static void main(String[] args) {
        System.out.println(solution("hello", "l"));
    }

    public static int solution(String word, String c) {
        // 풀이1
        char temp = c.charAt(0);
        int answer = 0;

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == temp) {
                answer++;
            }
        }

//        풀이2
//        char target = c.charAt(0);
//
//        char[] charArray = word.toCharArray();
//
//        for(char charItem : charArray) {
//            if(charItem == target)
//                answer++;
//        }

        return answer;
    }
}
