package prac_1209;

/*
DailyAlgo
문제 16번. 비만도 계산하기
*/
public class Problem16 {
    public static void main(String[] args) {
        System.out.println(solution(50.0, 1.45));
    }

    public static String solution(double weight, double height) {
        String answer = "";
        double bmi = weight / (height * height);

        if(25 <= bmi) {
            answer = "비만";
        } else if(23 <= bmi && bmi < 25) {
            answer = "과체중";
        } else if(18.5 <= bmi && bmi < 23) {
            answer = "정상";
        } else {
            answer = "저체중";
        }

        return answer;
    }
}
