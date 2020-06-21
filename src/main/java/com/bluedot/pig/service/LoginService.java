package com.bluedot.pig.service;


import com.bluedot.framework.simplespring.core.annotation.Service;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.pig.mapper.BaseMapper;
import com.bluedot.pig.factory.MapperFactory;
import com.bluedot.pig.pojo.domain.Employee;
import com.bluedot.pig.pojo.domain.Purview;
import com.bluedot.pig.service.base.BaseService;

import java.util.Map;

/**
 * 登录业务
 *
 * @author xxbb
 */
@Service
public class LoginService extends BaseService {
    @Autowired
    MapperFactory mapperFactory;

    /**
     * 登录
     *
     * @param map 包含登录的请求参数
     */
    private void login(Map<String, Object> map) {
        BaseMapper baseMapper = mapperFactory.createMapper();
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        Employee employeeByAccount = baseMapper.getEmployeeByAccount(username, password);
        if (employeeByAccount != null) {
            Purview purview = baseMapper.getPurviewById(Integer.valueOf(username));
            map.put("employee", employeeByAccount);
            map.put("purview", purview);
        } else {
            map.put("error", "账号或密码错误，请重试！！！");
        }

    }
}
