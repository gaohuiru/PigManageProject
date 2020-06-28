package com.bluedot.pig.service;

import com.bluedot.framework.simplespring.core.annotation.Service;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.pig.mapper.BaseDao;
import com.bluedot.pig.mapper.BaseMapper;
import com.bluedot.pig.factory.MapperFactory;
import com.bluedot.pig.pojo.domain.Employee;
import com.bluedot.pig.pojo.domain.Purview;
import com.bluedot.pig.pojo.vo.PurviewVo;
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
     * 删除用户信息,同时删除一条用户权限
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
                Purview purview=new Purview(id);
                return baseDao.delete(employee)+baseDao.delete(purview);
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
     * 添加用户信息,同时添加一条默认权限信息
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
                Employee employee=packagingEmployee(map);
                int addPurview=baseDao.insert(new Purview(employee.getEmployeeId()));
                int addEmployee=baseDao.insert(employee);
                return addEmployee+addPurview;
            }
        });
    }

    /**
     * 查询用户权限信息
     * @param map 请求参数map
     */
    private void queryUserPurviews(Map<String, Object> map){
        doSimpleQueryListTemplate(map, new ServiceCallback<PurviewVo>(){
            @Override
            public List<PurviewVo> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                //由于权限页面的数据列表使用了联立查询，这里需要对查询条件参数进行预处理
                String[] preQueryCondition=new String[]{"q(employee_id)p","q(real_name)p"};
                if(preQueryCondition[0].equals(queryCondition)){
                    queryCondition="q(p.employee_id)p";
                }
                if(preQueryCondition[1].equals(queryCondition)){
                    queryCondition="q(e.real_name)p";
                }
                return baseMapper.getUserPurviewsByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getPurviewsCountByQueryCondition(queryCondition,queryValue);
            }

            @Override
            public List<PurviewVo> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getUserPurviews(pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getPurviewsCount();
            }
        });
    }

    /**
     * 删除用户权限信息,暂时不单独使用，在删除用户信息时同时删除权限信息
     * @param map 数据映射
     */
    private void removeUserPurview(Map<String,Object> map){
        doSimpleModifyTemplate(map, new ServiceCallback<PurviewVo>() {
            @Override
            public List<PurviewVo> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getUserPurviews(pageStart,pageSize);
            }

            @Override
            public List<PurviewVo> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getUserPurviewsByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getPurviewsCount();
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getPurviewsCountByQueryCondition(queryCondition,queryValue);
            }

            @Override
            public int doDataModifyExecutor(BaseDao baseDao) {
                Integer id=Integer.valueOf((String)map.get("employeeId"));
                Purview purview=new Purview();
                purview.setEmployeeId(id);
                return baseDao.delete(purview);
            }
        });
    }

    /**
     * 修改用户权限信息
     * @param map 请求参数
     */
    private void modifyUserPurview(Map<String,Object> map){
        doSimpleModifyTemplate(map, new ServiceCallback<PurviewVo>() {
            @Override
            public List<PurviewVo> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getUserPurviews(pageStart,pageSize);
            }

            @Override
            public List<PurviewVo> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getUserPurviewsByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getPurviewsCount();
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getPurviewsCountByQueryCondition(queryCondition,queryValue);
            }

            @Override
            public int doDataModifyExecutor(BaseDao baseDao) {
                return baseDao.update(packagingPurview(map));
            }
        });
    }

    /**
     * 添加用户权限信息，暂时不单独使用，添加用户信息时同时添加一条权限信息
     * @param map 请求参数
     */
    private void addUserPurview(Map<String,Object> map){
        doSimpleModifyTemplate(map, new ServiceCallback<PurviewVo>() {
            @Override
            public List<PurviewVo> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getUserPurviews(pageStart,pageSize);
            }

            @Override
            public List<PurviewVo> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getUserPurviewsByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getPurviewsCount();
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getPurviewsCountByQueryCondition(queryCondition,queryValue);
            }

            @Override
            public int doDataModifyExecutor(BaseDao baseDao) {
                return baseDao.insert(packagingPurview(map));
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

    /**
     * 封装权限信息
     * @param map 数据列表
     * @return 权限对象
     */
    private Purview packagingPurview(Map<String,Object> map){
        Integer employeeId=Integer.valueOf((String)map.get("employeeId"));
        Integer userRights=map.get("userRights")==null?0:Integer.parseInt((String)map.get("userRights"));
        Integer pigRights=map.get("pigRights")==null?0:Integer.parseInt((String)map.get("pigRights"));
        Integer storeRights=map.get("storeRights")==null?0:Integer.parseInt((String)map.get("storeRights"));
        Integer equipmentRights=map.get("equipmentRights")==null?0:Integer.parseInt((String)map.get("equipmentRights"));
        Integer systemRights=map.get("systemRights")==null?0:Integer.parseInt((String)map.get("systemRights"));
        return new Purview(employeeId,userRights,pigRights,storeRights,equipmentRights,systemRights);
    }
}
