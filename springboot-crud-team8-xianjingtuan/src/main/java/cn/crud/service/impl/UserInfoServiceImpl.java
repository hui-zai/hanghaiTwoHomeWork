package cn.crud.service.impl;

import cn.crud.service.UserInfoService;
import cn.crud.dao.UserInfoRepository;
import cn.crud.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务实现类
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public void save(UserInfo userInfo) {
        dao.save(userInfo);
    }

    @Override
    public void updata(UserInfo userInfo) {
        dao.save(userInfo);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Autowired
    private UserInfoRepository dao;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }
}
