package com.thm.springcloud.controller;

import com.thm.springcloud.base.CommonResult;
import com.thm.springcloud.entity.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/get")
    public CommonResult getOrder(){
        Order order = new Order();
        return CommonResult.success(port,order);
    }

}
