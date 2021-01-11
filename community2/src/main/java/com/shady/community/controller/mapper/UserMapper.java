package com.shady.community.controller.mapper;

import com.shady.community.controller.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id,name,token,created_time,modified_time) values (#{account_id},#{name},#{token},#{created_time},#{modified_time})")
    void insert(User user);
    @Select("select * from user where account_id = #{token}")
    User findByToken(@Param("token") String token);
}
