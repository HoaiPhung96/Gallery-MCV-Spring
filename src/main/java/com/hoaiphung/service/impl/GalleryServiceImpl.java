package com.hoaiphung.service.impl;

import com.hoaiphung.model.Category;
import com.hoaiphung.model.Gallery;
import com.hoaiphung.repository.GalleryRepository;
import com.hoaiphung.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;


public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public Iterable<Gallery> findAll() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery findById(Long id) {
        return galleryRepository.findOne(id);
    }

    @Override
    public void save(Gallery gallery) {
        galleryRepository.save(gallery);
    }

    @Override
    public void remove(Long id) {
        galleryRepository.delete(id);
    }

    @Override
    public Iterable<Gallery> findAllByCategory(Category category) {
        return galleryRepository.findAllByCategory(category);
    }
}
