package com.example.demo.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author jhlyh
 */

/**
 * 实体类
 */

@TableName("user")
@Data

public class User {
    @TableId(type = IdType.AUTO)

    private Integer id;
    private String username;
    private String nickName;


    private String password;
    private Integer age;
    private String sex;
    private String address;

}
