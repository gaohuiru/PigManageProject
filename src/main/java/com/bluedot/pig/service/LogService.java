package com.bluedot.pig.service;

import com.bluedot.framework.simplespring.core.annotation.Service;
import com.bluedot.pig.mapper.BaseMapper;
import com.bluedot.pig.pojo.domain.ErrorLog;
import com.bluedot.pig.pojo.domain.LoginLog;
import com.bluedot.pig.pojo.domain.OperationLog;
import com.bluedot.pig.service.base.BaseService;
import com.bluedot.pig.service.callback.ServiceCallback;

import java.util.List;
import java.util.Map;

/**
 * 日志业务
 * @author xxbb
 */
@Service
public class LogService extends BaseService {
    /**
     * 登录日志查询
     * @param map 请求参数
     */
    public void queryLoginLogs(Map<String, Object> map){
        doSimpleQueryListTemplate(map, new ServiceCallback<LoginLog>() {
            @Override
            public List<LoginLog> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getLoginLogs(pageStart,pageSize);
            }

            @Override
            public List<LoginLog> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getLoginLogsByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getLoginLogsCount();
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getLoginLogCountByQueryCondition(queryCondition,queryValue);
            }
        });
    }

    /**
     * 操作日志查询
     * @param map 请求参数
     */
    public void queryOperationLogs(Map<String,Object> map){
        doSimpleQueryListTemplate(map, new ServiceCallback<OperationLog>() {
            @Override
            public List<OperationLog> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getOperationLogs(pageStart,pageSize);
            }

            @Override
            public List<OperationLog> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getOperationLogsByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getOperationLogsCount();
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getOperationLogCountByQueryCondition(queryCondition,queryValue);
            }
        });
    }

    /**
     * 异常日志查询
     * @param map 请求参数
     */
    public void queryErrorLogs(Map<String,Object> map){
        doSimpleQueryListTemplate(map, new ServiceCallback<ErrorLog>() {
            @Override
            public List<ErrorLog> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getErrorLogs(pageStart,pageSize);
            }

            @Override
            public List<ErrorLog> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getErrorLogsByQueryCondition(queryCondition,queryValue,pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getErrorLogsCount();
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getErrorLogCountByQueryCondition(queryCondition,queryValue);
            }
        });
    }
}
