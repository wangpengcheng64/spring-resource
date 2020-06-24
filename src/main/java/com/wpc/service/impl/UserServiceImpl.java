package com.wpc.service.impl;

import com.wpc.bean.User;
import com.wpc.mapper.UserMapper;
import com.wpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Long id) {
        return userMapper.query(id);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

}
