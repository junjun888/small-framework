package framework.orm.executor;

import framework.orm.executor.resultset.ResultSetHandler;
import framework.orm.executor.statement.StatementHandler;
import framework.orm.mapping.MappedStatement;
import framework.orm.session.Configuration;
import framework.orm.statement.SimpleStatementHandler;

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
    public <E> List<E> query(MappedStatement mappedStatement, Object parameter, ResultSetHandler resultSetHandler) throws SQLException {
        Statement stmt = null;
        Configuration configuration = mappedStatement.getConfiguration();
        StatementHandler handler = new SimpleStatementHandler(mappedStatement, parameter, resultSetHandler);
        return handler.query(stmt, resultSetHandler);
    }
}
