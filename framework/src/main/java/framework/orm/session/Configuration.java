package framework.orm.session;

import framework.orm.executor.Executor;
import framework.orm.executor.SimpleExecutor;
import framework.orm.mapping.MappedStatement;
import framework.orm.plugin.InterceptorChain;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 13:54
 **/
public class Configuration {

    private String username;

    private String password;

    private String url;

    private String driver;

    protected ExecutorType defaultExecutorType = ExecutorType.SIMPLE;

    protected final InterceptorChain interceptorChain = new InterceptorChain();

    protected Map<String, MappedStatement> mappedStatements = new HashMap();

    public Executor newExecutor(ExecutorType executorType) {
        executorType = executorType == null ? defaultExecutorType : executorType;

        Executor executor = null;
        if (ExecutorType.BATCH == executorType) {
        } else if (ExecutorType.REUSE == executorType) {
        } else {
            executor = new SimpleExecutor(this);
        }
        executor = (Executor) interceptorChain.pluginAll(executor);
        return executor;
    }

    public ExecutorType getDefaultExecutorType() {
        return defaultExecutorType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public void setMappedStatements(Map<String, MappedStatement> mappedStatements) {
        this.mappedStatements = mappedStatements;
    }
}
