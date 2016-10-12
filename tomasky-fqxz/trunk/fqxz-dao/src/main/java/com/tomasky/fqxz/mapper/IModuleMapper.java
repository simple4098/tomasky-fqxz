package com.tomasky.fqxz.mapper;

import com.tomasky.fqxz.model.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by jame
 * Date: 2016/10/11 9:32
 * Version: 1.0
 * Description: 阐述
 */
@Mapper
public interface IModuleMapper {

    List<Module> selectByModel(Module module);
}
