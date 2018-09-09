package com.imooc.product.enums;

import lombok.Getter;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-04
 * @Time: 13:16
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在线"),
    DOWN(1, "下架"),;


    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
