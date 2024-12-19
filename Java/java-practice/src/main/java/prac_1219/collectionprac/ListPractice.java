package prac_1219.collectionprac;

import java.util.ArrayList;
import java.util.List;

public class ListPractice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // data 삽입
        list.add(1);
        list.add(3);

        System.out.println(list);

        list.add(1, 100);
        System.out.println(list);

        // 접근
        System.out.println(list.get(0));

        // 수정
        list.set(1, 1000);
        System.out.println(list);

        // 길이
        System.out.println(list.size());

        // 비어있는지 확인
        System.out.println(list.isEmpty());
        if(!list.isEmpty()) {
            list.get(0);
        }

        System.out.println("=== 반복 조회 ===");
        for (Integer i : list) {
            System.out.println(i);
        }

        for(int index = 0; index < list.size(); index++) {
            int value = list.get(index);

            System.out.println(value);
        }

        List<String> strings = new ArrayList<String>();
//        에러 발생 (인자로 전달된 값이 String 타입이 아님)
//        strings.add(1);

        strings.add("1");
    }
}
