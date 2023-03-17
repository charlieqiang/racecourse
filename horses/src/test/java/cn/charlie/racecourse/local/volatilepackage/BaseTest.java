package cn.charlie.racecourse.local.volatilepackage;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author charlie
 * @date 3/17/2023 5:35 PM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    @Test
    @Order(1)
    public void testBase() throws InterruptedException {
        new AppleOperation().buildAppleBox();
    }
}
