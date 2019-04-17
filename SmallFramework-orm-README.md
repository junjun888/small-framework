# small-framework orm 设计

[TOC]

## 0 缘起

> 最近在研究mybatis， 所以顺手就照着mybatis写了一遍 orm. 本框架精简了大量mybatis琐碎代码,保留了最核心的结构和接口，让你轻松了解mybatis

## 1 核心结构
```
 1 配置解析
     1.1 核心配置文件解析, mapper 文件解析 XMLConfigBuilder

 2 参数处理
     2.1 ParameterHandler

 3 sql 执行
    3.1 SimpleExecutor
    3.2 MapperProxy

 4 结果集处理
    ResultSetHandler
   
```

![image](https://i.loli.net/2019/04/09/5cacaa9e969d9.png)

## 2 包结构示意图

![temp.png](https://i.loli.net/2019/04/17/5cb7116336c5c.png)

----

> 使用示例图

![example.png](https://i.loli.net/2019/04/17/5cb711af7c72f.png)


## 3 框架使用


```
 简单代码 
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
```

## 4 源码地址

> https://github.com/junjun888/small-framework



- ref 参考


```
https://www.cnblogs.com/fangjian0423/p/mybaits-dynamic-sql-analysis.html
https://www.cnblogs.com/mengheng/p/3739610.html
https://blog.csdn.net/deng8623048/article/details/82423348
```
 
