package com.tiger.utils;

import com.github.miemiedev.mybatis.paginator.OffsetLimitInterceptor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * Created with IntelliJ IDEA.
 * User: Foy Lian
 * Date: 2016-09-29
 * Time: 14:48
 */
@SuppressWarnings("rawtypes")
@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class Pagehelper extends com.github.pagehelper.PageHelper {
    //让OffsetLimitInterceptor,pagehelper能够同时工作。。
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        //获取原始的ms
        MappedStatement ms = (MappedStatement) args[0];
        SqlSource sqlSource = ms.getSqlSource();
        //如果发现是这个类型，不管了。
        if(sqlSource instanceof OffsetLimitInterceptor.BoundSqlSqlSource){
            return invocation.proceed();
        }else{
            return super.intercept(invocation);
        }
    }
}
