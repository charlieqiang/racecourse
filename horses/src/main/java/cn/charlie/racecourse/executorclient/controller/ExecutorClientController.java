package cn.charlie.racecourse.executorclient.controller;

import cn.charlie.racecourse.executorclient.service.ExecutorClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlie
 * @date 3/15/2023 10:27 AM
 **/
@RestController
@RequestMapping("/executorclient")
public class ExecutorClientController {

    @Autowired
    private ExecutorClientService executorClientService;

    @GetMapping("/dataset")
    public void calculateDataSet() {
        executorClientService.calculateDataSet();
        System.out.println("calculateDataSet: calculate job begin");
    }
}
