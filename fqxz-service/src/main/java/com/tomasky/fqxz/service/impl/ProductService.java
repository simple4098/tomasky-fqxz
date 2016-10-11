package com.tomasky.fqxz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.common.exception.ProductException;
import com.tomasky.fqxz.mapper.IProductMapper;
import com.tomasky.fqxz.model.Product;
import com.tomasky.fqxz.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author simple
 * @data 2016/10/10
 */
@Service
public class ProductService implements IProductService {
    @Resource
    private IProductMapper productMapper;

    @Override
    public PageInfo<Product> findProductByInnId(CommParam param) throws ProductException {
        Assert.notNull(param.getInnId());
        PageHelper.startPage(param.getPageNo(), param.getPageSize());
        List<Product> productList = productMapper.selectProductByInnId(param);
        return new PageInfo(productList);
    }
}
