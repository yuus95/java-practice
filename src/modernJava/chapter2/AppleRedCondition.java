package modernJava.chapter2;

import java.util.function.Predicate;

public class AppleRedCondition implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("red");
    }
}
