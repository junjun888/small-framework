package framework.orm.mapping;

import framework.orm.session.Configuration;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 19:56
 **/
public class MappedStatement {

    private String id;

    private Configuration configuration;

    private Class resultType;

    private SqlSource sqlSource;

    public Configuration getConfiguration() {
        return configuration;
    }

    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    public Class getResultType() {
        return resultType;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public void setResultType(Class resultType) {
        this.resultType = resultType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SqlSource getSqlSource() {
        return sqlSource;
    }

    public void setSqlSource(SqlSource sqlSource) {
        this.sqlSource = sqlSource;
    }
}
