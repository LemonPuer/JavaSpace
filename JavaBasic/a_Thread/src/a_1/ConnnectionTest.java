package a_1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * @author Lemon
 * @create 2022-09-04-18:59
 */
public class ConnnectionTest {
    public static void main(String[] args) {
        Connection a = new Connection();
        Thread b = new Thread(a);
        Thread c = new Thread(a);
        b.setName("1:");
        c.setName("2:");
        b.start();
        c.start();
    }
}

class Connection implements Runnable {
    private int i=1;
    private final ReentrantLock lock = new ReentrantLock();

    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (i < 100) {
                    System.out.println(Thread.currentThread().getName() + i);
                    i++;

                } else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
