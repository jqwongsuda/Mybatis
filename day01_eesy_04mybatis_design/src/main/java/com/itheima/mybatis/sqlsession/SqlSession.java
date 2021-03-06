package com.itheima.mybatis.sqlsession;

import com.itheima.dao.IUserDao;

/**
 * 自定义mybatis中的和数据库交互的核心类，它里面可以创建dao接口的代理对象
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao 的接口字节码，而不是dao 的实现类
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
