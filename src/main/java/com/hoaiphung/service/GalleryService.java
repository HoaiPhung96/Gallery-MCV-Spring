package com.hoaiphung.service;

import com.hoaiphung.model.Category;
import com.hoaiphung.model.Gallery;

import java.util.List;

public interface GalleryService {
    Iterable<Gallery> findAll();

    Gallery findById(Long id);

    void save(Gallery gallery);

    void remove(Long id);

    Iterable<Gallery> findAllByCategory(Category category);
}