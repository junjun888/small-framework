package framework.orm.statement;

import framework.orm.executor.parameter.ParameterHandler;
import framework.orm.executor.parameter.defaults.DefaultParameterHandler;
import framework.orm.executor.resultset.DefaultResultSetHandler;
import framework.orm.executor.resultset.ResultSetHandler;
import framework.orm.executor.statement.StatementHandler;
import framework.orm.mapping.MappedStatement;
import framework.orm.session.Configuration;

import java.sql.*;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-12 09:49
 **/
public class SimpleStatementHandler implements StatementHandler {

    private MappedStatement mappedStatement;

    private ResultSetHandler resultHandler;

    private Object parameter;

    public SimpleStatementHandler(MappedStatement mappedStatement, Object parameter, ResultSetHandler resultHandler) {
        this.mappedStatement = mappedStatement;
        this.resultHandler = resultHandler;
        this.parameter = parameter;
    }

    @Override
    public <E> List<E> query(Statement statement, ResultSetHandler resultHandler) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(mappedStatement.getBoundSql(parameter).getSql());
            ParameterHandler parameterHandler = new DefaultParameterHandler(preparedStatement);
            parameterHandler.setParameters(preparedStatement);
            preparedStatement.execute();
            resultHandler = new DefaultResultSetHandler(mappedStatement.getResultType(), preparedStatement.getResultSet());
            return resultHandler.handleResultSets();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Configuration configuration = mappedStatement.getConfiguration();
        Class.forName(configuration.getDriver());
        return DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
    }
}
