package prac_1210;

/*
DailyAlgo 44번
문제 : 배열의 특정 원소 개수 구하기1
 */
public class Problem44 {
    public static void main(String[] args) {
        int[] numbers = {5,5,5,5,5,5,5};

        System.out.println(solution(5, numbers));
    }

    public static int solution(int n, int[] numbers) {
        int answer = 0;
        int count = 0;

        for (int number : numbers) {
            if(number == n) {
                count++;
            }
        }

        answer = count;

        return answer;
    }
}
