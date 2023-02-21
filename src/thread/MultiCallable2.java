package thread;

import java.util.List;
import java.util.concurrent.*;

/**
 * A task that returns a result and may throw an exception. Implementors define a single method with no arguments called call.
 * The Callable interface is similar to Runnable, in that both are designed for classes
 * whose instances are potentially executed by another thread. A Runnable, however, does not return a result
 * and cannot throw a checked exception.
 */
class MultiTask2 implements Callable<String> {
    private final String name;

    public MultiTask2(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("task Start " + this.name);
        return "Hello " + this.name;
    }
}

public class MultiCallable2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 스레드를 관리해주는 ExecutorService 를 생성
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // 여러 개의 Callable생성
        List<MultiTask2> callableTasks = List.of(new MultiTask2("yushin"), new MultiTask2("hansung"), new MultiTask2("min"));
        // 제일 빠른 결과를 가져오지만 스레드는 돌 구 있다.
        String result = executorService.invokeAny(callableTasks);

        System.out.println("item -> " + result);

        executorService.shutdown();
    }
}
