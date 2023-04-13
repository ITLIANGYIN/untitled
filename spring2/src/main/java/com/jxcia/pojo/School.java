package com.jxcia.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Data
@AllArgsConstructor
public class School {
    private Integer id;
    private String name;
    private String address;
}
