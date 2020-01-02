package comzxw.service.impl;

import comzxw.dao.UserInfoRepository;
import comzxw.pojo.UserInfo;
import comzxw.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    //注入dao
    @Autowired
    private UserInfoRepository dao;
    /*
    * 新增用户的信息*/
    @Override
    public void save(UserInfo userInfo){
        dao.save(userInfo);
    }

    /*
    * 查询所有的用户
    * */
    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }


    //修改用户信息
    public void update(UserInfo userInfo){
        dao.save(userInfo);
    };


    //删除用户信息
    public void deleteById(Integer id){
        dao.deleteById(id);
    };
}
