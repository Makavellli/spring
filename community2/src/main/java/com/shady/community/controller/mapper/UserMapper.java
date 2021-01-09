package com.shady.community.controller.mapper;

import com.shady.community.controller.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id,name,token,created_time,modified_time) values (#{account_id},#{name},#{token},#{created_time},#{modified_time})")
    void insert(User user);
}
