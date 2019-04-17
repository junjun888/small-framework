package framework.orm.session.defaults;

import framework.orm.executor.Executor;
import framework.orm.mapper.MapperProxy;
import framework.orm.mapping.MappedStatement;
import framework.orm.session.Configuration;
import framework.orm.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 19:29
 **/
public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;
    private final Executor executor;


    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) throws RuntimeException {
        return this.<T>selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) throws RuntimeException {
        // Popular vote was to return null on 0 results and throw exception on too many.
        List<T> list = this.<T>selectList(statement, parameter);
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() > 1) {
            throw new RuntimeException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
        } else {
            return null;
        }
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) throws RuntimeException {
        try {
            MappedStatement ms = configuration.getMappedStatement(statement);
            return executor.query(ms, parameter, Executor.NO_RESULT_HANDLER);
        } catch (Exception e) {
            throw new RuntimeException("Error querying database.  Cause: " + e);
        }
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public <T> T getMapper(Class<T> clazz){
        try {
            T proxyObj = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperProxy(this, clazz));

            return proxyObj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
