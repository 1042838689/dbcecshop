package com.example.dbcec.mapper;


import com.example.dbcec.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

//    @Select("SELECT * FROM users WHERE id = #{id}")
    User selectById(@Param("id") Long id);

//    @Insert("INSERT INTO users(name, age) VALUES (#{name}, #{age})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

//    @Update("UPDATE users SET name = #{name}, age = #{age} WHERE id = #{id}")
    int update(User user);

//    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteById(@Param("id") Long id);

//    @Select("SELECT * FROM users")
    List<User> selectAllUsers();

    List<User> selectUserByPage(@Param("offset") int offset, @Param("limit") int limit);

    int selecttotal();

//    @Select("SELECT * FROM users WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<User> findByName(@Param("name") String name);
}
