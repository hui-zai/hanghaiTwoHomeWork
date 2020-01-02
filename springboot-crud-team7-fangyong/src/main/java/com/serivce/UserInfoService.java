package com.serivce;

import com.domain.User;

import java.util.List;

public interface UserInfoService {

    public List<User> findAll();

    public void save(User user);

    public void update(User user);

    public void deleteById(Integer id);
}
