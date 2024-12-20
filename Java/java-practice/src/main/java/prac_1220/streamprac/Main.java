package prac_1220.streamprac;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 실습 ===");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("- 짝수만 필터링하여 리스트 반환");
        List<Integer> evenList = numbers.stream()
                .filter(x -> x % 2 == 0)
                .toList();

        System.out.println("짝수 리스트 : " + evenList);

        System.out.println();
        System.out.println("- 모든 숫자에 2를 곱하여 리스트 반환");

        List<Integer> multiple2List = numbers.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());

        System.out.println("2를 곱한 리스트 : " + multiple2List);

        System.out.println();
        System.out.println("- 숫자들의 합계 계산");

        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("합계 : " + sum);

        System.out.println();
        System.out.println("- 5보다 큰 숫자의 개수 계산");

        long count = numbers.stream()
                .filter(x -> x > 5)
                .count();

        System.out.println("5보다 큰 숫자의 개수 : " + count);

        System.out.println();
        List<String> words = Arrays.asList("apple", "banana", "cherry", "fineapple", "apple");

        System.out.println("- 길이가 5보다 큰 단어들만 필터링하여 리스트 반환");
        List<String> overLen5List = words.stream()
                .filter(x -> x.length() > 5)
                .collect(Collectors.toList());

        System.out.println("단어 리스트 : " + overLen5List);

        System.out.println();
        System.out.println("- 모든 단어들을 대문자로 변환하여 리스트 반환");

        List<String> toUpperList = words.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("대문자로 변환한 리스트 : " + toUpperList);

        System.out.println();
        System.out.println("- 중복된 단어 제거하고 알파벳 순 정렬하여 리스트 반환");
        List<String> sortAlphabetList = words.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("제거 + 정렬 리스트 : " + sortAlphabetList);

        System.out.println();
        System.out.println("- 각 단어의 길이를 리스트로 변환");

        List<Integer> eachWordLenList = words.stream()
                .map(x -> x.length())
                .collect(Collectors.toList());

        System.out.println("길이 리스트 : " + eachWordLenList);

        System.out.println();

        List<Product> products = Arrays.asList(
                new Product("notebook", 1200000, "SALE"),
                new Product("mouse", 50000, "SALE"),
                new Product("keyboard", 150000, "SOLD_OUT"),
                new Product("monitor", 350000, "SOLD_OUT"),
                new Product("speaker", 400000, "SALE")

        );

        System.out.println("- 상품들의 이름 리스트 반환");
        List<String> productNameList = products.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());

        System.out.println("상품들의 이름 리스트 : " + productNameList);

        System.out.println();
        System.out.println("- 20만원 이상인 상품들의 이름 리스트 반환");

        List<String> over20NameList = products.stream()
                .filter(x -> x.getPrice() >= 200000)
                .map(x -> x.getName())
                .collect(Collectors.toList());

        System.out.println("상품들의 이름 리스트 : " + over20NameList);

        System.out.println();
        System.out.println("- 판매 중인 상품의 가격 합");
        int priceSum = products.stream()
                .mapToInt(x -> x.getPrice())
                .sum();

        System.out.println("가격 합 : " + priceSum);

        System.out.println();
        System.out.println("- 판매 중이면서 20만원 이상인 상품들의 이름 리스트 반환");
        List<String> onSaleOver20List = products.stream()
                .filter(x -> x.getStatus().equals("SALE") && x.getPrice() >= 200000)
                .map(x -> x.getName())
                .collect(Collectors.toList());

        System.out.println("상품들의 이름 리스트 : " + onSaleOver20List);
    }
}