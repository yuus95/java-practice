package main.syncronized;

/**
 *  counter 만들기
 */
public class Syncronized1 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        counter.increment();
        System.out.print(counter.getI());

    }
}
