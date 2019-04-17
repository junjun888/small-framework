package examle.orm;

import examle.orm.mapper.UserMapper;
import examle.orm.po.User;
import framework.orm.builder.Resources;
import framework.orm.session.SqlSession;
import framework.orm.session.SqlSessionFactory;
import framework.orm.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-17 14:07
 **/
public class TestMybatis {

    public static void main(String[] args) {
        //读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("MybatisConfig.xml");
        //创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //通过构建者设计模式创建工厂
        SqlSessionFactory factory = builder.build(is);
        //通过工厂模式创建sqlSession
        SqlSession sqlSession = factory.openSession();
        //通过动态代理获取对应mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        List<User> userList = mapper.getUserList();
        //遍历打印结果集
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
