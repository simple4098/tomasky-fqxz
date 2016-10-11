package com.tomasky.fqxz.dao;

import com.tomasky.fqxz.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author simple
 * @data 2016/10/10
 */
@Repository
public interface IProductDao extends CrudRepository<Product, Long> {


    Product findById(Long id);
}
