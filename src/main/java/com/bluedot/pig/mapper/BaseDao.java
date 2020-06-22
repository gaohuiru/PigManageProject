package com.bluedot.pig.mapper;

import com.bluedot.framework.simplemybatis.session.SqlSession;
import com.bluedot.framework.simplemybatis.session.SqlSessionFactory;
import com.bluedot.framework.simplespring.core.annotation.Repository;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;


/**
 * 提供简单的增删改方法，根据传入的对象自动生成sql语句并执行
 * 注意数据库的设计，必须保证
 * @author AlwaysXu
 */
@Repository
public class BaseDao {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public <T>int insert(T type){
        return sqlSessionFactory.openSession().insert(type);
    }

    public <T>int update(T type){
        return sqlSessionFactory.openSession().update(type);
    }
    public <T>int delete(T type){
        return sqlSessionFactory.openSession().delete(type);
    }


}
