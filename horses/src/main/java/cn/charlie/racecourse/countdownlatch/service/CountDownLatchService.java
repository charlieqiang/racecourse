package cn.charlie.racecourse.countdownlatch.service;

import java.util.concurrent.CountDownLatch;

/**
 * @author charlie
 * @date 3/15/2023 3:24 PM
 **/
public interface CountDownLatchService {

    /**
     * 回音函数 (返回输入数字)
     *
     * @param num 输入
     * @param countDownLatch 闭锁
     */
    void echo(Integer num, CountDownLatch countDownLatch);

    /**
     * 收集龙珠 (并发集齐7颗龙珠后结束)
     */
    void collectBalls();
}
