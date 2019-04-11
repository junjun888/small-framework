package framework.orm.executor;

import framework.orm.session.Configuration;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 14:16
 **/
public class SimpleExecutor implements Executor {

    protected Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }
}
