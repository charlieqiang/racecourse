package cn.charlie.racecourse.local.threadlocal;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author charlie
 * @date 3/17/2023 7:00 PM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
    @Test
    @Order(1)
    public void testBase() throws InterruptedException {
        new BaseClient().operateName();
    }

    @Test
    @Order(2)
    public void testMemoryLeak() throws InterruptedException {
        new MemoryLeakClient().useMemory();
    }
}
