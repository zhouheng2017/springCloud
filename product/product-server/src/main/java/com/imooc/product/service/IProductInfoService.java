package com.imooc.product.service;

import com.imooc.product.dataobject.DecreaseStockInput;
import com.imooc.product.dataobject.ProductInfoOutput;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-03
 * @Time: 16:57
 */
public interface IProductInfoService {

    /**
     * 查询所有的在线商品
     *
     * @return
     */
    List<ProductInfoOutput> findUpAll();

    List<ProductInfoOutput> findByProductIdList(List<String> productIdList);

    void decreaseStock(List<DecreaseStockInput> cartDTOList);

}
