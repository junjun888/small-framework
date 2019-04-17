package examle.orm.test;

import examle.orm.mapper.UserMapper;
import framework.orm.mapper.MapperProxy;

import java.lang.reflect.Proxy;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-17 16:08
 **/
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        UserMapper mapper = test.getMapper(UserMapper.class);

        System.out.println(mapper == null);
    }

    public <T> T getMapper(Class<T> clazz){
        try {
            T proxyObj = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperProxy(null, null));

            return proxyObj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
