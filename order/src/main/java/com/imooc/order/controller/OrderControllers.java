package com.imooc.order.controller;


import com.imooc.order.client.ProductClient;

import com.imooc.product.dataobject.DecreaseStockInput;
import com.imooc.product.dataobject.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-04
 * @Time: 21:58
 */
@RestController
@Slf4j
public class OrderControllers {
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
//    @Autowired
//    private RestTemplate restTemplate;


    @Autowired
    private ProductClient productClient;


    @GetMapping("/productService")
    @ResponseBody
    public Object productService() {

////        方式一直接通过restTemplate写死
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject("http://localhost:8080/rest", String.class);
//        log.error("{}", forObject);
//
////        方式二通过LoadBalancerClient构建url
//        ServiceInstance product = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", product.getHost(), product.getPort() + "/rest");
//        String response = restTemplate.getForObject(url, String.class);

//        String response = restTemplate.getForObject("http://PRODUCT/rest", String.class);
        List<ProductInfoOutput> productInfoList = productClient.listProduct(Arrays.asList("123456", "12345678"));

        log.error("{}", productInfoList);
        return productInfoList;
    }

    @PostMapping("/decrease")
    public String decrease() {
        DecreaseStockInput cartDTO = new DecreaseStockInput("12345678", 2);

        productClient.decreaseStock(Arrays.asList(cartDTO));

        return "ok";
    }

}
