package modernJava.chapter5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        print(Collections.singletonList(example1(transactions)));
        example2(transactions);
        example3(transactions);
        example4(transactions);
        example5(transactions);
        example6(transactions);
        example7(transactions);
        example8(transactions);
    }

    private static void example8(List<Transaction> transactions) {

    }

    private static void example7(List<Transaction> transactions) {

    }

    private static void example6(List<Transaction> transactions) {

    }

    private static void example5(List<Transaction> transactions) {

    }

    private static void example4(List<Transaction> transactions) {
        System.out.println("example4");
        transactions.stream()
                .map(item -> item.getTrader().getName())
                .distinct()
                .flatMap((item -> Arrays.stream(item.split("")).sorted()))
                .forEach(item -> System.out.println("item" + item));
    }

    private static void example3(List<Transaction> transactions) {
        System.out.println("example3");
        transactions.stream()
                .filter(item -> "Cambridge".equals(item.getTrader().getCity()))
                .map(item -> item.getTrader())
                .distinct()
                .forEach(item ->
                        System.out.println(item));
    }


    /**
     * 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오
     */
    private static List<Transaction> example1(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((a, b) -> a.getValue() > b.getValue() ? 1 : 0)
                .collect(Collectors.toList());
    }

    public static void print(List<Object> list) {
        list.forEach(item ->
                System.out.println("item ->> " + item.toString()));
    }

    private static void example2(List<Transaction> transactions) {
        System.out.println("example2");
        transactions.stream()
                .map(item -> item.getTrader().getCity())
                .distinct()
                .forEach(item -> System.out.println(item));
    }
}
