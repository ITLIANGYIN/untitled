package com.jxcia.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxcia.pojo.People;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PeopleMapper extends BaseMapper<People> {
    @Select("select * from people where id=#{id}")
    @Results(@Result(
            column = "id",
            property = "idcard",
            one = @One(select = "com.jxcia.dao.IdCardMapper.selectIdCardById")
    ))
    public People selectPeopleById(int id);

}
