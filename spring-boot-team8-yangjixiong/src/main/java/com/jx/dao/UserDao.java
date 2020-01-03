package com.jx.dao;

import com.jx.model.User;

import java.util.List;

/**
 * Created by yjx on 2019/12/23.
 */
public interface UserDao {
    /**
     * 显示用户
     * @return
     */
    public List<User> showUser();

    /**
     * 删除用户
     * @param id
     * @return 影响行数
     */
    public int deleteUser(int id);

    /**
     * 更新用户
     * @param user
     * @return 影响行数
     */
    public int updateUser(User user);

    /**
     * 新增用户
     * @param user
     * @return 影响行数
     */
    public int insertUser(User user);

    /**
     * 查询某个用户
     * @param id
     * @return user
     */
    public User selectUser(int id);
}
