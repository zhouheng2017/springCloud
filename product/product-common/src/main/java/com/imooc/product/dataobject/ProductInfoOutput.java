package com.imooc.product.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author zhouheng
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ProductInfoOutput {
    /** id*/
    @Id
    private String productId;

    /** 名称*/
    private String productName;

    /**价格*/
    private BigDecimal productPrice;

    /** 库存*/

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer status;

    private Integer categoryType;





}