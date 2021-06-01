import task.AddTask;
import task.PrintTask;

import java.util.concurrent.*;

/**
 * @author shuai.jin
 * @date 2021/3/31 10:39
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1, 1,0L
                        , TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>());

        AddTask addTask = new AddTask(1,2);
        Future<Integer> submit = threadPoolExecutor.submit(addTask);
        Integer integer = submit.get();
        submit.cancel(true);

        System.out.println(submit.isCancelled());
        System.out.println(submit.isDone());

        System.out.println(integer);
    }
}
