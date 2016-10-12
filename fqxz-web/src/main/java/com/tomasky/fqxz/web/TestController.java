package com.tomasky.fqxz.web;

import com.tomasky.fqxz.common.core.utils.web.Result;
import com.tomasky.fqxz.common.em.ResultCode;
import com.tomasky.fqxz.common.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by LZQ on 2016/10/12.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public Result test1(){
        Result result = new Result(ResultCode.SUCCESS);
        Map<String,Object> map = new HashMap<>();
        map.put("id",23);
        map.put("name","zhang三");
        result.setData(map);
        return result;
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public Result test2(){

        throw  new BusinessException(ResultCode.COMMEN_BUSINESS_EXCEPTION);
    }
    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public Result test3(){
        int a  =1/0;
        return new Result(ResultCode.SUCCESS);
    }
}
