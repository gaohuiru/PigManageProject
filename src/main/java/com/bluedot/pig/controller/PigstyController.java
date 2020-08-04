package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.pig.controller.base.BaseController;

/**
 * @author xxbb
 */
@Controller
@RequestMapping("/pigsty")
public class PigstyController extends BaseController {
    @RequestMapping("/echarts")
    public String queryPigstyEcharts(){
        return "WEB-INF/pigsty/pigsty-echarts.jsp";
    }

}
