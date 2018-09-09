package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderMaster;
import org.hibernate.criterion.Example;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-04
 * @Time: 21:39
 */

public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234");
        orderMaster.setBuyerAddress("address");
        orderMaster.setBuyerName("name");
        orderMaster.setBuyerPhone("ponnee");
        orderMaster.setBuyerOpenid("openid");
        orderMaster.setOrderAmount(new BigDecimal(2));
        orderMaster.setOrderStatus(0);
        orderMaster.setPayStatus(1);

        orderMasterRepository.save(orderMaster);
    }


}