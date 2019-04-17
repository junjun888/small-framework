package framework.orm.mapping;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-17 10:51
 **/
public class StaticSqlSource implements  SqlSource {

    private String sql;

    public StaticSqlSource(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }


    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(sql);
    }
}
