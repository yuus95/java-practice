package modernJava.chapter3;

import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        List<String> strings = List.of("1", "2", "3");
        FilterTemp filterTemp = new FilterTemp();
        Predicate<String> nonEmptyStringPredicate = (String s ) -> !s.isEmpty();
        List<String> filter = filterTemp.filter(strings, nonEmptyStringPredicate);

        filterTemp.forEach(List.of(1,2,3,4,5), (Integer i) -> System.out.println(i));
    }
}
