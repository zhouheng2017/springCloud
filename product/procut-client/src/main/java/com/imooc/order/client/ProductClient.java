package com.imooc.order.client;

//import org.springframework.cloud.netflix.fegin.FeignClient;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-05
 * @Time: 21:16
 */
//访问product服
@Component
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/rest")
    String productRest();

    @PostMapping("/product/listProduct")
    List<ProductInfo> listProduct(@RequestBody List<String> IdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
