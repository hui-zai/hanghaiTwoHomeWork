package demo.service;

import demo.pojo.UserInfo;

import java.util.List;

public interface  UserInfoService {

    public List<UserInfo> findAll();

    public void save(UserInfo userInfo);

    public void update(UserInfo userInfo);

    public void deleteById(Integer id);
}
