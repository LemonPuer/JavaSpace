package com.mapper;

import com.pojo.Dept;
import com.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-21-11:16
 */
public interface DeptMapper {
    //分步查询emp第二步
    Dept stepTwo(@Param("deptId")int deptId);
    //查询dept的员工
    Dept selectOne(@Param("deptId")int deptId);
    //分步查询dept第一步
    Dept stepOne(@Param("deptId")int deptId);
}
