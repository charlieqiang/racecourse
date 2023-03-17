package cn.charlie.racecourse.cpu;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;


/**
 * @author charlie
 * @date 3/15/2023 2:03 PM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CpuThreadTest {

    @Test
    @Order(1)
    public void oneThreadFullLoadTest() {
        while (true) {
        }
    }

    @Test
    @Order(2)
    public void eightThreadFullLoadTest() {
        int theadQty = 7;
        for (int j = 0; j < theadQty; j++) {
            new Thread(() -> {
                while (true){
                }
            }).start();
        }
        while (true) {
        }
    }
}
