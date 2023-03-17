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
    public static ExecutorService createTreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("apple-box-thread-pool-%d").build();

        return new ThreadPoolExecutor(8,
                8,
                0L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>(8),
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
