package com.mapper;


import com.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-21-11:16
 */
public interface EmpMapper {
    //查询员工
    Emp selectOne(@Param("id")int id);
    //分步查询emp第一步
    Emp stepOne(@Param("id")int id);
    //分步查询dept第二步
    List<Emp> stepTwo(@Param("deptId")int deptId);
    //动态条件筛选员工
    List<Emp> selectMore(Emp emp);
    //批量添加
    int insertMore(@Param("emps")List<Emp> emps);
}
