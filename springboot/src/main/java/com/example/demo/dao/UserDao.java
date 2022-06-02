package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jhlyh
 */

/**
 * 数据层接口
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
