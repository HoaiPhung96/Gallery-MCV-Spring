package com.hoaiphung.repository;

import com.hoaiphung.model.Category;
import com.hoaiphung.model.Gallery;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GalleryRepository extends PagingAndSortingRepository<Gallery, Long> {
    Iterable<Gallery> findAllByCategory(Category category);
}
