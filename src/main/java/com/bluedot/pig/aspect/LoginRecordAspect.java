package com.bluedot.pig.aspect;

import com.bluedot.framework.simplemybatis.utils.LogUtils;
import com.bluedot.framework.simplespring.aop.annotation.Aspect;
import com.bluedot.framework.simplespring.aop.annotation.Order;
import com.bluedot.framework.simplespring.aop.aspect.DefaultAspect;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.pig.mapper.BaseDao;
import com.bluedot.pig.pojo.domain.LoginLog;
import com.bluedot.pig.util.NetworkUtil;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * @author xxbb
 */
@Aspect(pointcut = "execution(* com.bluedot.pig.controller.LoginController.*(..))")
@Order(0)
public class LoginRecordAspect extends DefaultAspect {
    @Autowired
    BaseDao baseDao;

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable {
        insertLoginLog(args,null);
        return returnValue;
    }

    @Override
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args, Throwable throwable) throws Throwable {
        insertLoginLog(args,throwable);
    }

    /**
     * 插入登录日志的具体操作
     * @param throwable 异常
     */
    @SuppressWarnings("unchecked")
    private void insertLoginLog(Object[] args,Throwable throwable) throws IOException {
        Map<String,Object> map=null;
        HttpServletRequest request=null;
        //遍历元素，获取需要的map和request对象
        for(Object arg:args){
            if(arg instanceof Map){
                map= (Map<String, Object>) arg;
            }
            if(arg instanceof HttpServletRequest){
                request= (HttpServletRequest) arg;
            }
        }
        //目的是对 路径/ 进行处理
        if(map==null&&request==null){
            return;
        }
        assert map != null;
        assert request != null;
        Integer employeeId= Integer.valueOf((String) map.get("username"));
        String ip= NetworkUtil.getIpAddress(request);
        UserAgent userAgent1=UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        String userAgent=userAgent1.getBrowser().getName()+"/"
                +userAgent1.getBrowserVersion()+","+
                userAgent1.getOperatingSystem().getName();
        int ifSucceed;
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        String msg;
        String errorKey="error";
        if(throwable==null){
            if(map.containsKey(errorKey)){
                msg="账号或密码错误";
                ifSucceed=0;
            }else{
                msg="登录成功";
                ifSucceed=1;
            }

        }else{
            msg=throwable.getMessage();
            ifSucceed=-1;
        }
        LogUtils.getLogger().debug("插入登录数据");
        LoginLog loginLog=new LoginLog(employeeId,ip,userAgent,ifSucceed,timestamp,msg);
        baseDao.insert(loginLog);
    }
}
