package com.jxcia.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;
    private String name;
    private String[] strs;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties props;
    private List<Book> books;
    private Map<String,Book> maps;
}
