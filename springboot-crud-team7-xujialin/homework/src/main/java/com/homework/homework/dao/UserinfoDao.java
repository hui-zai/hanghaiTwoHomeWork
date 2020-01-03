package com.homework.homework.dao;
import com.homework.homework.pojo.Userinfo;
import com.homework.homework.pojo.UserinfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserinfoDao {
    long countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    List<Userinfo> selectByExample(UserinfoExample example);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}