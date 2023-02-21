package collections;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String> pq = new PriorityQueue<>(new QueueCompator());
        pq.addAll(List.of("cat", "monkey", "zebra"));
        System.out.println(pq.toString());

        /**
         * 우선순위 큐는 값이 순서대로 정렬되어있어 poll 했을 경우 순서대로 값이 나온다.
         */
        System.out.println("===== next queue poll======");
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }

    public static class QueueCompator implements Comparator<String> {

        @Override
        public int compare(String value1, String value2) {
            return Integer.compare(value1.length(), value2.length());
        }
    }
}
