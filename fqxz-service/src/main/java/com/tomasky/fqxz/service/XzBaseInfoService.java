package com.tomasky.fqxz.service;

import com.tomasky.fqxz.bo.param.baseInfo.XzBaseInfoBo;
import com.tomasky.fqxz.common.core.orm.Page;
import com.tomasky.fqxz.mapper.XzBaseInfoMapper;
import com.tomasky.fqxz.model.XzBaseinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XzBaseInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XzBaseInfoService.class);

    @Autowired
    private XzBaseInfoMapper xzBaseInfoMapper;

    public List<XzBaseinfo> findList(XzBaseInfoBo param) {
        return xzBaseInfoMapper.getXzBaseInfos(param);
    }

    public Page<XzBaseinfo> getPageRecord(XzBaseInfoBo param) {
        Page<XzBaseinfo> page = new Page(param.getPageNo(), param.getPageSize());
//        page.setTotalCount(xzBaseInfoMapper.getXzBaseInfosCount(param));
//        if (page.getTotalCount() == 0) {  //总数为0 无需继续查询详情
//            return page;
//        }
        page.setResult(findList(param));
        return page;
    }

}
