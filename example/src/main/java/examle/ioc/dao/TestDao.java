package examle.ioc.dao;

import framework.ioc.annotation.Dao;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-02 20:58
 **/
@Dao
public class TestDao {

    public String hello() {
        return "hello";
    }
}
