package framework.orm.session;

import framework.orm.builder.XMLConfigBuilder;
import framework.orm.session.defaults.DefaultSqlSessionFactory;

import java.io.InputStream;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 11:47
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream) {
        try {
            XMLConfigBuilder parser = new XMLConfigBuilder(inputStream);
            return build(parser.parse());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
