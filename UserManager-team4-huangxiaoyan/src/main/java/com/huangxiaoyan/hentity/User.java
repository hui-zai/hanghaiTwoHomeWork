package com.huangxiaoyan.hentity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String username;
    private String mail;
    private String province;
    private String hobby;
    private Integer sex;
    private String  sexStr;
}
