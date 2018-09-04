package com.imooc.product.service;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-03
 * @Time: 17:03
 */

public class IProductInfoServiceTest extends ProductApplicationTests {


    @Autowired
    private IProductInfoService productInfoService;


    @Test
    public void findByProductStatus() {

        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        System.out.println(productInfoList);

    }
}