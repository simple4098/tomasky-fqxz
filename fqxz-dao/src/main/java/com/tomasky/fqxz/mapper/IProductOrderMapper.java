package com.tomasky.fqxz.mapper;

import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.bo.param.product.ProductBo;
import com.tomasky.fqxz.model.Product;
import com.tomasky.fqxz.model.ProductOrder;
import com.tomasky.fqxz.vo.ProductOrderVo;
import javassist.tools.reflect.Sample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("select * from produnct_order where id=#{id}")
    ProductOrder selectProductOrderById(@Param("id") Integer xzOrderId);

    @Update(" UPDATE produnct_order set paytime = now(),is_pay='1',is_failed=#{isFailed},pay_orderno=#{payOrderNo} where id = #{id} ")
    void updateProductOrder(ProductOrder productOrder);
}
