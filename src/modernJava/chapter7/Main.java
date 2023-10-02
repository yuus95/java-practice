package modernJava.chapter7;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {

        String string = "Hello World Marry ChrisMars a b c d e f g h i j k l n m o p q r";
        Spliterator<Character> spliterator = new WordCounterSpliterator(string);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        int count = countWords(stream);
        System.out.println(count);
    }

    public static int countWords(Stream<Character> stream) {
        WordCounter counter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);

        return counter.getCounter();
    }
}
