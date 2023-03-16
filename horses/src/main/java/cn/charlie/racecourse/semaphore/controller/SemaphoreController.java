package cn.charlie.racecourse.semaphore.controller;

import cn.charlie.racecourse.semaphore.service.SemaphoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlie
 * @date 3/16/2023 4:53 PM
 **/
@RestController
@RequestMapping("/semaphore")
public class SemaphoreController {
    @Autowired
    private SemaphoreService semaphoreService;

    @GetMapping("/highway")
    public void throughHighWay() {
        semaphoreService.throughHighWay();
    }
}
