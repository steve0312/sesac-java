package prac_1209;

/*
DailyAlgo
문제 17번. 쇼핑몰 가격 계산하기
*/
public class Problem17 {
    public static void main(String[] args) {
        System.out.println(solution(400000, "골드", "신용카드"));
    }

    public static int solution(int totalPrice, String membership, String paymentMethod) {
        int answer = 0;
        double discountPrice = 0;

        if(totalPrice >= 500000) {
            discountPrice = totalPrice * 0.85;
        } else if(totalPrice >= 300000) {
            discountPrice = totalPrice * 0.9;
        } else if( totalPrice >= 100000) {
            discountPrice = totalPrice * 0.95;
        }

        switch(membership) {
            case "실버":
                discountPrice *= 0.97;
                break;
            case "골드":
                discountPrice *= 0.95;
                break;
            case "플래티넘":
                discountPrice *= 0.9;
        }

        if(paymentMethod.equals("현금")) {
            discountPrice *= 0.98;
        }

        if(totalPrice >= 500000 && membership.equals("플래티넘") && paymentMethod.equals("현금")) {
            discountPrice -= 50000;
        }

        answer = (int)discountPrice;

        return answer;
    }
}
