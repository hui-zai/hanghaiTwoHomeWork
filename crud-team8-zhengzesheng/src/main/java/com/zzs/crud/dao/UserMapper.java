package com.zzs.crud.dao;

import com.zzs.crud.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZS
 */
@Repository
public interface UserMapper {

    List<User> getAll();

    void del(Integer id);

    void save(User user);

    void update(User user);
}
