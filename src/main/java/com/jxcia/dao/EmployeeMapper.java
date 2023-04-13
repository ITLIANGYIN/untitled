package com.jxcia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxcia.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper extends BaseMapper<Employee> {
@Select("select * from employee where id=#{param01} and last_name=#{param02}")
    public  Employee selectByIdAndName(@Param("param01") int id,
                                       @Param("param02") String lastName);

    @Select({"SELECT COUNT(*) FROM employee"})
    Integer countAll();

}
