package thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor Service
 * 스레드의 상태를 알 수 잇다.
 * 스레드의 실행을 컨트롤 할 수 있다.
 */
public class ThreadExample2 {

    static class task extends Thread {
        private final int number;

        public task(int number) {
            this.number = number;
        }

        public void run() {
            System.out.println("\n Start thread" + this.number);
            for (int i = this.number * 100 ; i < this.number * 100 +  100 ; i++) {
                System.out.print(" " + i);
            }
            System.out.println("\n end thread" + this.number);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        /**
         *  ExecutorService
         *  - An Executor that provides
         *                      methods to manage termination
         *                      and methods that can produce a Future for tracking progress of one or more asynchronous tasks.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new task(1));
        executorService.execute(new task(2));
        executorService.execute(new task(3));
        executorService.execute(new task(4));
        executorService.execute(new task(5));
        executorService.execute(new task(6));

        executorService.shutdown();
    }
}
