package com.bluedot.pig.mapper;

import com.bluedot.pig.pojo.domain.Employee;
import com.bluedot.pig.pojo.domain.PigInfo;
import com.bluedot.pig.pojo.domain.Purview;

import java.util.List;

/**
 * @author xxbb
 */
public interface BaseMapper {
    /**
     * 通过员工账号密码查询
     * @param username 账号 即员工id
     * @param password 密码
     * @return 员工类
     */
    Employee getEmployeeByAccount(String username,String password);

    /**
     * 通过id获取权限
     * @param id 员工id
     * @return 权限类
     */
    Purview getPurviewById(Integer id);

    /**
     * 获取用户信息列表
     * @param pageStart 页码
     * @param pageSize 每页数据
     * @return 用户列表
     */
    List<Employee> getUsers(int pageStart,int pageSize);

    /**
     * 获取用户数据总数
     * @return 数据总数
     */
    Long getUsersCount();

    /**
     * 获取猪只信息列表
     * @param pageStart 页码
     * @param pageSize 每页数据
     * @return 猪只列表
     */
    List<PigInfo> getPigs(int pageStart,int pageSize);

    /**
     * 获取猪只数据总数
     * @return 数据总数
     */
    Long getPigsCount();
}
