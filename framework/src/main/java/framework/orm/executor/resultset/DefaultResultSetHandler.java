package framework.orm.executor.resultset;

import framework.orm.reflaction.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-12 20:21
 **/
public class DefaultResultSetHandler<E> implements ResultSetHandler {

    private Class type;
    private ResultSet resultSet;

    public DefaultResultSetHandler(Class type, ResultSet resultSet) {
        this.type = type;
        this.resultSet = resultSet;
    }

    @Override
    public <E> List<E> handleResultSets() {
        try {
            ArrayList<E> resultList = new ArrayList<>();
            Object resultObject = null;
            while (resultSet.next()) {
                resultObject = new DefaultObjectFactory().create(type);
                for (Field field : resultObject.getClass().getDeclaredFields()) {
                    setValue(resultObject, field, resultSet);
                }

                resultList.add( (E) resultObject);
            }

            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setValue(Object resultObject, Field field, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
        Method method = type.getMethod("set" + upperCapital(field.getName()), field.getType());
        method.invoke(resultObject, getResult(field, resultSet));
    }

    public Object getResult(Field field, ResultSet rs) throws SQLException {
        Class<?> type = field.getType();
        if (Integer.class == type) {
            return rs.getInt(field.getName());
        } else if (String.class == type) {
            return rs.getString(field.getName());
        } else if (Long.class == type) {
            return rs.getLong(field.getName());
        } else {
            return rs.getString(field.getName());
        }
    }

    private String upperCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }
}
