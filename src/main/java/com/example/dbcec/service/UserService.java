package com.example.dbcec.service;


import com.example.dbcec.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    int createUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);

    List<User> getAllUsers();


    List<User> findByName(String name);


    List<User> selectUserByPage(int pageNum, int pageSize);

    int selecttotal();
}