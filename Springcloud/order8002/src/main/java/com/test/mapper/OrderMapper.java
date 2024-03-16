package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/24 21:42:57
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
