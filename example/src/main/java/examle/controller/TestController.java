package examle.controller;

import examle.service.TestService;
import framework.ioc.annotation.Autowired;
import framework.ioc.annotation.Controller;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-02 20:59
 **/
@Controller
public class TestController {

    @Autowired
    TestService testService;

    public String hello() {
        return testService.hello();
    }
}
