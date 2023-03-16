package cn.charlie.racecourse.cyclicbarrier.service;

import cn.charlie.racecourse.util.ApplicationContextUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * @author charlie
 * @date 3/16/2023 2:47 PM
 **/
@Service
public class CyclicBarrierServiceImpl implements CyclicBarrierService{

    @Override
    @Async("fastHorsesExecutor")
    public void waitForDinner(Integer member, CyclicBarrier cyclicBarrier) {
        try {
            System.out.println(member +" stand by");
            cyclicBarrier.await();
            System.out.println(member +" begin to have");
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void haveDinnerTogether() {
        int homeMembers = 7;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(homeMembers);
        for (int i = 0; i < homeMembers; i++) {
            ApplicationContextUtil.getBean(CyclicBarrierService.class).waitForDinner(i, cyclicBarrier);
        }
    }
}
