package com.bluedot.pig.service;

import com.bluedot.framework.simplespring.core.annotation.Service;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.pig.mapper.BaseMapper;
import com.bluedot.pig.factory.MapperFactory;
import com.bluedot.pig.pojo.domain.Employee;
import com.bluedot.pig.service.base.BaseService;
import com.bluedot.pig.service.callback.ServiceCallback;

import java.util.List;
import java.util.Map;

/**
 * 员工信息和权限的service
 * @author xxbb
 */
@Service
public class UserService extends BaseService {
    @Autowired
    MapperFactory mapperFactory;
    /**
     * 查询用户信息
     * @param map 请求参数map
     */
    private void queryUsers(Map<String, Object> map){
        doSimpleQueryListTemplate(map, new ServiceCallback<Employee>(){
            @Override
            public List<Employee> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getUsers(pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getUsersCount();
            }
        });
    }

}
