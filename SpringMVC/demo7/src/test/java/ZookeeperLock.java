import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/26 19:37:04
 */
public class ZookeeperLock {
    private ZooKeeper zk;
    private final String connectString = "192.168.124.105:2181";
    private final int sessionTime = 20000;
    private String current;
    private String watchNode = "";
    private final CountDownLatch connect = new CountDownLatch(1);
    private final CountDownLatch wait = new CountDownLatch(1);


    public ZookeeperLock() {
        connect();
    }

    private void connect() {
        try {
            zk = new ZooKeeper(connectString, sessionTime, (watchedEvent) -> {
                if (watchedEvent.getState().equals(Watcher.Event.KeeperState.SyncConnected)) {
                    connect.countDown();
                }
                if (watchedEvent.getPath().equals(watchNode) && watchedEvent.getType().equals(Watcher.Event.EventType.NodeDeleted)) {
                    wait.countDown();
                }
            });
            // 确保成功连接Zookeeper
            connect.await();
            Stat exists = zk.exists("/locks", false);
            if (exists == null) {
                zk.create("/locks", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void lock() throws Exception {
        current = zk.create("/locks/task", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        List<String> children = zk.getChildren("/locks", false);
        if (children.size() == 1) {
            return;
        }
        // 得到需要监听的节点
        long cur = Long.parseLong(current.substring("/locks/task".length()));
        for (String temp : children) {
            long watch = Long.parseLong(temp.substring("/task".length()));
            if (watch < cur) {
                watchNode = "/locks/" + temp;
            }
        }
        if (Objects.equals(watchNode, "")) {
            return;
        }
        zk.getData(watchNode, true, null);
        // 确保监听完成
        wait.await();
    }

    public void unlock() throws Exception {
        zk.delete(current, -1);
    }
}
