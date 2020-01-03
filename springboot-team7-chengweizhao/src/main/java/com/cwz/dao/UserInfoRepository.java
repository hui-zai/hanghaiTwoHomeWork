package com.cwz.dao;

import com.cwz.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ProjectName: springboot-team7-chengweizhao
 * @Package: com.cwz.dao
 * @ClassName: UserInfoRepository
 * @Author: 程伟钊
 * @Description: dao层
 * @Date: 2020/1/1 22:32
 */

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>, JpaSpecificationExecutor<UserInfo> {
}
