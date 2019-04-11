package framework.orm.session;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 14:04
 **/
public interface SqlSession {

    <T> T selectOne(String statement);
}
