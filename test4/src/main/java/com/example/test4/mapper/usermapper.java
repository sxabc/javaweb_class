package com.example.test4.mapper;



import com.example.test4.entity.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface usermapper {

    @Select("SELECT * FROM tb_user WHERE username = #{username} AND password = #{password}")
    user findUser(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM tb_user WHERE username = #{username} ")
    user selectByUsername(String username);


    @Insert("INSERT INTO tb_user VALUES (null,#{username},#{password}) ")
    void add(user user);



}
