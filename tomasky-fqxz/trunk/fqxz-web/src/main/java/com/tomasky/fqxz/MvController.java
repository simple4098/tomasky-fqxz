package com.tomasky.fqxz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mo
 */
@Controller
public class MvController {

    private final Logger LOGGER = LoggerFactory.getLogger(MvController.class);

    @RequestMapping("/hello")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("show");
        mv.addObject("message", "show it!");
        mv.addObject("account", "test");
        return mv;
    }


}