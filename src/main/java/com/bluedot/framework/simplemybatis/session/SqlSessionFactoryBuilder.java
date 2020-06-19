package com.bluedot.framework.simplemybatis.session;





import com.bluedot.framework.simplemybatis.session.defaults.DefaultSqlSessionFactory;
import com.bluedot.framework.simplespring.core.BeanContainer;
import com.bluedot.framework.simplespring.util.LogUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * 构建者模式创建sqlSession工厂对象
 *
 * @author xxbb
 */
public class SqlSessionFactoryBuilder {
    /**
     * 读取配置文件构建SqlSessionFactory工厂
     * 将配置文件的解析成输入流的工作也放到该方法中
     *
     * @param fileName 配置文件名
     * @return 工厂对象
     */
    public SqlSessionFactory build(String fileName) {
        InputStream is = SqlSessionFactoryBuilder.class.getClassLoader().getResourceAsStream(fileName);
        LogUtil.getLogger().debug("load smybatis properties："+fileName);
        return build(is);
    }

    public SqlSessionFactory build(InputStream inputStream) {
        try {
            Configuration.pros.load(inputStream);
        } catch (IOException e) {
            LogUtil.getLogger().error(e.getMessage());
        }
        SqlSessionFactory factory= DefaultSqlSessionFactory.getInstance(new Configuration());
        //将sqlFactory注入到IoC容器中
        LogUtil.getLogger().debug("load sqlSession Factory: "+factory.getClass().getName());
        BeanContainer.getInstance().addBean(factory.getClass(),factory);
        return factory;
    }


}
