import java.util.concurrent.TimeUnit;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/26 19:35:54
 */
public class LockTest {
    public static void main(String[] args) {
        ZookeeperLock lock1 = new ZookeeperLock();
        ZookeeperLock lock2 = new ZookeeperLock();
        new Thread(() -> {
            try {
                lock1.lock();
                System.out.println("线程1上锁");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("线程1解锁");
                lock1.unlock();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                lock2.lock();
                System.out.println("线程2上锁");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("线程2解锁");
                lock2.unlock();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
