package framework.orm.plugin;

import java.util.Properties;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 19:25
 **/
public interface Interceptor {

    Object intercept(Invocation invocation) throws Throwable;

    Object plugin(Object target);

    void setProperties(Properties properties);
}
