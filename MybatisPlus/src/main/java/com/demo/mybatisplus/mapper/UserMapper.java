package com.demo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.mybatisplus.pojo.Buser;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lemon
 * @create 2022-12-14-11:46
 */
public interface UserMapper extends BaseMapper<Buser> {
    Page<Buser> myPage(@Param("page") Page<Buser> page, @Param("password") String password);
}
