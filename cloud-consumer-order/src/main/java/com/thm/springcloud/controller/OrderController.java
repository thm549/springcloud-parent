package com.thm.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thm.springcloud.base.CommonResult;
import com.thm.springcloud.entity.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${server.port}")
    private String port;

    @HystrixCommand(fallbackMethod = "getOrderFallBack")
    @RequestMapping("/get")
    public CommonResult getOrder(){
        Order order = new Order();
        int i = 1/0;
        return CommonResult.success(port,order);
    }

    public CommonResult getOrderFallBack(){
        return CommonResult.success("error !!!",new Order());
    }

}
