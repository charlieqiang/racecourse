package cn.charlie.racecourse.semaphore.service;

import cn.charlie.racecourse.util.ApplicationContextUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Semaphore;

/**
 * @author charlie
 * @date 3/16/2023 4:54 PM
 **/
@Service
public class SemaphoreServiceImpl implements SemaphoreService {

    @Override
    @Async("fastHorsesExecutor")
    public void takeCard(Semaphore semaphore) {
        try {
            System.out.println("taking");
            Thread.sleep(2000);
            System.out.println("taken");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void throughHighWay() {
        int cardOfficeQty = 6;
        int carQty = 12;
        Semaphore semaphore = new Semaphore(cardOfficeQty);
        for (int i = 0; i < carQty; i++) {
            try {
                semaphore.acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ApplicationContextUtil.getBean(SemaphoreService.class).takeCard(semaphore);
        }
    }
}
