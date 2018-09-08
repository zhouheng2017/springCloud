package com.imooc.product.controller;

import com.google.common.collect.Lists;
import com.imooc.product.VO.ProductInfoVO;
import com.imooc.product.VO.ProductVO;
import com.imooc.product.VO.ResultVO;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.service.IProductInfoService;
import com.imooc.product.service.ProductCategoryService;
import com.imooc.product.util.ResultVOUtil;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-03
 * @Time: 16:55
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;


    @GetMapping("/list")
    public ResultVO list(Integer productStatus) {

        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOS = Lists.newArrayList();
        for (ProductCategory productCategory : productCategoryList) {

            List<ProductInfoVO> productInfoVOList = Lists.newArrayList();

            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {

                    ProductInfoVO productInfoVO = ProductInfoVO.adapt(productInfo);
                    productInfoVOList.add(productInfoVO);
                }

            }
            ProductVO productVO = ProductVO.builder()
                    .categoryName(productCategory.getCategoryName())
                    .categoryType(productCategory.getCategoryType())
                    .productInfoVOList(productInfoVOList)
                    .build();

            productVOS.add(productVO);

        }


        return ResultVOUtil.success(productVOS);
    }


    /**
     * 获取商品的列表
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listProduct")
    public List<ProductInfo> listProduct(@RequestBody List<String> productIdList) {

        List<ProductInfo> productInfoList = productInfoService.findByProductIdList(productIdList);
        return productInfoList;

    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {

        productInfoService.decreaseStock(cartDTOList);

    }
}
