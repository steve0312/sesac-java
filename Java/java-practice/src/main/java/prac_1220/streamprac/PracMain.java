package prac_1220.streamprac;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracMain {
    public static void main(String[] args) {
        //        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);

//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));

        List<Integer> list = new ArrayList<Integer>(List.of(3, 1, 2, 2, 4));
        System.out.println(list);

        List<Integer> over1List = list.stream()   // list를 stream으로 변경
                .filter(x -> x > 1) // filter 적용
                .collect(Collectors.toList());// List로 변경

        System.out.println(over1List);

        Stream<String> strings = Stream.of("a", "b", "c");
        Stream<String> upper = strings.map(string -> string.toUpperCase());
        // "A", "B", "C"를 갖는 스트림

        System.out.println(upper.toList());
    }
}
