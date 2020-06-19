package com.bluedot.pig.service;


import com.bluedot.framework.simplemybatis.session.SqlSessionFactory;
import com.bluedot.framework.simplespring.core.annotation.Service;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;

/**
 * @author xxbb
 */
@Service
public class LoginService {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
}
