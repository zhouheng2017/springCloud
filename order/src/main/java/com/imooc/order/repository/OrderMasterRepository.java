package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-04
 * @Time: 21:37
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {


}