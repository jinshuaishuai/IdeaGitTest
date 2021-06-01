import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author shuai.jin
 * @date 2021/3/30 16:56
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        ExecutorService executorService2 = Executors.newCachedThreadPool();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(20);

        ExecutorService executorService3 = Executors.newWorkStealingPool();

    }
}
