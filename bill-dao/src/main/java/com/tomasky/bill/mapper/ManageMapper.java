package com.tomasky.bill.mapper;

import com.tomasky.bill.bo.param.manage.InnBo;
import com.tomasky.bill.vo.manage.InnVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Created by X on 2016/9/7.
 */
@Mapper
public interface ManageMapper {

    List<InnVo> getInnInfos(InnBo param);

    Long getInnInfosCount(InnBo param);

}
