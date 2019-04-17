package examle.orm.test;

import examle.orm.mapper.UserMapper;
import examle.orm.po.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-17 16:26
 **/
public class TestProxy implements InvocationHandler {


    public <T> T getProxy(Class<T> clazz) {
        try {
            Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new TestProxy());
            T proxyObj = (T) o;

            return proxyObj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

    public static void main(String[] args) {
        TestProxy testProxy = new TestProxy();
        UserMapper proxy = testProxy.getProxy(UserMapper.class);

        List<User> userList = proxy.getUserList();
        System.out.println(proxy == null);
    }
}
