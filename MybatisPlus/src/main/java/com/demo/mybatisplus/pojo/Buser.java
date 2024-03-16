package com.demo.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lemon
 * @create 2022-12-14-11:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buser {
    private Integer id;
    private String name;
    private String password;
    private String email;
}
