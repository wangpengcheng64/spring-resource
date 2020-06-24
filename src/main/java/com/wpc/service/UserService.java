package com.wpc.service;

import com.wpc.bean.User;

public interface UserService {

    User getUserById(Long id);

    void insertUser(User user);
}
