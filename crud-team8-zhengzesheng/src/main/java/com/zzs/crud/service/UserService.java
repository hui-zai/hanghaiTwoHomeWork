package com.zzs.crud.service;

import com.zzs.crud.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void del(Integer id);

    void save(User user);

    void update(User user);
}
