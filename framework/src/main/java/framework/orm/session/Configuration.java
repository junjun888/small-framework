package framework.orm.session;

import framework.orm.executor.Executor;
import framework.orm.executor.SimpleExecutor;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 13:54
 **/
public class Configuration {

    protected ExecutorType defaultExecutorType = ExecutorType.SIMPLE;

    public Executor newExecutor(ExecutorType executorType) {
        executorType = executorType == null ? defaultExecutorType : executorType;

        Executor executor;
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
}
