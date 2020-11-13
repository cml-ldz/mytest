package com.yaorange.mapper;

import com.yaorange.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> findALl();

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

}
