package cn.charlie.racecourse.reentrantlock.base;

import cn.charlie.racecourse.reentrantlock.entity.AppleBox;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author charlie
 * @date 3/16/2023 7:05 PM
 **/
public class AppleOperation {
    private final Lock lock = new ReentrantLock();

    public void buildAppleBox() throws InterruptedException {
        ExecutorService executor = createTreadPool();
        AppleBox appleBox = createAppleBox();

        int appleQty = 8;
        for (int i = 0; i < appleQty; i++) {
            executor.submit(() -> {
                try {
                    addApple(appleBox);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        sleep();
    }

    private AppleBox createAppleBox() {
        return new AppleBox(0);
    }

    private ExecutorService createTreadPool() {
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

    private void addApple(AppleBox appleBox) throws InterruptedException {
        // 阻塞获取锁, 如果长时间获取不到锁, 则不执行
        if (lock.tryLock(8, TimeUnit.SECONDS)) {
            try {
                doAddApple(appleBox);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private void doAddApple(AppleBox appleBox) throws InterruptedException {
        Integer qty = appleBox.getAppleQty();
        appleBox.setAppleQty(++qty);
        System.out.println(appleBox.getAppleQty());
    }

    private void sleep() throws InterruptedException {
        while (true) {
            Thread.sleep(100);
        }
    }
}
