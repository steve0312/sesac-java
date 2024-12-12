package prac_1210;

/*
DailyAlgo 46번
문제 : 배열 원소의 최소값 찾기
 */
public class Problem46 {
    public static void main(String[] args) {
        int[] numbers = {3, -1, 0, 489, 50, -20, 122};

        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        int minNum = 500;

        for (int number : numbers) {
            if(number < minNum) {
                minNum = number;
            }
        }

        answer = minNum;

        return answer;
    }
}
