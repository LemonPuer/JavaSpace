package com.atguigu.crowd.mapper;

import com.atguigu.crowd.entity.AdminExample;
import com.atguigu.crowd.entity.Admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectAdminPage(String keyWord);

    void deleteRelationship(Integer adminId);

    void saveRelationship(@Param("adminId") Integer adminId, @Param("list") List<Integer> list);

    int bachInsert(List<Admin> list);
}