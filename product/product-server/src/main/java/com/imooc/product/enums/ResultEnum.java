package com.imooc.product.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-06
 * @Time: 21:15
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIT(0, "商品不存在"),
    STOCK_NOT_ENUM(1, "库存不够"),;


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
