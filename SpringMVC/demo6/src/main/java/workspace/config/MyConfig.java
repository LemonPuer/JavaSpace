package workspace.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFutureTask;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.*;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/04 09:17:42
 */
@Slf4j
@SpringBootConfiguration
public class MyConfig implements WebMvcConfigurer {
    @Autowired
    private CoursesInterceptor myInterceptor;

    // 发现这个自定义的线程池没有关闭日志
/*    @Bean
    public ThreadPoolExecutor myExecutor() {
        log.info("自定义线程池创建");
        return new ThreadPoolExecutor(3, 6, 120, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactory() {
                    private int count;

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("myThreadPool-" + count++);
                        return thread;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());
    }*/
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 使用Spring框架提供的一个线程池实现：ThreadPoolTaskExecutor;但还是没有关闭日志
     * 不放心可以使用@PreDestroy在方法中进行关闭
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor myExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(3);
        pool.setMaxPoolSize(6);
        pool.setQueueCapacity(10);
        pool.setKeepAliveSeconds(120);
        pool.setThreadNamePrefix("myThreadPool-");
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return pool;
    }

    @Bean
    public RedisTemplate<String, Object> myTemplate(@Autowired LettuceConnectionFactory factory) {
        RedisTemplate<String, Object> myTemplate = new RedisTemplate<>();
        myTemplate.setConnectionFactory(factory);
        myTemplate.setKeySerializer(RedisSerializer.string());
        myTemplate.setValueSerializer(RedisSerializer.json());
        myTemplate.setHashKeySerializer(RedisSerializer.string());
        myTemplate.setHashValueSerializer(RedisSerializer.json());
        return myTemplate;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
