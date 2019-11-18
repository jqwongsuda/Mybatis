package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user查询的条件：有可能是用户名，有可能是性别，有可能是地址，还有可能都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryVo中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
