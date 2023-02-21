package thread;

import java.util.concurrent.*;

class CallableTask implements Callable<String> {

    private final String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("start Call Method " + this.name);
        // 스레드를 실행하고 나서 다양한 과정이 포함되기 떄문에 대기 를 시켜줘야한다.
        Thread.sleep(1000);
        return "Hello" + name;
    }
}

//callableRunner
public class ThreadExample3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("mainMethod start");

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> yushin = executorService.submit(new CallableTask("yushin"));
//        executorService.submit(new CallableTask("yushin2"));
//        executorService.submit(new CallableTask("yushin3"));

        System.out.println("executorService submit Terminate");

        String futureResult = yushin.get();

        System.out.println("get future result " + futureResult);


    }
}
