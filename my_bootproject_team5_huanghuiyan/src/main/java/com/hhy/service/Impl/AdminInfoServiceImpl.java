package com.hhy.service.Impl;

import com.hhy.dao.AdminInfoRepository;
import com.hhy.pojo.AdminInfo;
import com.hhy.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Autowired
    private AdminInfoRepository dao;

    //查询所有用户
    @Autowired
    public List<AdminInfo> findAll() {
        return dao.findAll();
    }

    //新增数据
    @Override
    public void save(AdminInfo adminInfo) {
        dao.save(adminInfo);
    }
}
