package cn.charlie.racecourse.local.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @author charlie
 * @date 2023/10/26 10:49
 **/
public class MemoryLeakClient {
    private static final ThreadLocal<Byte[]> threadLocal = new ThreadLocal<>();

    public void useMemory() throws InterruptedException {
        threadLocal.set(new Byte[50 * 1024 * 1024]);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("used");
        // threadLocal.remove();
        // System.out.println("removed");
        while (true) {
            TimeUnit.MICROSECONDS.sleep(100);
        }
    }

}
