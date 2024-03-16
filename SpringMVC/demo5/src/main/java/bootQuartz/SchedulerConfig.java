package bootQuartz;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/04 16:43:18
 */
@Configuration
public class SchedulerConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setSchedulerName("MyScheduler");
        factoryBean.setDataSource(dataSource);
        // 设置配置文件
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/spring-quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        factoryBean.setQuartzProperties(propertiesFactoryBean.getObject());
        factoryBean.setTaskExecutor(schedulerThreadPool());
        //设置延迟时间
        factoryBean.setStartupDelay(0);
        return factoryBean;
    }

    @Bean
    public Executor schedulerThreadPool() {
        //ThreadPoolTaskExecutor是Spring框架提供的一个线程池实现，通常用于管理任务的执行。
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        // 设置线程数为虚拟机可用的处理器数
        threadPool.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        threadPool.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
        threadPool.setQueueCapacity(Runtime.getRuntime().availableProcessors());
        return threadPool;
    }
}
