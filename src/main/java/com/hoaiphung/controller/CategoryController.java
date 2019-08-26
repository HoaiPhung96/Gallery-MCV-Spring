package com.hoaiphung.controller;

import com.hoaiphung.model.Category;
import com.hoaiphung.model.Gallery;
import com.hoaiphung.service.CategoryService;
import com.hoaiphung.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GalleryService galleryService;

    @GetMapping("/index")
    public ModelAndView listCategoryHp() {
        Iterable<Category> category = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index/index");
        modelAndView.addObject("categoryList", category);
        return modelAndView;
    }

    @GetMapping("/album/{id}")
    public ModelAndView viewCategoryHp(@PathVariable("id") Long id) {
        Category categoryHp = categoryService.findById(id);
        if (categoryHp == null) {
            return new ModelAndView("/error.404");
        }
        Iterable<Category> category = categoryService.findAll();    //index category
        Iterable<Gallery> galleriesHp = galleryService.findAllByCategory(categoryHp);
        ModelAndView modelAndView = new ModelAndView("/index/album");
        modelAndView.addObject("categoryHp", categoryHp);
        modelAndView.addObject("galleriesHp", galleriesHp);
        modelAndView.addObject("categoryList", category);   //index category
        return modelAndView;
    }

}
