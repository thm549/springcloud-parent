package com.thm.springcloud.controller;

import com.thm.springcloud.base.CommonResult;
import com.thm.springcloud.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_NAME = "http://cloud-order-service";

    @Autowired
    private OrderFeignService orderFeignService;

    @RequestMapping("/order")
    public CommonResult getOrder(){
//        CommonResult object = restTemplate.getForObject(SERVICE_NAME+"/order/get", CommonResult.class);
        CommonResult object = orderFeignService.getOrder();
        return object;
    }

}
