package com.hhy.service;

import com.hhy.pojo.AdminInfo;

import java.util.List;

public interface AdminInfoService {
    public List<AdminInfo> findAll();
    public void save(AdminInfo adminInfo);
}
