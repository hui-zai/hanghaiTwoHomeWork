package demo.service.impl;

import demo.dao.UserInfoRepository;
import demo.pojo.UserInfo;
import demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository dao;

    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        dao.save(userInfo);
    }


    @Override
    public void update(UserInfo userInfo){
        dao.save(userInfo);
    }

    @Override
    public void deleteById(Integer id){
        dao.deleteById(id);
    }

}
