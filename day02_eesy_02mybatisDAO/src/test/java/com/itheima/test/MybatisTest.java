package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
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
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的crud操作
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂factory，创建dao对象
        userDao = new UserDaoImpl(factory);
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
        List<User> users = userDao.findAll();
        for(User user : users)
        {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("脚踏实地，学号Java，python啥的是以后的事");
        user.setAddress("苏州市姑苏区");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("保存操作前：" + user);

        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存之后：" + user);
    }
    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(8);
        user.setUsername("hello world");
        user.setAddress("Suchow University");
        user.setSex("男");
        user.setBirthday(new Date());

        //5.执行保存方法
        userDao.updateUser(user);
    }
    /**
     * 删除操作
     */
    @Test
    public void testDelete(){

        //5.执行保存方法
        userDao.deleteUser(10);
    }
    /**
     * 通过id查询用户信息
     */
    @Test
    public void findById(){

        //5.执行保存方法
        User user = userDao.findById(9);
        System.out.println(user.toString());
        System.out.println(user);

    }
    /**
     * 测试模糊查询操作
     */
    @Test
    public void findByName(){

        //5.执行保存方法
        List<User> users = userDao.findByName("%王%");
        for(User user : users)
        {
            System.out.println(user);
        }
    }
    @Test
    public void testFindTotal()
    {
        int count = userDao.findTotal();
        System.out.println(count);
    }
    /**
     * 测试使用QueryVo作为查询条件
     */
   // @Test
//    public void testFindByVo(){
//        QueryVo vo = new QueryVo();
//        User user = new User();
//        user.setUserName("%王%");
//        vo.setUser(user);
//        //5.执行保存方法
//        List<User> users = userDao.findUserByVo(vo);
//        for(User u : users)
//        {
//            System.out.println(u);
//        }
//    }
}
