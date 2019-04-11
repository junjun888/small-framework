package framework.orm.executor;

import framework.orm.mapping.MappedStatement;
import sun.plugin2.main.server.ResultHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 14:10
 **/
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler) throws SQLException;

}
