package main.modernJava.chapter6;

import main.modernJava.domain.transaction.Transaction;
import main.modernJava.domain.transaction.TransactionFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = TransactionFactory.getTransactions();
        List<Transaction> transactions2 = TransactionFactory.getTransactions();
        /**
         * 2개의리스트를 하나의 맵으로 어떻게 표현할까.
         */
        Stream<Transaction> concat = Stream.concat(transactions2.stream(), transactions.stream());
        Map<Integer, List<Transaction>> collect = concat.collect(groupingBy(Transaction::getValue));
        System.out.println();

        /**
         * 중첩 컬렉터
         */
        transactions.stream()
                .collect(groupingBy(Transaction::getYear, mapping(Transaction::getTrader, toList())
                ));

        System.out.println();
    }

    /**
     * 순차적 덧셈 스트림
     */
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }


    /**
     * 병렬적 스트림
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i +1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

}
