package syncronized;


/**
 * thread safe : 특정 메소드를 하나의 스레드만 실행할 수 있도록 한다.
 *
 * 동기화된 두 메소드에 대한 실행 요청을 할 경우 각각 스레드에서 서로 다른 메소드 하나 씩을 호출한다.
 * 이 때 두 메소드는 전혀 다른 연산이지만( 서로에게 영향을 주지 않는 메소드 ) 각각 스레드는 각각이 메소드를 실행시키기 위해 대기해야한다.
 */
public class BiCounter {
    private int i = 0;
    private int j = 0;

    synchronized public void incrementI() {
        i++;

        // i ++  계산식  (not thread-safe)
        // get i
        // increment
        // set i
    }

    public int getI() {
        return i;
    }

    synchronized public void incrementJ() {
        j++;

        // j ++  계산식  (thread-safe)
        // get j
        // increment
        // set j
    }

    public int getJ() {
        return j;
    }
}
