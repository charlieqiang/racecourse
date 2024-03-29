package cn.charlie.racecourse.config.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description CPU密集型核心数设置为CPU核心数
 * @author charlie
 * @date 3/14/2023 10:41 AM
 **/
@EnableAsync
@Configuration
public class FastHorsesAsyncConfig {
    /**
     * 核心线程池大小
     */
    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    /**
     * 最大可创建的线程数
     */
    private static final int MAX_POOL_SIZE = CORE_POOL_SIZE;
    /**
     * 队列最大长度
     */
    private static final int QUEUE_CAPACITY = 16;
    /**
     * 线程池维护线程所允许的空闲时间
     */
    private static final int KEEP_ALIVE_SECONDS = 60;

    @Bean(name = "fastHorsesExecutor")
    public ThreadPoolTaskExecutor fastHorsesExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程池大小
        executor.setCorePoolSize(CORE_POOL_SIZE);
        // 最大可创建的线程数
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        // 队列最大长度
        executor.setQueueCapacity(QUEUE_CAPACITY);
        // 线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(KEEP_ALIVE_SECONDS);
        // 线程前缀名称
        executor.setThreadNamePrefix("fast-horses-executor-thread-pool-");
        // 拒绝策略: 交给调用线程处理
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
