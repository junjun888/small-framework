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

    protected ExecutorType defaultExecutorType = ExecutorType.SIMPLE;

    protected final InterceptorChain interceptorChain = new InterceptorChain();

    protected final Map<String, MappedStatement> mappedStatements = new HashMap();

    public Executor newExecutor(ExecutorType executorType) {
        executorType = executorType == null ? defaultExecutorType : executorType;

        Executor executor = null;
        if (ExecutorType.BATCH == executorType) {
            // TODO
        } else if (ExecutorType.REUSE == executorType) {
            // TODO
        } else {
            executor = new SimpleExecutor(this);
        }
        executor = (Executor) interceptorChain.pluginAll(executor);
        return executor;
    }

    public ExecutorType getDefaultExecutorType() {
        return defaultExecutorType;
    }


    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }
}
