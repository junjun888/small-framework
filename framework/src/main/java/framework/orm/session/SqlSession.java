package framework.orm.session;

import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 14:04
 **/
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <E> List<E> selectList(String statement, Object parameter);

    Configuration getConfiguration();

    <T> T getMapper(Class<T> clazz);

}
