package com.tomasky.fqxz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomasky.fqxz.bo.param.baseInfo.XzBaseInfoBo;
import com.tomasky.fqxz.mapper.XzBaseInfoMapper;
import com.tomasky.fqxz.model.XzBaseinfo;
import com.tomasky.fqxz.service.handler.ReturnHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class XzBaseInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XzBaseInfoService.class);

    @Autowired
    private XzBaseInfoMapper xzBaseInfoMapper;

    public List<XzBaseinfo> findList(XzBaseInfoBo param) {
        return xzBaseInfoMapper.getXzBaseInfos(param);
    }

    public PageInfo<XzBaseinfo> getPageRecord(XzBaseInfoBo param) {
        PageHelper.startPage(param.getPageNo(), param.getPageSize());
        List<XzBaseinfo> users = xzBaseInfoMapper.getXzBaseInfos(param);
        return new PageInfo(users);
    }


    public Map getInnPayType(Long innId) {
        XzBaseinfo xzBaseinfo = xzBaseInfoMapper.getInnPayTypeAndKnows(innId);
        return ReturnHandler.success(xzBaseinfo);
    }
}
