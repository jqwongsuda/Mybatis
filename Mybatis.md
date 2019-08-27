# 第一天
## 什么是框架？
    它是我们软件开发中的一套解决方案，不同的框架解决的是不同的问题。
    使用框架的好处：
                框架封装了很多细节，使开发者能够以极简的方式来实现功能。大大提高开发效率。


 ## 三层架构       
    表现层：是用于展示数据的，spring MVC
    业务层: 是用于处理业务需求的。
    持久层：是和数据库进行交互的。    
![](./三层架构.png '三层架构')   

## 持久层技术解决方案
###      JDBC技术
                Connection
                PreparedStatemente
                ResultSet
###      Spring对JdbcTemplate:
                Spring中对jdbc的简单封装
###      Apache 的DBUtils
                它和Spring的JdbcTemplate很像， 也是对Jdbc的简单封装
###      以上这些都不是框架
                JDBC是规范
                Spring的JdbcTemplate和Apache的DBUtils都只是工具类
## mybatis的概述
        mybatis是一个持久层框架，用Java编写。
        它封装了jdbc操作的很多细节，使开发者只需要关注sql语句本身，而无需关注注册驱动，创建连接等繁杂过程，它使用了ORM思想实现了结果集的封装。
***ORM:***
        Object Relational Mapping 对象关系映射
        简单来说：
                就是把数据库表和实体类及实体类的属性对应起来
                让我们可以操作实体类就实现操作数据库表。
                这样需要做到：实体类中的属性和数据库表的字段名称保持一致

## mybatis的入门
        mybatis的环境搭建：
                第一步：创建maven工程并导入坐标
                第二部：创建实体类和dao的接口
                第三步：创建Mybatis的主配置文件
                        SqlMapConfig.xml
                第四步：创建映射配置文件
                        IUserDao.xml
        环境搭建的注意事项：
                第一个：床架IUserDao.xml 和 IUserDao.java时
                        名称时为了和我们之前的知识保持一致。
                        在Mybatis中它把持久层的操作接口名称和映射文件也叫做Mapper
                        所以： IUserDao 和 IUerMapper是一样的
                第二个：在idea中创建目录的时候，它和包是不一样的
                        包在创建时： com.itheima.dao它是三级结构
                        目录在创建时：com.itheima.dao是一级目录
                第三个：mybatis的映射配置文件位置必须和dao接口的报结构相同
                第四个：映射配置文件的mapper标签namespace属性的取值必须是dao接口的权限定类名
                第五个：映射配置文件的操作配置（select），id属性的取值必须是dao接口的方法名

                当我们遵从了第三四五点之后，我们在开发中就无需在写dao的实现类
        mybatis的入门案例
                第一步：读取配置文件
                第二步：创建SqlSessionFactory工厂
                第三部：创建SqlSession
                第四步：创建Dao接口的代理对象
                第五步：执行dao中的方法
                第六步：释放资源
                注意事项：
                        不要忘记在映射配置中告知mybatis要封装到哪个实体类中
                        配置的方式：指定实体类的全限定类名
                        
                mybatis基于注解的入门案例：
                        把IUserDao.xml移除，，在dao接口的方法上使用@Select注解，并且指定SQL语句
                        同时需要在SqlMapConfig.xml中的mappeer配置时，使用class属性指定dao接口的全限定类名。
        明确：
                我们在实际开发中，都是越简便越好，所以都是采用不写dao实现类的方式。
                不管时使用XML还是注解配置。
                但是mybatis它是支持写dao实现类的。
## 自定义Mybatis的分析：
        mybatis在使用代理dao的方式实现增删改查时做什么事呢？
                只有两件事：
                        第一：创建代理对象
                        第二：在代理对象中调用selectList
        自定义mybatis能通过入门案例看到类
                class Resource
                class SqlSessionFactoryBuilder
                interface SqlSessionFactory
                interface SqlSession
