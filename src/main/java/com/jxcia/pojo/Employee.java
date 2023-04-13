package com.jxcia.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
/**
 * Mybatis Plus会默认使用实体类的类名到数据中找对应的表
 * @TableName如果省略，表示实体类的名字和数据库表的名字一样
 */
//MybatisPlus会默认使用实体类的类名到数据中找对应的表.
@TableName(value = "employee")
public class Employee {
    //在数据库表中是主键，且自动增长
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    //和数据库中标的字段有关系，last_name--->lastName
    @TableField(value = "last_name")
    private String lastName;//别名问题
    @TableField(value = "email")
    private String email;
    @TableField(value = "gender")
    private Integer gender;
    @TableField(value = "age")
    private Integer age;
    //这个字段表示在数据库中没有，要告诉Mybatis Plus数据库表没有
    @TableField(exist = false)
    private boolean flag;

    public Employee(String lastName, String email, Integer gender, Integer age) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }
}
