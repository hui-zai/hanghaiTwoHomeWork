package com.cwz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ProjectName: springboot-team7-chengweizhao
 * @Package: com.cwz.pojo
 * @ClassName: ResponseObject
 * @Author: 程伟钊
 * @Description: 实体类
 * @Date: 2020/1/1 22:32
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tbl_userinfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String sex;
    private String province;
    private String hobby;
}
