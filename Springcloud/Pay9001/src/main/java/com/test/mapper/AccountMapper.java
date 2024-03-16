package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/24 21:21:58
 */
public interface AccountMapper extends BaseMapper<Account> {
    void updateAccount(@Param("userId") Long userId, @Param("money") Integer i);
}
