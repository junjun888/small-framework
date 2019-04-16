package framework.orm.executor.resultset;

import java.sql.SQLException;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-12 20:19
 **/
public interface ResultSetHandler {

    <E> List<E> handleResultSets() throws SQLException;

}
