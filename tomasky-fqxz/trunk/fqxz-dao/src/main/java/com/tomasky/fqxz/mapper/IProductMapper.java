package com.tomasky.fqxz.mapper;

import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.bo.param.product.ProductBo;
import com.tomasky.fqxz.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author simple
 * @data 2016/10/10
 */
@Mapper
public interface IProductMapper {

    List<Product> selectProductByInnId(CommParam commParam);

    @Select("SELECT  o.* from product o where  o.id=#{id} and o.isshow=1")
    Product selectProductDetailById(@Param("id") Integer id);

    void updateStockAndSales(Product product);
}
