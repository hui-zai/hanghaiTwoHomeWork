package com.cwz.serivce;

import com.cwz.pojo.UserInfo;
import java.util.List;

/**
 * @ProjectName: springboot-team7-chengweizhao
 * @Package: com.cwz.serivce
 * @ClassName: UserInfoService
 * @Author: 程伟钊
 * @Description: service层
 * @Date: 2020/1/1 22:32
 */

public interface UserInfoService {
    //查询所有用户信息
    public List<UserInfo> findAll();
    //新增用户信息
    public void save(UserInfo userInfo);
    //修改用户信息
    public void update(UserInfo userInfo);
    //删除用户信息
    public void deleteById(Integer id);
}
