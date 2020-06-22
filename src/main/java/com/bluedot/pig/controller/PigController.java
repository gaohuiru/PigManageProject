package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.pig.controller.base.BaseController;
import com.bluedot.pig.controller.callback.ControllerCallback;
import com.bluedot.pig.service.PigService;

import javax.servlet.http.HttpServlet;
import java.util.Map;

/**
 * 猪只请求处理，页面的转发尽量避免转发到@RequestMapping的方法请求上，减少请求方法之间的耦合
 * @author xxbb
 */
@Controller
@RequestMapping("/pig")
public class PigController extends HttpServlet {
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

    /**
     * 基本的猪只数据列表查询
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return 视图
     */
    @RequestMapping("/queryPigs")
    public ModelAndView queryPigs(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return baseController.simpleRequestTemplate(pigService, pageNo, pageSize, dispatchPath, new ControllerCallback() {
            @Override
            public void doServiceForSimpleRequest(Map<String, Object> serviceMap,StringBuilder dispatchPath) {
                serviceMap.put("service","queryPigs");
                pigService.doService(serviceMap);
            }
        });
    }
    @RequestMapping("/removePig")
    public ModelAndView removePig(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize,@RequestParam("pigNo") String pigNo){

        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return baseController.simpleRequestTemplate(pigService, pageNo, pageSize, dispatchPath, new ControllerCallback() {
            @Override
            public void doServiceForSimpleRequest(Map<String, Object> serviceMap, StringBuilder dispatchPath) {
                serviceMap.put("service","removePig");
                serviceMap.put("pigNo",pigNo);
                pigService.doService(serviceMap);

            }
        });
    }

}
