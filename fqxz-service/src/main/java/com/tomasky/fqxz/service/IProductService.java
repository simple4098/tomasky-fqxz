package com.tomasky.fqxz.service;

import com.github.pagehelper.PageInfo;
import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.common.exception.ProductException;
import com.tomasky.fqxz.model.Product;

/**
 * @author simple
 * @data 2016/10/10
 */
public interface IProductService {

    PageInfo<Product> findProductByInnId(CommParam commParam) throws ProductException;
}
