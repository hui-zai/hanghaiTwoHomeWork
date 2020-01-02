package com.zzs.crud.entity;

public class User {

    private Integer id;
    private String username;
    private String email;
    private String sex;
    private String province;
    private String hobby;

    public User() {
    }

    public User(Integer id, String username, String email, String sex, String province, String hobby) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.sex = sex;
        this.province = province;
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
