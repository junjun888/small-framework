package framework.orm.mapping;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-17 10:49
 **/
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);
}
