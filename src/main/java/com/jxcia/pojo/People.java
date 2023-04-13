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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "people")
public class People {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    @TableField(value = "name")
    private  String name;
    @TableField(value = "job")
    private  String job;
    @TableField(value = "cardid")
    private Integer cardid;
    private IdCard idcard;
}
