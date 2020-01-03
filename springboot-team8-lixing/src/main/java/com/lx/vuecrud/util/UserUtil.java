package com.lx.vuecrud.util;

import com.lx.vuecrud.model.User;
import com.lx.vuecrud.model.UserJson;
import org.springframework.beans.BeanUtils;

/**
 * create by @author lixing on 2019/12/26 8:28
 * 工具类
 */
public class UserUtil {
    public static User change(UserJson user) {
        String[] hobby = user.getHobby();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < hobby.length ; i++) {
            builder.append(hobby[i]);
            if (i != hobby.length-1) {
                builder.append("|");
            }
        }
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        user1.setHobby(builder.toString());
        return user1;
    }
}
