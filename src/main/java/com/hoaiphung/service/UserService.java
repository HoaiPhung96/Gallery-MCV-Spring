package com.hoaiphung.service;

import com.hoaiphung.model.User;

public interface UserService {
    Iterable<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);

    User findAllByName(String name);
}
