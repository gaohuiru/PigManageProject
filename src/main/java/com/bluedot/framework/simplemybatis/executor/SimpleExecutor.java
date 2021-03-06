package com.bluedot.framework.simplemybatis.executor;



import com.bluedot.framework.simplemybatis.callback.MyCallback;
import com.bluedot.framework.simplemybatis.executor.parameter.DefaultParameterHandler;
import com.bluedot.framework.simplemybatis.executor.parameter.ParameterHandler;
import com.bluedot.framework.simplemybatis.executor.resultset.DefaultResultSetHandler;
import com.bluedot.framework.simplemybatis.executor.resultset.ResultSetHandler;
import com.bluedot.framework.simplemybatis.executor.statement.SimpleStatementHandler;
import com.bluedot.framework.simplemybatis.executor.statement.StatementHandler;
import com.bluedot.framework.simplemybatis.mapping.MappedStatement;
import com.bluedot.framework.simplemybatis.pool.MyDataSource;
import com.bluedot.framework.simplemybatis.session.Configuration;
import com.bluedot.framework.simplemybatis.utils.LogUtils;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * mysql的执行器，操作数据库
 *
 * @author xxbb
 */
public class SimpleExecutor implements Executor {

    /**
     * 连接池对象
     */
    private final MyDataSource dataSource;

    private static final Logger LOGGER = LogUtils.getLogger();
    public SimpleExecutor(Configuration configuration) {
        dataSource = configuration.getDataSource();
    }

    /**
     * 抽取出执行sql操作前的获取连接，预处理语句，赋值参数的操作成一个模板
     *
     * @param mappedStatement  封装sql信息的对象
     * @param parameter        参数
     * @param executorCallback 会调接口
     * @return List结果集或受影响的行数
     */
    private Object executeTemplate(MappedStatement mappedStatement, Object parameter, MyCallback executorCallback) {
        Connection connection = null;
        try {
            //获取连接
            connection = dataSource.getConnection();
            //实例化StatementHandler对象
            StatementHandler statementHandler = new SimpleStatementHandler(mappedStatement);
            //对mapperStatement中的sql语句进行处理，去除头尾空格，将#{}替换成?,封装成preparedStatement对象
            PreparedStatement preparedStatement = statementHandler.prepared(connection);
            //给占位符?的参数赋值
            ParameterHandler parameterHandler = new DefaultParameterHandler(parameter);
            parameterHandler.setParameters(preparedStatement);
            LOGGER.debug("preparedStatement:" + preparedStatement);
            //为了能够在sql语句中设置查询的条件，去除查询条件上的''进行的特殊处理，如将where 'pigNo'=5 变成where pigNo=5
            //这里作为查询条件的字段会用{}进行标记即where 'q(pigNo)p'=5 变成where pigNo=5
            String pre=preparedStatement.toString();
            String prefix="q(";
            String suffix=")p";
            if(pre.contains(prefix)&&pre.contains(suffix)){
                //分割出sql语句
                pre=pre.substring(pre.indexOf("select"));
                pre = pre.replace("'q(", "");
                pre=pre.replace(")p'","");
                preparedStatement=connection.prepareStatement(pre);
                LOGGER.debug("对preparedStatement进行特殊处理后："+preparedStatement);
            }

            return executorCallback.doExecutor(statementHandler, preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dataSource.returnConnection(connection);
        }
    }

    /**
     * 执行查询方法，使用了模板方法设计模式
     *
     * @param mappedStatement sql信息对象
     * @param parameter       参数
     * @param <E>             泛型
     * @return 结果集
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> List<E> doQuery(MappedStatement mappedStatement, Object parameter) {
        return (List<E>) executeTemplate(mappedStatement, parameter, new MyCallback() {
            /**
             * 编写具体的数据库操作，区分查询和更新操作
             *
             * @param statementHandler  执行sql操作的对象
             * @param preparedStatement 完全处理好的sql语句对象
             * @return List集合或者受影响的行数
             */
            @Override
            public Object doExecutor(StatementHandler statementHandler, PreparedStatement preparedStatement) {
                //执行sql语句
                try {
                    //获取结果集
                    ResultSet resultSet = statementHandler.query(preparedStatement);
                    //处理结果集，封装成泛型List对象返回
                    //这里可以获取mappedStatement对象是因为他是效果上的final，
                    //验证，将mappedStatement赋一个新的值：mappedStatement=new MappedStatement(); 会报错——>lambda 表达式中使用的变量应为 final 或 effectively final
                    ResultSetHandler resultSetHandler = new DefaultResultSetHandler(mappedStatement);
                    //封装到目标resultType的List集合中
                    return resultSetHandler.handlerResultSet(resultSet);

                } catch (SQLException throwable) {
                    LOGGER.error(throwable.getMessage());
                    throw new RuntimeException(throwable);
                }
            }
        });
    }

    /**
     * 执行增删改方法，使用了模板方法设计模式
     *
     * @param mappedStatement sql信息对象
     * @param parameter       参数
     * @return 受影响的行数
     */
    @Override
    public int doUpdate(MappedStatement mappedStatement, Object parameter) {
        Integer res = (Integer) executeTemplate(mappedStatement, parameter, new MyCallback() {
            /**
             * 编写具体的数据库操作，区分查询和更新操作
             *
             * @param statementHandler  执行sql操作的对象
             * @param preparedStatement 完全处理好的sql语句对象
             * @return List集合或者受影响的行数
             */
            @Override
            public Object doExecutor(StatementHandler statementHandler, PreparedStatement preparedStatement) {
                try {
                    return statementHandler.update(preparedStatement);
                } catch (SQLException throwable) {
                    LOGGER.error(throwable.getMessage());
                    throw new RuntimeException(throwable);
                }
            }
        });
        if (null != res) {
            return res;
        } else {
            LOGGER.error("更新数据出现错误，受影响的行数返回空值");
            throw new RuntimeException("更新数据出现错误，受影响的行数返回空值");
        }
    }


}
