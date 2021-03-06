package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.mybatis.annotation.Select;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * <p>
 * 用户的持久层接口
 */
public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
