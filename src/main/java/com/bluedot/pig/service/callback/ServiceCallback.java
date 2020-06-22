package com.bluedot.pig.service.callback;

import com.bluedot.pig.mapper.BaseMapper;

import javax.security.auth.callback.Callback;
import java.util.List;

/**
 * 回调方法，模板方法模式
 * 由于Service的很多的查询的业务逻辑都有相似之处
 * 这里提供一个回调接口来编写查询中非共性的地方
 * 采用默认方法可以避免每次使用都要把方法全部实现
 * @author xxbb
 */
public interface ServiceCallback<T> extends Callback {
    /**
     * 查询数据列表的方法
     * @param baseMapper 查询代理类
     * @param pageStart 数据列表的起点
     * @param pageSize 数据长度
     * @return 数据列表
     */
    default List<T> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize){
         return null;
     }

    /**
     *  查询数据条数的方法
     * @param baseMapper 查询代理类
     * @return 数据条数
     */
     default Long doCountExecutor(BaseMapper baseMapper){
         return null;
     }

    /**
     * 调用增删改方法的模板方法
     * @param baseMapper 查询代理类
     * @return 影响的行数
     */
     default int doDataModifyExecutor(BaseMapper baseMapper){ return -1;}
}
