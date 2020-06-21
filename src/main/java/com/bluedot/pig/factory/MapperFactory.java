package com.bluedot.pig.factory;

import com.bluedot.framework.simplemybatis.session.SqlSessionFactory;
import com.bluedot.framework.simplespring.core.annotation.Repository;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.pig.mapper.BaseMapper;

/**
 * 由于所有的查询都使用同一个的查询接口，所以这里创建创建查询代理对象的工厂
 * @author xxbb
 */
@Repository
public class MapperFactory {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    public BaseMapper createMapper(){
        return sqlSessionFactory.openSession().getMapper(BaseMapper.class);
    }
}
