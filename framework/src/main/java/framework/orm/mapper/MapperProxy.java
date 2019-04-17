package framework.orm.mapper;

import framework.orm.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;
    private Class mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //如果返回值是一个List集合才执行如下代码
        Class<?> returnType = method.getReturnType();
        if (returnType == List.class) {
            //代理对象调用任何方法，都会在这执行
            //真正执行Sql语句
            //执行Sql语句的工作:sqlSession对象的selectList(),也就是说咱在这要调用那个方法
            //key是"Mapper接口的全限定名"+"."+方法名
            String methodName = method.getName();//方法名
            Class<?> clazz = method.getDeclaringClass();
            String clazzName = clazz.getName();//获取接口的全限定名
            String key = clazzName + "." + methodName;
            List<Object> list = sqlSession.selectList(key, args);
            return list;
        }else {
            return null;
        }
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Class getMapperInterface() {
        return mapperInterface;
    }

    public void setMapperInterface(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }
}
