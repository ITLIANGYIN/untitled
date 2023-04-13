package com.jxcia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxcia.pojo.IdCard;
import org.apache.ibatis.annotations.Select;

public interface IdCardMapper extends BaseMapper<IdCard> {
    @Select("select * from idcard where id=#{id}")
    public IdCard selectIdCardById(int id);
}
