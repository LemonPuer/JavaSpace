package workspace.service.cache;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.benmanes.caffeine.cache.AsyncCacheLoader;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import workspace.domain.Courses;
import workspace.mapper.CoursesMapper;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/03 23:01:55
 */
/*@Data
@Slf4j
@Component
public class MyCacheUtils {
    @Autowired
    private CoursesMapper coursesMapper;
    @Autowired
    private ThreadPoolTaskExecutor myExecutor;

    private LoadingCache<String, List<Courses>> courseCache;

    private LoadingCache<String, List<Courses>> courseCache2;

    private AsyncLoadingCache<Object, List<Courses>> asyncCourseCache;

    private AsyncLoadingCache<Object, List<Courses>> asyncCourseCache2;

    @PostConstruct
    public void innit() {
        courseCache = Caffeine.newBuilder()
                .initialCapacity(2)
                .maximumSize(2)
                .expireAfterAccess(3L, TimeUnit.SECONDS)
                .build(k -> {
                    log.info("===========缓存更新============");
                    Thread.sleep(2000);
                    return coursesMapper.selectList(Wrappers.lambdaQuery(Courses.class).in(Courses::getId, 1, 2, 3, 4, 5));
                });
        // CacheLoader 使用自己的线程池刷新数据；当不指定线程池时，Spring会帮我们创建 HikariPool
        asyncCourseCache = Caffeine.newBuilder().maximumSize(2).expireAfterAccess(3L, TimeUnit.SECONDS).executor(myExecutor).buildAsync(k -> {
            log.info("===========异步缓存1更新============");
            return coursesMapper.selectList(Wrappers.lambdaQuery(Courses.class).in(Courses::getId, 6, 7, 8));
        });
        courseCache2 = Caffeine.newBuilder()
                .maximumSize(2)
                .expireAfterAccess(3L, TimeUnit.SECONDS)
                .build(k -> {
                    log.info("===========cache2缓存更新============");
                    return coursesMapper.selectList(Wrappers.lambdaQuery(Courses.class).in(Courses::getId, 9, 10));
                });

        // 想要在构造器中使用自己创建的线程池刷新数据，可以使用下面的写法，这种方式也适用于构造器中初始化
        *//*asyncCourseCache2 = Caffeine.newBuilder().maximumSize(2).expireAfterAccess(3L, TimeUnit.SECONDS).buildAsync(k -> {
            ListenableFutureTask<List<Courses>> futureTask = new ListenableFutureTask<>(() -> {
                log.info("===========异步缓存2更新============");
                return coursesMapper.selectList(Wrappers.lambdaQuery(Courses.class).in(Courses::getId, 12));
            });
            myExecutor.execute(futureTask);
            return futureTask.get();
        });*//*

        // AsyncCacheLoader 使用自己的线程池刷新数据
        asyncCourseCache2 = Caffeine.newBuilder().maximumSize(2).expireAfterAccess(3L, TimeUnit.SECONDS).buildAsync(new AsyncCacheLoader<Object, List<Courses>>() {
            @Override
            public @NonNull CompletableFuture<List<Courses>> asyncLoad(@NonNull Object o, @NonNull Executor executor) {
                CompletableFuture<List<Courses>> completableFuture = CompletableFuture.supplyAsync(() -> {
                    return coursesMapper.selectList(Wrappers.lambdaQuery(Courses.class).in(Courses::getId, 15));
                }, myExecutor);
                return completableFuture;
            }
        });
    }
}*/
