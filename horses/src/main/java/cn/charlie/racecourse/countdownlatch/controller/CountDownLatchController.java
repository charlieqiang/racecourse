package cn.charlie.racecourse.countdownlatch.controller;

import cn.charlie.racecourse.countdownlatch.service.CountDownLatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlie
 * @date 3/15/2023 3:21 PM
 **/
@RestController
@RequestMapping("/countdownlatch")
public class CountDownLatchController {
    @Autowired
    private CountDownLatchService countDownLatchService;

    @GetMapping("/balls")
    public void collectBalls() {
        countDownLatchService.collectBalls();
    }
}
