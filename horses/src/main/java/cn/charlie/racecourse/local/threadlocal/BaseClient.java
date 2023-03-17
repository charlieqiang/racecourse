package cn.charlie.racecourse.local.threadlocal;

import cn.charlie.racecourse.local.util.ThreadUtil;

import java.util.concurrent.ExecutorService;

/**
 * @author charlie
 * @date 3/17/2023 6:57 PM
 **/
public class BaseClient {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private String getContent() {
        return threadLocal.get();
    }

    private void setContent(String content) {
        threadLocal.set(content);
    }

    private void getThreadName() {
        System.out.println(Thread.currentThread().getName() + "--->" + this.getContent());
    }

    private void setThreadName() {
        this.setContent(Thread.currentThread().getName());
    }

    public void operateName() throws InterruptedException {
        ExecutorService executor = ThreadUtil.createTreadPool();

        int threadQty = 8;
        for (int i = 0; i < threadQty; i++) {
            int num = i;
            executor.submit(() -> {
                Thread.currentThread().setName("-" + num);
                setThreadName();
                getThreadName();
            });
        }
        ThreadUtil.sleep();
    }
}
