package com.kfk.crud.dao;

import com.kfk.crud.pojo.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserinfoDao extends JpaRepository<Userinfo,String>, JpaSpecificationExecutor<Userinfo> {
}
