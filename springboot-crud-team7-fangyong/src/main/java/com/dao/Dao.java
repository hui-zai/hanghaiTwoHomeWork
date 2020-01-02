package com.dao;

import com.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Dao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
}
