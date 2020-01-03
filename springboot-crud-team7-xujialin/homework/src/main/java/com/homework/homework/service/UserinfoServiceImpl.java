package com.homework.homework.service;

import com.homework.homework.dao.UserinfoDao;
import com.homework.homework.pojo.Userinfo;
import com.homework.homework.pojo.UserinfoExample;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userinfoServiceImpl")
@Transactional
public class UserinfoServiceImpl implements  UserinfoService {

    @Autowired
    public UserinfoDao userinfoDao;


    @Override
    public List<Userinfo> searchall() {
        UserinfoExample example=new UserinfoExample();
        example.createCriteria();
        System.out.println(userinfoDao.toString());
        List<Userinfo> list=userinfoDao.selectByExample(example);
        return list;
    }

    @Override
    public void save(Userinfo info) {
        if(info.getId()!= null){
            //UserinfoExample example=new UserinfoExample();
            //example.createCriteria().andIdEqualTo(info.getId());
            userinfoDao.updateByPrimaryKeySelective(info);
        }else{
            userinfoDao.insert(info);
        }
    }

    @Override
    public void delete(String index) {
        userinfoDao.deleteByPrimaryKey(Integer.parseInt(index));
    }
}
