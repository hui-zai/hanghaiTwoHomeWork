package com.it.dao;

import com.it.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User>{
}
