import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/26 15:56:25
 */
public class ZookeeperTest {
    private ZooKeeper zk;
    private final String connectString = "192.168.124.105:2181";
    private final int sessionTime = 20000;

    public static void main(String[] args) throws Exception {
        ZookeeperTest test = new ZookeeperTest();
        // 建立连接
        test.connect();
        // 创建节点
        System.out.println(test.create("/servers", "hello".getBytes()));
        // 获取节点
        System.out.println(test.getList("/"));
        // 设置节点数据
        System.out.println(test.setData("/servers", "hi"));
        // 获取节点数据
        System.out.println(test.getData("/servers"));
        // 删除节点
        test.delNode("/servers");

        System.out.println(test.getList("/"));

        test.close();
    }

    private void close() throws InterruptedException {
        zk.close();
    }

    private void delNode(String path) throws InterruptedException, KeeperException {
        zk.delete(path, -1);
    }

    private String getData(String path) throws InterruptedException, KeeperException {
        return new String(zk.getData(path, false, null));
    }

    private Stat setData(String path, String data) throws InterruptedException, KeeperException {
        // 这里的version是实现乐观锁的版本号，当版本号不匹配就不能成功更新
        // 设置-1表示忽略版本号直接更新
        return zk.setData(path, data.getBytes(), -1);
    }

    private List<String> getList(String path) throws InterruptedException, KeeperException {
        return zk.getChildren(path, false);
    }

    private String create(String path, byte[] data) throws InterruptedException, KeeperException {
        // 第三个参数表示权限控制，这里设置所有人都能操作
        // 第四个参数表示生成模式，这里使用的是临时非有序
        return zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
    }

    private void connect() throws IOException{
        zk = new ZooKeeper(connectString, sessionTime, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("===========监听记录============");
                System.out.println(watchedEvent.getPath());
                System.out.println(watchedEvent.getState());
                System.out.println(watchedEvent.getType());
                System.out.println(watchedEvent.getWrapper());
                try {
                    // true表示使用默认的Watcher
                    System.out.println(zk.getChildren("/", true));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("===========监听结束============");
            }
        });
    }
}
