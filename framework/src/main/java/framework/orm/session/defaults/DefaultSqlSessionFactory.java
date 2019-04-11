package framework.orm.session.defaults;

import framework.orm.executor.Executor;
import framework.orm.session.Configuration;
import framework.orm.session.ExecutorType;
import framework.orm.session.SqlSession;
import framework.orm.session.SqlSessionFactory;


/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 13:58
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return openSessionFromDataSource(configuration.getDefaultExecutorType());
    }

    private SqlSession openSessionFromDataSource(ExecutorType execType) {
        try {
            final Executor executor = configuration.newExecutor(execType);
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
