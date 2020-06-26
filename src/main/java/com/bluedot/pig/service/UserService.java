package com.bluedot.pig.service;

import com.bluedot.framework.simplespring.core.annotation.Service;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.pig.mapper.BaseDao;
import com.bluedot.pig.mapper.BaseMapper;
import com.bluedot.pig.factory.MapperFactory;
import com.bluedot.pig.pojo.domain.Employee;
import com.bluedot.pig.service.base.BaseService;
import com.bluedot.pig.service.callback.ServiceCallback;
import com.bluedot.pig.util.TimeUtil;

import java.sql.Date;
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
            public List<Employee> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getUsersByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getUsersCountByQueryCondition(queryCondition,queryValue);
            }

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

    /**
     * 删除用户信息
     * @param map 数据映射
     */
    private void removeUser(Map<String,Object> map){
        doSimpleModifyTemplate(map, new ServiceCallback<Employee>() {
            @Override
            public List<Employee> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getUsers(pageStart,pageSize);
            }

            @Override
            public List<Employee> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getUsersByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getUsersCount();
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getUsersCountByQueryCondition(queryCondition,queryValue);
            }

            @Override
            public int doDataModifyExecutor(BaseDao baseDao) {
                Integer id=Integer.valueOf((String)map.get("employeeId"));
                Employee employee=new Employee();
                employee.setEmployeeId(id);
                return baseDao.delete(employee);
            }
        });
    }

    /**
     * 修改用户信息
     * @param map 请求参数
     */
    private void modifyUser(Map<String,Object> map){
        doSimpleModifyTemplate(map, new ServiceCallback<Employee>() {
            @Override
            public List<Employee> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getUsers(pageStart,pageSize);
            }

            @Override
            public List<Employee> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getUsersByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getUsersCount();
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getUsersCountByQueryCondition(queryCondition,queryValue);
            }


            @Override
            public int doDataModifyExecutor(BaseDao baseDao) {
                return baseDao.update(packagingEmployee(map));
            }
        });
    }

    /**
     * 添加用户信息
     * @param map 请求参数
     */
    private void addUser(Map<String,Object> map){
        doSimpleModifyTemplate(map, new ServiceCallback<Employee>() {
            @Override
            public List<Employee> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getUsers(pageStart,pageSize);
            }

            @Override
            public List<Employee> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getUsersByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getUsersCount();
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getUsersCountByQueryCondition(queryCondition,queryValue);
            }


            @Override
            public int doDataModifyExecutor(BaseDao baseDao) {
                return baseDao.insert(packagingEmployee(map));
            }
        });
    }

    /**
     * 将请求数据中的信息封装造成员工对象
     * @param map 请求数据
     * @return 员工对象
     */
    private Employee packagingEmployee(Map<String,Object> map){
        Integer employeeId=Integer.valueOf((String)map.get("employeeId"));

        String password=(String) map.get("password");
        if("".equals(password)||password==null){
            password="123456";
        }
        //如果以下多个值为空说明现在发送的是重置密码请求
        if(map.get("sex")==null&&map.get("age")==null&&map.get("email")==null){
            return new Employee(employeeId,password);
        }
        String realName=(String) map.get("realName");
        Integer sex=Integer.valueOf((String)map.get("sex"));
        Integer age=Integer.valueOf((String)map.get("age"));
        String identityNumber=(String) map.get("identityNumber");
        String telephone=(String) map.get("telephone");
        String email=(String) map.get("email");
        String image=(String) map.get("image");
        Integer position=Integer.valueOf((String)map.get("position"));
        String address=(String) map.get("address");
        Date entryTime= TimeUtil.parseToSqlDate((String) map.get("entryTime"));
        Integer workingYears=Integer.valueOf((String)map.get("workingYears"));
        Integer status=Integer.valueOf((String)map.get("status"));

        return new Employee(employeeId,realName,sex,age,identityNumber,
                telephone,email,image,position,address,entryTime,workingYears,status,password);
    }
}
