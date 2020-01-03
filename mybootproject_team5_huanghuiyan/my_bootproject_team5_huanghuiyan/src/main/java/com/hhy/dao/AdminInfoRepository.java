package com.hhy.dao;

import com.hhy.pojo.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminInfoRepository extends JpaRepository<AdminInfo,Integer>, JpaSpecificationExecutor<AdminInfo> {
}