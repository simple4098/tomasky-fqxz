package com.tomasky.fqxz.mapper;

import com.tomasky.fqxz.bo.param.baseInfo.XzBaseInfoBo;
import com.tomasky.fqxz.model.XzBaseinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface XzBaseInfoMapper {

    List<XzBaseinfo> getXzBaseInfos(XzBaseInfoBo param);

    Long getXzBaseInfosCount(XzBaseInfoBo param);

    XzBaseinfo getInnPayTypeAndKnows(@Param("innId") Long innId);
}
