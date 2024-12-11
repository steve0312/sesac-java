package prac_1209;

/*
DailyAlgo
문제 10번. 두 수의 크기 비교하기
*/
public class Problem10 {
    public static void main(String[] args) {
        System.out.println(solution(10, 5));
    }

    public static int solution(int number1, int number2) {
        int answer = 0;

        if(number1 > number2) {
            answer = number1;
        } else {
            answer = number2;
        }

        return answer;
    }
}
