package cn.charlie.racecourse.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author charlie
 * @date 2023/10/28 11:08
 **/
public class ThreadPoolClient {
    private static final int CORE_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 1024;

    private ExecutorService getExecutorService() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("manual-thread-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(CORE_POOL_SIZE,
                CORE_POOL_SIZE,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(QUEUE_CAPACITY),
                namedThreadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
        return executorService;
    }

    public void doSth() throws InterruptedException {
        ExecutorService executorService = getExecutorService();
        try {
            for (int i = 0; i < 10; i++) {
                executorService.submit(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("sth done");
                });
            }
        } finally {
            // executorService.shutdownNow();
            executorService.shutdown();
        }

        System.out.println("thread submit done");

        while (true) {
            TimeUnit.MICROSECONDS.sleep(100);
        }
    }
}
