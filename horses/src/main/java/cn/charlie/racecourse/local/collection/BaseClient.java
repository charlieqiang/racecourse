package cn.charlie.racecourse.local.collection;

import cn.charlie.racecourse.local.util.ThreadUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author charlie
 * @date 3/17/2023 11:56 PM
 **/
public class BaseClient {
    public final static String KEY = "KEY";

    public AtomicInteger baseOperate() {
        ExecutorService executor = ThreadUtil.createTreadPool();
        int treadQty = 2;

        final Map<String, AtomicInteger> countMap = new ConcurrentHashMap<>();
        final CountDownLatch latch = new CountDownLatch(treadQty);

        for (int i = 0; i < treadQty; i++) {
            executor.submit(() -> updateCountMap(countMap, latch));
        }

        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countMap.get(KEY);
    }

    private void updateCountMap(Map<String, AtomicInteger> countMap, CountDownLatch latch) {
        try {
            doUpdateCountMap(countMap);
        } finally {
            latch.countDown();
        }
    }

    private void doUpdateCountMap(Map<String, AtomicInteger> countMap) {
        AtomicInteger temp;
        int updateTimes = 5;
        for (int i = 0; i < updateTimes; i++) {
            temp = countMap.get(KEY);
            if (null == temp) {
                AtomicInteger zeroValue = new AtomicInteger(0);
                temp = countMap.putIfAbsent(KEY, zeroValue);
                if (null == temp) {
                    temp = zeroValue;
                }
            }
            temp.incrementAndGet();
        }
    }
}
