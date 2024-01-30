package main.syncronized;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * main.thread safe : 특정 메소드를 하나의 스레드만 실행할 수 있도록 한다.
 * 동기화된 두 메소드에 대한 실행 요청을 할 경우 각각 스레드에서 서로 다른 메소드 하나 씩을 호출한다.
 * 이 때 두 메소드는 전혀 다른 연산이지만( 서로에게 영향을 주지 않는 메소드 ) 각각 스레드는 각각이 메소드를 실행시키기 위해 대기해야한다.
 * <p>
 * Lock : 동기화된 코드를 여러 조각의 코드로 쪼갤 수 있다.
 */
public class BiCounterWithLock {
    private int i = 0;
    private int j = 0;

    /**
     * Lock implementations provide more extensive locking operations than can be obtained using synchronized methods and statements.
     * They allow more flexible structuring, may have quite different properties,
     * and may support multiple associated Condition objects.
     */
    Lock lockForI = new ReentrantLock();
    Lock lockForJ = new ReentrantLock();

    public void incrementI() {
        // 동기화 과저엥 들어가지 않고도 이 코드를 동기화해주거나 main.thread-safe 하게 해준다.

        //get Lock
        lockForI.lock();
        i++;
        lockForI.unlock();
        //release lock
    }

    public int getI() {
        return i;
    }

    public void incrementJ() {
        //getLock
        lockForJ.lock();
        j++;
        lockForJ.unlock();
        //releaseLock
    }

    public int getJ() {
        return j;
    }
}
