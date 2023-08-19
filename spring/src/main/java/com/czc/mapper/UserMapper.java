package com.czc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czc.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
