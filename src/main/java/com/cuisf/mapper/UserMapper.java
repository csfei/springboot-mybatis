package com.cuisf.mapper;

import com.cuisf.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user")
    List<User> queryUserList();

    @Select("select * from user where id = #{id}")
    User queryUserById(Integer id);

    @Insert("insert into user (id,name,pwd) value(10,'huawei','123456789')")
    int addUser(User user);

    @Update("update user set name = #{name} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);


}
