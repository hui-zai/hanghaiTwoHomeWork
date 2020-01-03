package com.huangxiaoyan.hdao;
import com.huangxiaoyan.hentity.User;
import java.util.List;

public interface IDao {
    User queryById(long id);
    List<User> queryAll();
    List<User> queryByUsername(String username);
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(long id);
}
