package cn.charlie.racecourse.local.future;

import cn.charlie.racecourse.local.util.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author charlie
 * @date 3/16/2023 9:16 PM
 **/
public class AppleOperation {

    public Integer getAppleQty() throws InterruptedException, ExecutionException {
        ExecutorService executor = ThreadUtil.createTreadPool();
        int operateQty = 8;
        Integer appleQty = 0;
        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < operateQty; i++) {
            Future<Integer> appleHandler = executor.submit(() -> {
                int qty = 1;
                Thread.sleep(1000);
                return qty;
            });
            futureList.add(appleHandler);
        }
        for (Future<Integer> item : futureList) {
            appleQty += item.get();
            System.out.println("qty: " + appleQty);
        }
        return appleQty;
    }
}
