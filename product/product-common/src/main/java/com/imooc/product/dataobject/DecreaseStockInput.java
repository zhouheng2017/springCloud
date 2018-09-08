package com.imooc.product.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-06
 * @Time: 21:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecreaseStockInput {

    private String productId;
    private Integer productQuantity;


}
