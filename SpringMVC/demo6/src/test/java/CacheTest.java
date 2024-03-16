import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.benmanes.caffeine.cache.*;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import sun.management.snmp.jvmmib.JvmThreadInstanceEntryMBean;
import workspace.domain.Courses;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/05 19:38:18
 */
@Slf4j
public class CacheTest {
    public static void main(String[] args) throws Exception {
        Cache<String, Integer> cache = Caffeine.newBuilder().initialCapacity(2).maximumSize(3)
                .recordStats()
                .removalListener(new RemovalListener<String, Integer>() {
                    @Override
                    public void onRemoval(@Nullable String s, @Nullable Integer integer, @NonNull RemovalCause removalCause) {
                        log.info("数据{}被删除，原因是{}", s, removalCause);
                    }
                })
                .build();
        cache.put("test1", 18);
        cache.put("test2", 20);
        String[] strings = new String[]{"test1", "test2", "test3"};
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (String k : strings) {
                    log.info("获取{}:{}", k, cache.getIfPresent(k));
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(3);
        CacheStats stats = cache.stats();
        log.info("缓存请求次数:{}", stats.requestCount()); // 300
        log.info("缓存命中次数:{}", stats.hitCount()); // 200
    }
}
