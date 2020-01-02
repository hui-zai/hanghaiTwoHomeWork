package com.yostar.curd.provider;

import com.yostar.curd.pojo.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class SQLProvider extends SQL {

    private static final String TABLE_NAME = "user";

    public String updateUser(User user) {
        return new SQL() {{
            UPDATE(TABLE_NAME);
            if (!StringUtils.isEmpty(user.getUsername())) {
                SET("username = #{username}");
            }
            if (!StringUtils.isEmpty(user.getEmail())) {
                SET("email = #{email}");
            }
            if (!StringUtils.isEmpty(user.getSex())) {
                SET("sex = #{sex}");
            }
            if (!StringUtils.isEmpty(user.getProvince())) {
                SET("province=#{province}");
            }
            if (!StringUtils.isEmpty(user.getHobby())) {
                SET("hobby = #{hobby}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }
}
