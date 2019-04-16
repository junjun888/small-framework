package framework.orm.mapping;

import framework.orm.session.Configuration;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 19:56
 **/
public class MappedStatement {

    private Configuration configuration;

    private Class resultType;

    public Configuration getConfiguration() {
        return configuration;
    }

    public BoundSql getBoundSql(Object parameterObject) {
//        BoundSql boundSql = sqlSource.getBoundSql(parameterObject);
//        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
//        if (parameterMappings == null || parameterMappings.isEmpty()) {
//            boundSql = new BoundSql(configuration, boundSql.getSql(), parameterMap.getParameterMappings(), parameterObject);
//        }
//
//        // check for nested result maps in parameter mappings (issue #30)
//        for (ParameterMapping pm : boundSql.getParameterMappings()) {
//            String rmId = pm.getResultMapId();
//            if (rmId != null) {
//                ResultMap rm = configuration.getResultMap(rmId);
//                if (rm != null) {
//                    hasNestedResultMaps |= rm.hasNestedResultMaps();
//                }
//            }
//        }
        // TODO
        return null;
    }

    public Class getResultType() {
        return resultType;
    }
}
