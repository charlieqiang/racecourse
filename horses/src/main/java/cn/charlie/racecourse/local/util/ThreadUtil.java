package cn.charlie.racecourse.local.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author charlie
 * @date 3/16/2023 9:29 PM
 **/
public class ThreadUtil {
    /**
     * 核心线程池大小
     */
    private static final int CORE_POOL_SIZE = 8;
    /**
     * 最大可创建的线程数
     */
    private static final int MAX_POOL_SIZE = CORE_POOL_SIZE;
    /**
     * 队列最大长度
     */
    private static final int QUEUE_CAPACITY = 1024;
    /**
     * 线程池维护线程所允许的空闲时间
     */
    private static final int KEEP_ALIVE_SECONDS = 60;

    public static ExecutorService createTreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("apple-box-thread-pool-%d").build();

        return new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_SECONDS,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>(QUEUE_CAPACITY),
                namedThreadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    public static void sleep() throws InterruptedException {
        System.out.println("sleepThread: " + Thread.currentThread().getName());
        while (true) {
            Thread.sleep(100);
        }
    }
}
