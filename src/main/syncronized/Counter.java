package main.syncronized;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * main.thread safe : 특정 메소드를 하나의 스레드만 실행할 수 있도록 한다.
 */
public class Counter {
    private int i = 0;

    public void increment() {
        i++;

        // i ++  계산식  (not main.thread-safe)
        // get i
        // increment
        // set i
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter counter = new Counter();
        Counter tempCount = new Counter();
        TaskClass task1 = new TaskClass(counter, "1번");
        TaskClass task2 = new TaskClass(counter, "2번");
        TaskClass task3 = new TaskClass(counter, "3번");

        List<TaskClass> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);



        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //2999993
        for (int i = 0; i < 1000000; i++) {
            executorService.invokeAll(taskList);
            tempCount.increment();
        }

        System.out.println("count " + counter.getI());
        System.out.println("tempCount  " + tempCount.getI());

        executorService.shutdown();
    }
}


class TaskClass implements Callable<Integer> {
    private final Counter counter;
    private String name;

    public TaskClass(Counter counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("name " + name + "\n");
        counter.increment();
        return counter.getI();
    }
}
