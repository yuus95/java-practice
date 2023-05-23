package modernJava.chapter3;

import modernJava.chapter2.Apple;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AppleTest {
    public static void main(String[] args) {
        Apple[] arrays  = {new Apple("test", 100), new Apple("test123", 100), new Apple("test2", 200)};
        List<Apple> apples = new ArrayList<>(Arrays.asList(arrays));

        apples.sort(Comparator.comparing(Apple::getWeight).thenComparing((a1) -> -a1.getName().length()));
//        apples.sort(Comparator.comparing(Apple::getWeight));

        apples.forEach(item -> {
            System.out.println("item" + item);
        });


    }


    static class Apple {
        String name;
        Integer weight;

        public Apple(String name, Integer weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
