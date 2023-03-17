package cn.charlie.racecourse.local.future;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.concurrent.ExecutionException;

/**
 * @author charlie
 * @date 3/16/2023 10:05 PM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    @Test
    @Order(1)
    public void testBase() throws InterruptedException, ExecutionException {
        Integer appleQty = new AppleOperation().getAppleQty();
        Integer expectQty = 8;
        Assertions.assertEquals(expectQty, appleQty);
    }
}
