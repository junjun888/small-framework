package framework.orm.executor.parameter.defaults;

import framework.orm.executor.parameter.ParameterHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-12 20:14
 **/
public class DefaultParameterHandler implements ParameterHandler {

    private Object parameter;

    public DefaultParameterHandler(Object parameter) {
        this.parameter = parameter;
    }

    @Override
    public void setParameters(PreparedStatement psmt) throws SQLException {
        try {
            Object[] parameters = (Object[]) parameter;

            if (parameters != null && parameters.length > 0) {
                for (int i = 0; i < parameters.length; i++) {
                    if (parameters[i] instanceof Integer) {
                        psmt.setInt(i + 1, (Integer) parameters[i]);
                    } else if (parameters[i] instanceof Long) {
                        psmt.setLong(i + 1, (Long) parameters[i]);
                    } else if (parameters[i] instanceof String) {
                        psmt.setString(i + 1, String.valueOf(parameters[i]));
                    } else if (parameters[i] instanceof Boolean) {
                        psmt.setBoolean(i + 1, (Boolean) parameters[i]);
                    } else {
                        psmt.setString(i + 1, String.valueOf(parameters[i]));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
