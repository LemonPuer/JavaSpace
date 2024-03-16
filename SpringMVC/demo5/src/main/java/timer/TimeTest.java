package timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/03 11:24:08
 */
public class TimeTest {
    public static void main(String[] args) {
        // 这里定时任务就已经启动了，但是队列中没有任务，所以一直等待
        Timer timer = new Timer();
        for (int i = 0; i < 2; i++) {
            // 添加任务
            // timer.schedule(new timer.MyTimerTask("task" + i), 0, 2000);
            timer.scheduleAtFixedRate(new MyTimerTask("task" + i), 0, 2000);
        }
    }
}

class MyTimerTask extends TimerTask {
    private String name;

    public MyTimerTask(String name) {
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