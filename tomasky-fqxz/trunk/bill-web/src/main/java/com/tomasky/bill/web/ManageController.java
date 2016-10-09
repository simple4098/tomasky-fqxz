package com.tomasky.bill.web;

import com.tomasky.bill.bo.param.manage.InnBo;
import com.tomasky.bill.common.cons.Constants;
import com.tomasky.bill.common.core.orm.Page;
import com.tomasky.bill.service.ManageService;
import com.tomasky.bill.vo.manage.InnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by X on 2016/9/14.
 */
@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    protected ManageService manageService;

    @RequestMapping("/getInnInfos")
    @ResponseBody
    public Map<String, Object> getInnInfos(InnBo param) {
        Map<String, Object> result = BaseController.new200Map();
        Page<InnVo> page = manageService.getInnInfos(param);
        result.put(Constants.PAGE, page);
        return result;
    }

    @RequestMapping("/setPoundage")
    @ResponseBody
    public Map<String, Object> setPoundage(Long innId, BigDecimal poundageRatio) {
        Map<String, Object> result = BaseController.new200Map();
        manageService.setPoundage(innId, poundageRatio);
        return result;
    }

}
