package framework.orm.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-12 20:13
 **/
public interface ParameterHandler {

    void setParameters(PreparedStatement ps)
            throws SQLException;
}
