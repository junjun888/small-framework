package examle.service;

import examle.dao.TestDao;
import framework.ioc.annotation.Autowired;
import framework.ioc.annotation.Service;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-02 20:58
 **/
@Service
public class TestService {

    @Autowired
    TestDao testDao;

    public String hello() {
        return testDao.hello();
    }
}
