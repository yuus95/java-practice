package function;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class stream2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4,6,8,13,3,15);


       //        1
        IntStream range = IntStream.range(1, 11);
        range.forEach(System.out::println);

        System.out.println("======== ");
//        2
        List<String> stringList = List.of("Apple", "Ant", "Bat");
        stringList.stream()
                .map(String::toLowerCase).forEach(System.out::println);

        System.out.println("======== ");
        //3 글자 수대로 출력
        stringList.stream()
                .map(String::length)
                .forEach(System.out::println);

        IntStream.range(1,11).reduce(0, Integer::sum);

        List.of(23,12,34,53).stream().max((n1,n2) -> Integer.compare(n1,n2));
    }
}
