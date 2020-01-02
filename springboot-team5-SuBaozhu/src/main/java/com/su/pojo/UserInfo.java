package com.su.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tb_userinfo")

public class UserInfo {
    @Id
    @GeneratedValue

    private  Integer id;
    private String username;
    private String email;
    private String sex;
    private String province;
    private String hobby;

}
