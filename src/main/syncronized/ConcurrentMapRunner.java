package main.syncronized;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * Hashtable : 해쉬 테이블은 하나의 맵 자체를 모두 잠궈 버린다.
 * 맵 전체를 하나의 Lock 을 이용하여 잠군다.
 *
 * ConcurrentMap :
 *  - Atomic 연산을 지원한다.
 *  - 여러 개의 Lock 을 사용하여 Map 공간의  동시성을 관리한다.
 *      - [0] ~[3] 까지 A 라는 Lock 을 이용하여 [4] ~[8] 까지 B라는 Lock 을 이용할 경우 A락을 이용할 경우 다른 스레드에서는 B락을 사용하는 공간을 업데이트할 수 있다.
 */
public class ConcurrentMapRunner {
    public static void main(String[] args) {
        Map<Character, LongAdder> occurances = new Hashtable<>();
        ConcurrentMap<Character, LongAdder> concurrentOccurances = new ConcurrentHashMap<>();


        String str = "ABCD ABCD ABCD";

        // HashTable
        for (char character : str.toCharArray()) {
            LongAdder longAdder = occurances.get(character);
            if (longAdder == null) {
                longAdder = new LongAdder();
            }
            longAdder.increment();
            occurances.put(character, longAdder);
        }
        System.out.print(occurances);

        //ConcurrentHashMap
        // HashTable 보다 동시성을 관리하기 편하게 로직이 구성되어있다.
        for (char character : str.toCharArray()) {
            // 특정 Key 가 없을 경우 해당 키를 생성하는 로직을 스트림으로 관리하고 있다.
            // 위에 HashTable 로직보다 간결하다.
            concurrentOccurances.computeIfAbsent(character, ch -> new LongAdder())
                    .increment();
        }
        System.out.print(occurances);


    }
}
