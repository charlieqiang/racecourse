package cn.charlie.racecourse.executorclient.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author charlie
 * @date 3/15/2023 10:51 AM
 **/
@Service
public class ExecutorClientServiceImpl implements ExecutorClientService {
    @Override
    @Async("fastHorsesExecutor")
    public void calculateDataSet() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tread: " + Thread.currentThread().getName() + " calculateDataSet: calculate job end");
    }
}
