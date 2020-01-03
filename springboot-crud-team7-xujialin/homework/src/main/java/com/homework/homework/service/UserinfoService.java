package com.homework.homework.service;

import com.homework.homework.pojo.Userinfo;

import java.util.List;

public interface UserinfoService {
    List<Userinfo> searchall();

    void save(Userinfo info);

    void delete(String index);
}
