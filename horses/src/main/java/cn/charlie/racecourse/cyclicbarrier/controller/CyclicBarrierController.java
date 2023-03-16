package cn.charlie.racecourse.cyclicbarrier.controller;

import cn.charlie.racecourse.cyclicbarrier.service.CyclicBarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlie
 * @date 3/16/2023 2:42 PM
 **/
@RestController
@RequestMapping("/cyclicbarrier")
public class CyclicBarrierController {

    @Autowired
    private CyclicBarrierService cyclicBarrierService;

    @GetMapping("/dinner")
    public void haveDinnerTogether() {
        cyclicBarrierService.haveDinnerTogether();
    }
}
