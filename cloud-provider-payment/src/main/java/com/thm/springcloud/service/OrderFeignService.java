package com.thm.springcloud.service;

import com.thm.springcloud.base.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cloud-order-service",path = "/order")
public interface OrderFeignService {

    @RequestMapping("/get")
    CommonResult getOrder();

}
