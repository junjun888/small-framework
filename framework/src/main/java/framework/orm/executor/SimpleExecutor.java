package framework.orm.executor;

import framework.orm.executor.statement.StatementHandler;
import framework.orm.mapping.MappedStatement;
import framework.orm.session.Configuration;
import framework.orm.statement.SimpleStatementHandler;
import sun.plugin2.main.server.ResultHandler;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler) throws SQLException {
        Statement stmt = null;
        Configuration configuration = ms.getConfiguration();
        StatementHandler handler = new SimpleStatementHandler(ms, parameter, resultHandler);
        return handler.<E>query(stmt, resultHandler);
    }
}
