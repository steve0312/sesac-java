package prac_1219.collectionprac;

import java.util.ArrayList;
import java.util.HashMap;

public class Practice {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        int average = 0;

        list.add(30);
        list.add(20);
        list.add(10);

        for (Integer i : list) {
            sum += i;
        }
        average = sum / list.size();

        System.out.println("합계 : " + sum + ", 평균 : " + average);

//        연습 및 테스트
//        ArrayList<String> list = new ArrayList<>();

//        // 추가
//        list.add("sangho");
//        list.add("daejung");
//        list.add("seungdeok");
//        System.out.println(list);
//
//        // 조회
//        System.out.println(list.get(0));
//
//        // 원하는 인덱스에 삽입
//        list.set(2, "taeyoung");
//        System.out.println(list);
//
//        System.out.println(list.size());
//
//        if(!list.isEmpty()) {
//            System.out.println(list.get(2));
//        }
//
//        System.out.println(list.contains("sangho"));
//
//        list.remove(0);
//        System.out.println(list);
//
//        System.out.println("========");
//
//        HashMap<String, String> map = new HashMap<>();
//
//        map.put("이름", "상호");
//        map.put("수강과정", "자바 풀스택");
//        System.out.println(map);
//
//        System.out.println(map.get("수강과정"));
//        System.out.println(map.getOrDefault("나이", "20"));
//
//        System.out.println(map.size());
//
//        System.out.println(map.containsKey("이름"));
//        System.out.println(map.containsValue("테스트"));
//
//        map.remove("이름");
//        System.out.println(map);
//
//        map.put("이름", "상호");
//        map.put("수강장소", "성동캠퍼스");
//        System.out.println(map);
//
//        for (String key : map.keySet()) {
//            System.out.println(key + " : " + map.get(key));
//        }
    }
}
