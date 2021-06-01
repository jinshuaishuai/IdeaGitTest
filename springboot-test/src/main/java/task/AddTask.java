package task;

import java.util.concurrent.Callable;

/**
 * @author shuai.jin
 * @date 2021/3/31 10:42
 */
public class AddTask implements Callable<Integer> {

    private int paramA;

    private int paramB;

    public AddTask(int paramA, int paramB) {
        super();
        this.paramA = paramA;
        this.paramB = paramB;
    }

    @Override
    public Integer call() throws Exception {

        Thread.sleep(5000);
        return this.paramA + this.paramB;
    }
}
