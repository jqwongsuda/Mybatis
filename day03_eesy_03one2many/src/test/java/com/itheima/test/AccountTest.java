package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试mybatis的crud操作
 */
public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.通过工厂factory生产SqlSession对象
        sqlSession = factory.openSession();
        //4.通过sqlSession获取dao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }
    @After
    public void destroy()throws IOException{
//        //6.提交事务
//        sqlSession.commit();
        //7.释放资源
        //sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {

        //5.执行查询所有方法
        List<Account> accounts = accountDao.findAll();
        for(Account account : accounts)
        {
            System.out.println(account);
        }
    }


    /**
     * 通过id查询用户信息
     */
    //@Test
//    public void findById(){
//
//        //5.执行保存方法
//        User user = accountDao.findById(9);
//        System.out.println(user.toString());
//        System.out.println(user);
//
//    }


}
