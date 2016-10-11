package com.tomasky.fqxz.mapper;

import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.bo.param.product.ProductBo;
import com.tomasky.fqxz.model.Product;
import com.tomasky.fqxz.model.ProductOrder;
import com.tomasky.fqxz.vo.ProductOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author simple
 * @data 2016/10/10
 */
@Mapper
public interface IProductOrderMapper {
    /**
     * 根据订单号查询订单详情
     * @param orderNo 订单号
     */
    ProductOrder selectProductOrderByOrderNo(String orderNo);

    Integer saveProductOrder(ProductOrderVo productOrderVo);
}
