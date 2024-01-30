package main.modernJava.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );
        AppleRedCondition appleRedCondition = new AppleRedCondition();
        List<Apple>redApple = filter(inventory, appleRedCondition);

        for (Apple apple : redApple) {
            System.out.println("redApple "  + apple.toString());
        }
    }

    public static List<Apple> filter(List<Apple> apples, Predicate<Apple> p) {
        List<Apple> newApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                newApples.add(apple);
            }
        }

        return newApples;
    }
}
