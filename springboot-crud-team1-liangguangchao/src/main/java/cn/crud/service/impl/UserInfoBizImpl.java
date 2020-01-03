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
public class UserInfoBizImpl implements UserInfoService {

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


    /**
     * 添加
     * @param userinfo
     */
    @Override
    public void save(UserInfo userinfo) {
            dao.save(userinfo);
    }

    /**
     * 更新
     * @param userinfo
     */
    @Override
    public void update(UserInfo userinfo) {
        dao.save(userinfo);
    }
    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

}
