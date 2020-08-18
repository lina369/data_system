package com.example.data_system.mapper;

import com.example.data_system.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper {
    @Select("select * from login where username=#{username} and password=#{password}")
    User login(String username, String password);
    @Select("select * from login where username=#{username}")
    User getuser(String username);
    @Insert("insert into login (username,password) values (#{username},#{password})")
    void adduser(User user);
    @Update("update login set password=#{password} where username=#{username}")
    void updateuser(String username,String password);
    @Delete("delete from login where username=#{username}")
    void deleteuser(String username);

}
