package cn.charlie.racecourse.threadpool;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;

/**
 * @author charlie
 * @date 2023/10/30 14:29
 **/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ThreadPoolTest {
    @Test
    @Order(1)
    public void testDoSth() throws InterruptedException {
        ThreadPoolClient threadPoolClient = new ThreadPoolClient();
        threadPoolClient.doSth();
    }
}
