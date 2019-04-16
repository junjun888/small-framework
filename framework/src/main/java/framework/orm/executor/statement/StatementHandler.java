package framework.orm.executor.statement;

import sun.plugin2.main.server.ResultHandler;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 20:32
 **/
public interface StatementHandler {

    <E> List<E> query(Statement statement, ResultHandler resultHandler)
            throws SQLException;
}
