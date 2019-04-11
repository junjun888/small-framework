package framework.orm.session;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 11:48
 **/
public interface SqlSessionFactory {

    SqlSession openSession();
}
