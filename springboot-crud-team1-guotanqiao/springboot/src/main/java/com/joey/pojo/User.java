package com.joey.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "t_user")
public class User {


    @Id
    private ObjectId id;




    private String username;


    private String password;

    private String email;
    private  String sex;
    private String province;
    private List<String> hobby;


}
