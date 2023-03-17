package cn.charlie.racecourse.local.reentrantlock;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author charlie
 * @date 3/16/2023 5:54 PM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    @Test
    @Order(1)
    public void testBase() throws InterruptedException {
        new AppleOperation().buildAppleBox();
    }
}
