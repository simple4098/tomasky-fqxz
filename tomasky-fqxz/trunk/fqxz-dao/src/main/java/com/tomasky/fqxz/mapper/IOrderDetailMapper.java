package com.tomasky.fqxz.mapper;

import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.bo.param.product.ProductBo;
import com.tomasky.fqxz.model.OrderDetail;
import com.tomasky.fqxz.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author simple
 * @data 2016/10/10
 */
@Mapper
public interface IOrderDetailMapper {

    void saveOrderDetail(OrderDetail orderDetail);

}
