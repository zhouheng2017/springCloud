package com.imooc.product.exception;

import com.imooc.product.enums.ResultEnum;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-06
 * @Time: 21:13
 */
public class ProductException extends RuntimeException {


    private Integer code;

    public ProductException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {

        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

    }
}
