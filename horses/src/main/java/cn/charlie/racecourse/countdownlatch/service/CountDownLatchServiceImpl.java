package cn.charlie.racecourse.countdownlatch.service;

import cn.charlie.racecourse.util.ApplicationContextUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author charlie
 * @date 3/15/2023 3:24 PM
 **/
@Service
public class CountDownLatchServiceImpl implements CountDownLatchService{

    @Override
    @Async("fastHorsesExecutor")
    public void echo(Integer num, CountDownLatch countDownLatch) {
        try {
            System.out.println(num);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    @Override
    public void collectBalls() {
        int ballsCount = 7;
        final CountDownLatch countDownLatch = new CountDownLatch(ballsCount);
        System.out.println("collectBalls: collect begin");
        for (int i = 0; i < ballsCount; i++) {
            ApplicationContextUtil.getBean(CountDownLatchService.class).echo(i, countDownLatch);
        }
        try {
            boolean isCollected = countDownLatch.await(5, TimeUnit.MINUTES);
            if (isCollected) {
                System.out.println("collectBalls: collect end");
            } else {
                System.out.println("collectBalls: collect failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}