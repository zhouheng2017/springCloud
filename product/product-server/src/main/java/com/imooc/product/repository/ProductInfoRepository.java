package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfoOutput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-03
 * @Time: 16:54
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfoOutput, String> {

    List<ProductInfoOutput> findByStatus(Integer productStatus);

    List<ProductInfoOutput> findByProductIdIn(List<String> productIdList);



}
