/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tomasky.fqxz.web;

import com.github.pagehelper.PageInfo;
import com.tomasky.fqxz.BaseController;
import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.dao.XzBaseinfoRepo;
import com.tomasky.fqxz.model.Product;
import com.tomasky.fqxz.service.IProductService;
import com.tomasky.fqxz.service.XzBaseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private XzBaseInfoService xzBaseInfoService;
    @Autowired
    private IProductService productService;

    @Autowired
    private XzBaseinfoRepo xzBaseinfoRepo;

    @RequestMapping("/list")
    public Map<String, Object> getAllInns(CommParam commParam) {
        try {
            PageInfo<Product> productByInnId = productService.findProductByInnId(commParam);
            return new200(productByInnId);
        } catch (Exception e) {
            LOGGER.error("商品列表异常:", e);
            return new500(e.getMessage());
        }

    }

    @RequestMapping("/one")
    public Map<String, Object> getOne() {
        return new200(xzBaseinfoRepo.findById(3611l));
    }

}
