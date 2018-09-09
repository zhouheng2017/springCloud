package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductInfoOutput;
import com.imooc.product.dataobject.DecreaseStockInput;
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
    public List<ProductInfoOutput> findUpAll() {
        return productInfoRepository.findByStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findByProductIdList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional(rollbackFor = ProductException.class)
    public void decreaseStock(List<DecreaseStockInput> cartDTOList) {

        for (DecreaseStockInput cartDTO : cartDTOList) {
            Optional<ProductInfoOutput> productInfo = productInfoRepository.findById(cartDTO.getProductId());

            if (!productInfo.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIT);
            }

            ProductInfoOutput product = productInfo.get();

            Integer stock = product.getProductStock() - cartDTO.getProductQuantity();
            if (stock < 0) {

                throw new ProductException(ResultEnum.STOCK_NOT_ENUM);
            }

            product.setProductStock(stock);

            productInfoRepository.save(product);

        }
    }

}
