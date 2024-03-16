package workspace.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/12 19:56:58
 */
@Configuration
@EnableCaching
public class MySpringCacheConfig {

    // @Bean
    // public CacheManager myCacheManager() {
    //     SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
    //     Set<Cache> set = new HashSet<>();
    //     set.add(new CaffeineCache("MyCache", Caffeine.newBuilder().initialCapacity(5)
    //             .maximumSize(10).expireAfterAccess(5, TimeUnit.SECONDS).build()));
    //     simpleCacheManager.setCaches(set);
    //     return simpleCacheManager;
    // }

    // @Bean
    // public CacheManager myCacheManager() {
    //     CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    //     Caffeine<Object, Object> caffeine = Caffeine.newBuilder().initialCapacity(5).maximumSize(10)
    //             .expireAfterAccess(5, TimeUnit.SECONDS);
    //     cacheManager.setCaffeine(caffeine);
    //     return cacheManager;
    // }

    @Autowired
    private RedisTemplate<String, Object> myRedisTemplate;

    @Bean
    public CacheManager myCacheManager() {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(myRedisTemplate.getConnectionFactory());
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(myRedisTemplate.getValueSerializer()))
                .entryTtl(Duration.ofSeconds(60));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}
