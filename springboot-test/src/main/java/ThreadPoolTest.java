import task.PrintTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author shuai.jin
 * @date 2021/3/30 13:53
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {


        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(4,
                        100,
                        60,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(),
                        Executors.defaultThreadFactory());


        List<Runnable> tasks = new ArrayList<>();

        for(int i = 0; i < 10000000; i++) {
            threadPoolExecutor.execute(new PrintTask(2));
        }

//        Thread.sleep(2000);

        System.out.println(threadPoolExecutor.getActiveCount());
        System.out.println(threadPoolExecutor.getCompletedTaskCount());
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println(threadPoolExecutor.getMaximumPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getLargestPoolSize());
    }
}
