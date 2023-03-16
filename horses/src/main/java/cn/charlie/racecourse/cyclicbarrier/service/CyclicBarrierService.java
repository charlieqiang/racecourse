package cn.charlie.racecourse.cyclicbarrier.service;

import java.util.concurrent.CyclicBarrier;

/**
 * @author charlie
 * @date 3/16/2023 2:47 PM
 **/
public interface CyclicBarrierService {

    /**
     * 并发等待家人到齐后开始完饭
     */
    void waitForDinner(Integer member, CyclicBarrier cyclicBarrier);

    /**
     * 吃晚饭
     */
    void haveDinnerTogether();
}