package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;

/**
 * @author xxbb
 */
@RequestMapping("/pig")
public class PigController {
    public ModelAndView queryPigs(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        return null;
    }
}
