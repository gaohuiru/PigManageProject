package com.bluedot.pig.mapper;

import com.bluedot.pig.pojo.domain.*;
import com.bluedot.pig.pojo.vo.PurviewVo;

import java.util.List;

/**
 * 读取BaseMapper.xml文件执行sql操作，主要是用来执行select语句，
 * 一般的增删改语句直接由BaseDao进行生成
 *
 * @author xxbb
 */
public interface BaseMapper {
    /**
     * 通过员工账号密码查询
     *
     * @param username 账号 即员工id
     * @param password 密码
     * @return 员工类
     */
    Employee getEmployeeByAccount(String username, String password);

    /**
     * 通过id获取权限
     *
     * @param id 员工id
     * @return 权限类
     */
    Purview getPurviewById(Integer id);

    /**
     * 获取用户信息列表
     *
     * @param pageStart 页码
     * @param pageSize  每页数据
     * @return 用户列表
     */
    List<Employee> getUsers(int pageStart, int pageSize);

    /**
     * 获取用户数据总数
     *
     * @return 数据总数
     */
    Long getUsersCount();

    /**
     * 根据查询条件获取用户信息列表
     *
     * @param queryCondition 查询条件
     * @param queryValue     查询结果
     * @param pageStart      页码
     * @param pageSize       每页数据
     * @return 用户列表
     */
    List<Employee> getUsersByQueryCondition(String queryCondition, String queryValue, int pageStart, int pageSize);

    /**
     * 根据查询条件获取用户数据总数
     *
     * @param queryCondition 查询条件
     * @param queryValue     查询结果
     * @return 用户总数
     */
    Long getUsersCountByQueryCondition(String queryCondition, String queryValue);

    /**
     * 查询用户权限信息
     * @param pageStart 起始位置
     * @param pageSize 页面大小
     * @return 数据列表
     */
    List<PurviewVo> getUserPurviews(int pageStart, int pageSize);

    /**
     * 根据查询条件查询用户权限信息
     * @param queryCondition 查询条件
     * @param queryValue     查询结果
     * @param pageStart 起始位置
     * @param pageSize 页面大小
     * @return 数据列表
     */
    List<PurviewVo> getUserPurviewsByQueryCondition(String queryCondition, String queryValue, int pageStart, int pageSize);

    /**
     * 权限数据总数
     * @return 条数
     */
    Long getPurviewsCount();

    /**
     * 根据条件查询权限数据总数
     * @param queryCondition 查询条件
     * @param queryValue     查询结果
     * @return 条数
     */
    Long getPurviewsCountByQueryCondition(String queryCondition, String queryValue);



    /**
     * 获取猪只信息列表
     *
     * @param pageStart 页码
     * @param pageSize  每页数据
     * @return 猪只列表
     */
    List<PigInfo> getPigs(int pageStart, int pageSize);

    /**
     * 根据查询条件查询猪只信息
     *
     * @param queryCondition 查询条件
     * @param queryValue     查询结果
     * @param pageStart      页码
     * @param pageSize       每页数据
     * @return 猪只列表
     */
    List<PigInfo> getPigsByQueryCondition(String queryCondition, String queryValue, int pageStart, int pageSize);

    /**
     * 获取猪只数据总数
     *
     * @return 数据总数
     */
    Long getPigsCount();

    /**
     * 根据查询条件获取猪只数据总数
     *
     * @param queryCondition 查询条件
     * @param queryValue     查询结果
     * @return 数据总数
     */
    Long getPigsCountByQueryCondition(String queryCondition, String queryValue);

    /**
     * 获取猪猪只品种信息列表
     *
     * @param pageStart 页码
     * @param pageSize  每页数据
     * @return 猪只列表
     */
    List<PigVariety> getPigVarieties(int pageStart, int pageSize);

    /**
     * 根据查询条件查询猪只品种信息
     *
     * @param queryCondition 查询条件
     * @param queryValue     查询结果
     * @param pageStart      页码
     * @param pageSize       每页数据
     * @return 猪只列表
     */
    List<PigVariety> getPigVarietiesByQueryCondition(String queryCondition, String queryValue, int pageStart, int pageSize);

    /**
     * 获取猪只品种数据总数
     *
     * @return 数据总数
     */
    Long getPigVarietiesCount();

    /**
     * 根据查询条件获取猪只品种数据总数
     *
     * @param queryCondition 查询条件
     * @param queryValue     查询结果
     * @return 数据总数
     */
    Long getPigVarietiesCountByQueryCondition(String queryCondition, String queryValue);

    List<LoginLog> getLoginLogs(int pageStart, int pageSize);
    List<LoginLog> getLoginLogsByQueryCondition(String queryCondition, String queryValue, int pageStart, int pageSize);
    Long getLoginLogsCount();
    Long getLoginLogCountByQueryCondition(String queryCondition, String queryValue);

    List<OperationLog> getOperationLogs(int pageStart, int pageSize);
    List<OperationLog> getOperationLogsByQueryCondition(String queryCondition, String queryValue, int pageStart, int pageSize);
    Long getOperationLogsCount();
    Long getOperationLogCountByQueryCondition(String queryCondition, String queryValue);

    List<ErrorLog> getErrorLogs(int pageStart, int pageSize);
    List<ErrorLog> getErrorLogsByQueryCondition(String queryCondition, String queryValue, int pageStart, int pageSize);
    Long getErrorLogsCount();
    Long getErrorLogCountByQueryCondition(String queryCondition, String queryValue);
}
