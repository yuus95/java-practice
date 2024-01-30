package main.function;

import java.util.List;

public class stream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 1, 3, 4, 5, 6, 11, 12, 13);

        //  중복 제거
//        list.stream().distinct().forEach(System.out::println);

        // 일반적인 프로그래밍
        List<Integer> tempList = List.of(1, 2, 3, 4, 5);
        int a = 0;
        for (Integer integer : tempList) {
            a += integer;
        }
        System.out.println(a);

        // 함수형 프로그래밍
        System.out.println(tempList.stream().reduce(0, Integer::sum));

        tempList.stream()
                .map(item -> item * 2)
                .forEach(item -> {
            System.out.println(item);
            System.out.println(item+1);
            System.out.println("----");
        });
    }
}
