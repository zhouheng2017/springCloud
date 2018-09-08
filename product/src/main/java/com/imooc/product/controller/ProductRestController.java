package com.imooc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-04
 * @Time: 21:55
 */
@RestController
public class ProductRestController {

    @GetMapping("/rest")
    public String rest() {
        return "This is rest Controller";
    }

}
