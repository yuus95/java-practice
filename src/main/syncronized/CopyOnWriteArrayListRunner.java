package main.syncronized;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * add 연산만 동기화 진행 한다.
 * Get 연산은 동기화 하지 않는다.
 *
 * 동시성이 확보된다.
 */
public class CopyOnWriteArrayListRunner {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();


        // Threads -3
        list.add("Ant");
        list.add("Bat");
        list.add("Cat");


        //Threads - 10000
        for (String element : list) {
            System.out.println(element);
        }

    }
}
