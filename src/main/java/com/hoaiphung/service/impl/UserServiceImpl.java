package com.hoaiphung.service.impl;

import com.hoaiphung.model.User;
import com.hoaiphung.repository.UserReposity;
import com.hoaiphung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    public UserReposity userReposity;

    @Override
    public Iterable<User> findAll() {
        return userReposity.findAll();
    }

    @Override
    public User findById(Long id) {
        return userReposity.findOne(id);
    }

    @Override
    public void save(User user) {
        userReposity.save(user);
    }

    @Override
    public void remove(Long id) {
        userReposity.delete(id);
    }

    @Override
    public User findAllByName(String name) {
        return userReposity.findAllByName(name);
    }
}
