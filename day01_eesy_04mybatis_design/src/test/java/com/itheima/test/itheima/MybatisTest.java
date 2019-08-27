package com.itheima.test.itheima;
import com.itheima.dao.IUserDao;
import com.itheima.demain.User;
import com.itheima.mybatis.io.Resources;
import com.itheima.mybatis.sqlsession.SqlSession;
import com.itheima.mybatis.sqlsession.SqlSessionFactory;
import com.itheima.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.lang.String;
//import javax.annotation.Resources;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    @Test
    public static void main(String[] args) throws IOException {
//        1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");//此处报错，是idea自动导包导错了
//        2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
//        3.使用工厂生产SqlSession对象，有了这个对象，IUserDao我们不用去具体实现
        SqlSession session = factory.openSession();

//        4.使用SqlSession创建Dao接口的代理对象,此处给未实现的接口以增强功能
        IUserDao userDao = session.getMapper(IUserDao.class);//通过session生产的代理对象，根据我们的业务字节码生产代理对象
//        5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user :users){
            System.out.println(user);
        }
//        6.释放资源
        session.close();
        in.close();
    }
}
