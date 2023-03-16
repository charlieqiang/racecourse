package cn.charlie.racecourse.semaphore.service;

import java.util.concurrent.Semaphore;

/**
 * @author charlie
 * @date 3/16/2023 4:53 PM
 **/
public interface SemaphoreService {

    /**
     * 拿卡
     *
     * @param semaphore 信号量
     */
    void takeCard(Semaphore semaphore);

    /**
     * 上高速
     */
    void throughHighWay();
}
