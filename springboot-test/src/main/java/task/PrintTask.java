package task;

import lombok.SneakyThrows;

/**
 * @author shuai.jin
 * @date 2021/3/30 14:43
 */
public class PrintTask implements Runnable {

    private int count;



    public PrintTask(int count) {
        super();
        this.count = count;
    }

    @SneakyThrows
    @Override
    public void run() {
        for(int i = 0; i < count; i++) {
            System.out.println("不见了远处的青三 " + (i + 1));
        }
    }
}
