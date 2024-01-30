package main.function;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class Stream4 {
    public static void main(String[] args) {
        LocalDate nowMinusTwoMonth = LocalDate.now().minusMonths(2);
        Stream.iterate(nowMinusTwoMonth, day -> day.plusDays(1))
                .limit(ChronoUnit.DAYS.between(nowMinusTwoMonth, LocalDate.now()) + 1)
                .forEach(item -> System.out.println("item > " + item));
    }
}
