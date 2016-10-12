package com.tomasky.fqxz.web;

import com.tomasky.fqxz.service.IModuleViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 9:20
 * Version: 1.0
 * Description: 界面模块controller
 */
@RestController
@RequestMapping("/module/")
public class ModuleViewController {

    private static final Logger logger = LoggerFactory.getLogger(ModuleViewController.class);

    @Autowired
    IModuleViewService moduleViewService;

    @RequestMapping("list")
    public Map viewList(Long innId) {
        logger.info("查询模块列表，参数innId:" + innId);
        return moduleViewService.getModuleViewList(innId);
    }
}
