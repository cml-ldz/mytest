package com.yaorange.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaorange.entity.User;
import com.yaorange.mapper.UserMapper;
import com.yaorange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findALl();
    }

    @Override
    public PageInfo<User> findByPage(Integer pageNum, Integer pageSize) {
//        1.设置分页条件
        PageHelper.startPage(pageNum,pageSize);
//        2.调用mapper的查询方法
        List<User> users = userMapper.findALl();
//        3.以数据集合参数，创建PegeInfo对象返回
        return new PageInfo<User>(users);
    }

    @Override
    public Integer save(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer update(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Integer deleteById(Integer id) {
        return userMapper.deleteUser(id);
    }
}
