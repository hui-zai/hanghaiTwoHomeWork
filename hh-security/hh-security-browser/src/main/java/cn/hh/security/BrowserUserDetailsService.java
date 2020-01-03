package cn.hh.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BrowserUserDetailsService implements UserDetailsService {
    //private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
    该方法实现根据用户名查询用户
    返回值：null，表示用户不存在
    返回值：UserDetails类型，表示用户存在
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //logger.info("登录名："+username);
        String pwd = bCryptPasswordEncoder.encode("123456");
        //logger.info("123456密码加密："+pwd);
        System.out.println("123456加密："+pwd);
        //根据传来的登录名查询数据库
        //创建一个用户对象，用于返回
        User user = new User(username,pwd, true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}
