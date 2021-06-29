package com.thm.springcloud.controller;

import com.thm.springcloud.base.CommonResult;
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

    @RequestMapping("/order")
    public CommonResult getOrder(){
        CommonResult forObject = restTemplate.getForObject(SERVICE_NAME+"/order/get", CommonResult.class);
        return forObject;
    }

}
