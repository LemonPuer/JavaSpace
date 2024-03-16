package pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/03 16:56:06
 */
public class ScheduleThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            scheduledThreadPool.scheduleAtFixedRate(new MyTask("tesk-" + i), 0, 2, TimeUnit.SECONDS);
            // scheduledThreadPool.scheduleWithFixedDelay(new pool.MyTask("tesk-" + i), 0, 2, TimeUnit.SECONDS);
        }
    }
}

class MyTask implements Runnable {
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "执行时间：" + new Date());
            Thread.sleep(1000);
            System.out.println(name + "结束时间：" + new Date());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}