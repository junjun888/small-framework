package framework;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-02 20:46
 **/
public class SmallApplication {

    public static ApplicationContext run(Class clazz) {
        HelperLoader.init();
        return new ApplicationContext();
    }
}
