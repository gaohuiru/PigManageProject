package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.pig.controller.base.BaseController;
import com.bluedot.pig.controller.callback.ControllerCallback;
import com.bluedot.pig.factory.MapInitFactory;
import com.bluedot.pig.service.PigService;

import java.util.Map;

/**
 * @author xxbb
 */
@Controller
@RequestMapping("/pig")
public class PigController {
    /**
     * 处理猪只业务的service
     */
    @Autowired
    PigService pigService;
    /**
     * 提供处理请求的通用方法
     */
    @Autowired
    BaseController baseController;
    @RequestMapping("/queryPigs")
    public ModelAndView queryPigs(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        String dispatchPath="/pig/pig-info-list.jsp";
        return baseController.simpleQueryRequestTemplate(pigService, pageNo, pageSize, dispatchPath, new ControllerCallback() {
            @Override
            public void doServiceForSimpleQueryRequestExecutor(Map<String, Object> serviceMap) {
                serviceMap.put("service","queryPigs");
                pigService.doService(serviceMap);
            }
        });
    }
}
