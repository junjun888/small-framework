package framework.orm.executor.statement;

import framework.orm.executor.resultset.ResultSetHandler;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 20:32
 **/
public interface StatementHandler {

    <E> List<E> query(Statement statement, ResultSetHandler resultSetHandler)
            throws SQLException;
}
