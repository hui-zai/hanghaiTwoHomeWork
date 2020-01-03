package com.example.springbootcrudteam6luzhijian.dao;

import com.example.springbootcrudteam6luzhijian.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
}
