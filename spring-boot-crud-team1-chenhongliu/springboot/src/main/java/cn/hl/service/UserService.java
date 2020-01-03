package cn.hl.service;

import cn.hl.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //查询所有用户
    public List<User> findAll();
    //新增用户
    public void save(User User);
    //修改用户
    public void update(User User);
    //删除用户
    public void deleteById(Integer id);

}
