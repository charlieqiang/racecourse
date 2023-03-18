package cn.charlie.racecourse.local.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author charlie
 * @date 3/18/2023 10:57 AM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    @Test
    @Order(1)
    public void testBase(){
        AtomicInteger res = new BaseClient().baseOperate();
        AtomicInteger expect = new AtomicInteger(10);
        Assertions.assertEquals(expect.get(), res.get());
    }
}