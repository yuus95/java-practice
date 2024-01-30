package main.function;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


// Stream.Map()
// Function<T, R> 구현체
// R apply(T t)을 구현해야한다.
class FunctionClass implements Function<Integer, Integer> {


    // List.of(1,2,3).stream().map((item) -> item * item) 과 같다.
    @Override
    public Integer apply(Integer integer) {
        return integer * integer;
    }
}

// Stream.Filter() 에서 사용한다.
// Predicate<T> 인터페이스 구현체
// boolean test(T t);  함수를 구현해야 한다.
class EvenFunction implements Predicate<Integer> {

    // List.of(1,2,3,4).stream().filter(item -> item % 2 != 1) 과 같다.
    @Override
    public boolean test(Integer number) {
        System.out.println("number");
        return number % 2 != 1;
    }

    public void temp() {
        System.out.println("XXX");
    }
}

// forEach(<Consumer<? super T> action)
// Consumer ==> void accept(T t); 구현해야함
class ConsumerFunction implements Consumer<Integer> {

    // List.of(1,2,3,4).forEach((item) -> System.out.println(item)) 과 같다.
    @Override
    public void accept(Integer integer) {
        System.out.println(integer);
    }
}


public class Stream3 {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 10, 20, 30);

        // 함수를 변수로 저장한다.
        Predicate<Integer> functionVariables = (item) -> item % 2 != 1;

        // 메소드에서 함수를 호출한다.
        integerList.stream().filter(getIntegerPredicate()).forEach(new ConsumerFunction());

        Temp temp = new Temp();
        temp.tempFunction(functionVariables, 5);
        talk talk = new talk() {
            @Override
            public boolean talk() {
                System.out.println(temp);
                return false;
            }
        };
        System.out.println(talk.getClass());
        System.out.println(talk.talk());
        System.out.println(main.function.talk.class);

    }

    // 함수를 반환한다.
    private static Predicate<Integer> getIntegerPredicate() {
        return item -> item % 2 == 0;
    }
}

class Temp {
    public void tempFunction(Predicate<Integer> predicate, Integer variable) {
        if (predicate.test(variable)) {
            System.out.println("함수형 함수 필터링 성공");
        } else {
            System.out.println("함수형 함수 필터링 실패");
        }
    }

    public void temp(talk talk) {
        talk.talk();
    }
}

interface talk {
    boolean talk();
}
