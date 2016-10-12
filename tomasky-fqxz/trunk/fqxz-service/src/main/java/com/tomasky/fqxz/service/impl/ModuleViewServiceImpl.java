package com.tomasky.fqxz.service.impl;

import com.tomasky.fqxz.common.Constants;
import com.tomasky.fqxz.mapper.IModuleMapper;
import com.tomasky.fqxz.model.Module;
import com.tomasky.fqxz.service.IModuleViewService;
import com.tomasky.fqxz.service.handler.CheckParamHandler;
import com.tomasky.fqxz.service.handler.ReturnHandler;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 9:30
 * Version: 1.0
 * Description: 阐述
 */
@Service
public class ModuleViewServiceImpl implements IModuleViewService {

    private static final Logger logger = LoggerFactory.getLogger(ModuleViewServiceImpl.class);

    @Autowired
    IModuleMapper moduleMapper;

    @Override
    public Map getModuleViewList(Long innId) {
        Map result;
        try {
            Map check = CheckParamHandler.checkInnIdNotNull(innId);
            if (MapUtils.isNotEmpty(check)) {
                return check;
            }
            Module module = new Module();
            module.setInnId(innId);
            List<Module> list = moduleMapper.selectByModel(module);
            result = ReturnHandler.success(list);
        } catch (Exception e) {
            logger.error("查询模块列表异常", e);
            result = ReturnHandler.systomError("查询模块列表异常");
        }
        return result;
    }

}
