package framework;

import framework.ioc.BeanHelper;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-02 20:48
 **/
public class ApplicationContext {

    /**
     * 获取 Bean 实例
     */
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> cls) {
        return BeanHelper.getBean(cls);
    }
}
