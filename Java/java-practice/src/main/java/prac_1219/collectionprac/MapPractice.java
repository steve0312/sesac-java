package prac_1219.collectionprac;

import java.util.HashMap;
import java.util.Set;

public class MapPractice {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("korean", 100);
        map.put("english", 10);
        System.out.println(map);

        map.put("korean", 30);
        System.out.println(map);

        // 조회
        System.out.println(map.get("korean"));
        System.out.println(map.get("math"));

        // 조회 + 디폴트 값 설정
        System.out.println(map.getOrDefault("math", 0));
        System.out.println(map.getOrDefault("korean", 0));

        // 크기
        System.out.println(map.size());

        System.out.println("=== keySet ===");
        Set<String> keys = map.keySet();

        for (String key : keys) {
            Integer value = map.get(key);
            System.out.println(key + ": " + value);
        }

        System.out.println(map.values());
    }
}
