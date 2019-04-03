package examle;

import examle.controller.TestController;
import framework.ApplicationContext;
import framework.SmallApplication;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-02 20:55
 **/
public class ExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SmallApplication.run(ExampleApplication.class);
        TestController bean = context.getBean(TestController.class);

        System.out.printf(bean.hello());
    }

}
