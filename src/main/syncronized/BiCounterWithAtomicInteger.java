package main.syncronized;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger는 기본적인 atomic 연산을 제공한다.
 */
public class BiCounterWithAtomicInteger {
    private AtomicInteger i = new AtomicInteger();
    private AtomicInteger j = new AtomicInteger();

    public void incrementI() {
        i.incrementAndGet();
    }

    public int getI() {
        return i.get();
    }

    public void incrementJ() {
        j.incrementAndGet();
    }

    public int getJ() {
        return j.get();
    }
}
