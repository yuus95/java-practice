package modernJava.chapter5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<Integer> firstList = List.of(1, 2, 3);
        List<Integer> secondList = List.of(3, 4);
        List<int[]> collect = firstList.stream()
                .flatMap(i -> secondList.stream()
                        .filter(j -> i == j )
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        List<Integer> temp = List.of(List.of(1), List.of(2))
                .stream()
                .flatMap(i -> secondList.stream())
                .collect(Collectors.toList());
        
        Stream<Dish> stream = menu.stream();
        List<String> stringTemp = List.of("temp");
        Stream<Integer> integerStream = List.of(1, 2, 3, 4).stream();
        Stream<String> stringStream = integerStream.map(i -> String.valueOf(i));
        Stream<String> stringStream1 = stringStream.flatMap(i -> stringTemp.stream()
                .map(test -> i + test));
    }

    public static void print(List<Object> dishes) {
        for (Object dish : dishes) {
            System.out.println(dish);
        }
    }
}
