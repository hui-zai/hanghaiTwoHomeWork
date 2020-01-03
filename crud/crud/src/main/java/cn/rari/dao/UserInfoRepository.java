package cn.rari.dao;

import cn.rari.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>, JpaSpecificationExecutor<UserInfo> {
}
