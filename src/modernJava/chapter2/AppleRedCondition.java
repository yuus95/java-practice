package modernJava.chapter2;

import java.util.function.Predicate;

public class AppleRedCondition implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("red");
    }

    public Predicate temp() {
        return (a) -> a.equals("Temp");
    }

    public boolean predicateTest(String parameter, Predicate filter) {
        return filter.test(parameter);
    }

    public static void main(String[] args) {
        AppleRedCondition appleRedCondition = new AppleRedCondition();
        String a = new String("Temp");
        boolean result = appleRedCondition.predicateTest(a, appleRedCondition.temp());
        System.out.println("Temp" + result);
    }
}
