package main.modernJava.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AppleTest {
    public static void main(String[] args) {
        Apple[] arrays = {new Apple("test", 100), new Apple("test123", 100), new Apple("test2", 200)};
        List<Apple> apples = new ArrayList<>(Arrays.asList(arrays));

        // sort 메서드는 함수형 인터페이스를 사용하므로 동작을 코드로 전달할 수 있다.
        apples.sort(new AppleComparator());

        // 익명클래스
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        //람다표현식
        apples.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));

        // 메소드참조
        apples.sort(Comparator.comparing(Apple::getWeight));

    }

    static class AppleComparator implements Comparator<Apple>{
        @Override
        public int compare(Apple o1, Apple o2) {

            return o1.getWeight().compareTo(o2.getWeight());
        }
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
