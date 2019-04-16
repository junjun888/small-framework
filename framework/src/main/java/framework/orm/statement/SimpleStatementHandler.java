package framework.orm.statement;

import framework.orm.executor.parameter.ParameterHandler;
import framework.orm.executor.parameter.defaults.DefaultParameterHandler;
import framework.orm.executor.resultset.DefaultResultSetHandler;
import framework.orm.executor.resultset.ResultSetHandler;
import framework.orm.executor.statement.StatementHandler;
import framework.orm.mapping.MappedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
               ResultSetHandler resultHandler = new DefaultResultSetHandler(mapperData.getType(),preparedStatement.getResultSet());
               return (E) resultHandler.handle();
          } catch (SQLException e) {
               e.printStackTrace();
          } catch (ClassNotFoundException e) {
               e.printStackTrace();
          }finally {
               try {
                    if(preparedStatement!=null){
                         preparedStatement.close();
                    }
                    if(conn!=null){
                         conn.close();
                    }
               } catch (SQLException e) {
                    e.printStackTrace();
               }
          }
          return null;
     }

     private Connection getConnection() throws SQLException, ClassNotFoundException {
//          MtDataSource dataSource = configuation.getDataSource();
//          Class.forName(dataSource.getDriver());
//          return DriverManager.getConnection(dataSource.getUrl(),dataSource.getUserName(),dataSource.getPassWord());
          // TODO
          return null;
     }
}
