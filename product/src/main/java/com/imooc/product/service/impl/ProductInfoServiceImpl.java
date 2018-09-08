package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.IProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-03
 * @Time: 16:59
 */
@Service
public class ProductInfoServiceImpl implements IProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 查询所有的在线商品
     *
     *
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findByProductIdList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional(rollbackFor = ProductException.class)
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = productInfoRepository.findById(cartDTO.getProductId());

            if (!productInfo.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIT);
            }

            ProductInfo product = productInfo.get();

            Integer stock = product.getProductStock() - cartDTO.getProductQuantity();
            if (stock < 0) {

                throw new ProductException(ResultEnum.STOCK_NOT_ENUM);
            }

            product.setProductStock(stock);

            productInfoRepository.save(product);

        }
    }

}
