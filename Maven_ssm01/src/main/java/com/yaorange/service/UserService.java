package com.yaorange.service;

import com.github.pagehelper.PageInfo;
import com.yaorange.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    PageInfo<User> findByPage(Integer pageNum, Integer pageSize);

    Integer save(User user);

    Integer update(User user);

    Integer deleteById(Integer id);

}
