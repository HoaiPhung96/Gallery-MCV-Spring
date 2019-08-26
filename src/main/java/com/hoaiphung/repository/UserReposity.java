package com.hoaiphung.repository;

import com.hoaiphung.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserReposity extends PagingAndSortingRepository<User, Long> {
    public User findAllByName(String name);
}
