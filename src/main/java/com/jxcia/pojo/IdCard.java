package com.jxcia.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IdCard {
    private Integer id;
    private String cardno;
    private String sex;
    private String address;
    private Date endtime;
}
