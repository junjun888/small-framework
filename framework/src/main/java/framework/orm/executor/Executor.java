package framework.orm.executor;

import framework.orm.executor.resultset.ResultSetHandler;
import framework.orm.mapping.MappedStatement;

import java.sql.SQLException;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 14:10
 **/
public interface Executor {

    ResultSetHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultSetHandler resultSetHandler) throws SQLException;

}
