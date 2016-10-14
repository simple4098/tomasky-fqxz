package com.tomasky.fqxz.web;

import com.tomasky.fqxz.common.core.utils.web.Result;
import com.tomasky.fqxz.common.em.ResultCode;
import com.tomasky.fqxz.common.exception.BusinessException;
import com.tomasky.fqxz.vo.FacilitiesVo;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by LZQ on 2016/10/12.
 */
@Controller
@RequestMapping("/demo")
@Api("一个Swagger Demo案例")
public class DemoController {
    @ApiOperation(value = "获取测试方法",notes = "用于方法1的测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",dataType = "int",paramType = "query",required = true,value ="用户Id",defaultValue = "10"),
            @ApiImplicitParam(name = "name",dataType = "String",paramType = "query",required = true,value ="用户名")
    })
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Result test1(){
        Result result = new Result(ResultCode.SUCCESS);
        Map<String,Object> map = new HashMap<>();
        map.put("id",23);
        map.put("name","zhang三");
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "提交请求测试-传入对象",notes = "用于方法2的测试")
    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public Result test(@ApiParam(name = "用户信息",value = "user") @RequestBody FacilitiesVo user){
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(user);
        return result;
    }

    @ApiOperation(value = "业务异常测试",notes = "用于测试自定义的业务异常")
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public Result test2(){
        throw  new BusinessException(ResultCode.COMMEN_BUSINESS_EXCEPTION);
    }

    @ApiOperation(value = "其他异常测试",notes = "用于测试未捕捉到的业务异常")
    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public Result test3(){
        int a  =1/0;
        return new Result(ResultCode.SUCCESS);
    }


    @ApiOperation(value = "有@ResponseBody 返回测试",notes = "有@ResponseBody 返回测试")
    @ResponseBody
    @RequestMapping(value = "/test4",method = RequestMethod.GET)
    public Result test4(){
        return new Result(ResultCode.SUCCESS);
    }
}
