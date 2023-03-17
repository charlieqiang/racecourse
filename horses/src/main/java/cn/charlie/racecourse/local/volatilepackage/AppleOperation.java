package cn.charlie.racecourse.local.volatilepackage;

import cn.charlie.racecourse.local.entity.AppleBox;
import cn.charlie.racecourse.local.util.ThreadUtil;

import java.util.concurrent.ExecutorService;

/**
 * @author charlie
 * @date 3/17/2023 5:28 PM
 **/
public class AppleOperation {
    // 可见性
    private static volatile AppleBox appleBox;

    public void buildAppleBox() throws InterruptedException {
        ExecutorService executor = ThreadUtil.createTreadPool();
        appleBox = new AppleBox(0);

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
        ThreadUtil.sleep();
    }

    private void addApple(AppleBox appleBox) throws InterruptedException {
        doAddApple(appleBox);
    }

    private void doAddApple(AppleBox appleBox) throws InterruptedException {
        Integer qty = appleBox.getAppleQty();
        appleBox.setAppleQty(++qty);
        System.out.println(appleBox.getAppleQty());
    }
}
