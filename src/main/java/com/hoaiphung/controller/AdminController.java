package com.hoaiphung.controller;

import com.hoaiphung.model.*;
import com.hoaiphung.service.CategoryService;
import com.hoaiphung.service.GalleryService;
import com.hoaiphung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
@SessionAttributes("myUser")
@Controller
public class AdminController {
    private static String UPLOAD_LOCATION = "/home/hp/IdeaProjects/Gallery-CaseStudy/src/main/webapp/image/";
    @Autowired
    private GalleryService galleryService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @ModelAttribute("categories")
    public Iterable<Category> category() {
        return categoryService.findAll();
    }

    //View list gallery
    @GetMapping("/admin/galleries")
    public ModelAndView listGallerys() {
        Iterable<Gallery> galleries = galleryService.findAll();
        Iterable<Category> category = categoryService.findAll();// View Category
        ModelAndView modelAndView = new ModelAndView("/manager/index");
        modelAndView.addObject("galleries", galleries);
        modelAndView.addObject("cateList", category);// View Category
        return modelAndView;
    }
    //View list gallery

    //Create gallery
    @GetMapping("/admin/create-gallery")
    public ModelAndView createGallery() {
        ModelAndView modelAndView = new ModelAndView("/manager/addGallery");
        modelAndView.addObject("gallery", new GalleryUpload());
        return modelAndView;
    }

    @PostMapping("/admin/create-gallery")
    public ModelAndView saveGallery(@ModelAttribute("gallery") GalleryUpload galleryUpload) {
        MultipartFile multipartFile = galleryUpload.getMultipartFile();
        String path = UPLOAD_LOCATION + multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pathFile = multipartFile.getOriginalFilename();
        Gallery galleryDb = new Gallery();
        galleryDb.setId(galleryUpload.getId());
        galleryDb.setName(galleryUpload.getName());
        galleryDb.setDecscription(galleryUpload.getDecscription());
        galleryDb.setImage(pathFile);
        galleryDb.setCategory(galleryUpload.getCategory());
        galleryService.save(galleryDb);
        ModelAndView modelAndView = new ModelAndView("/manager/addGallery");
        modelAndView.addObject("gallery", new GalleryUpload());
        modelAndView.addObject("message", "New gallery created successfully");
        return modelAndView;
    }
    //Create gallery

    //Edit gallery
    @GetMapping("/admin/edit-gallery/{id}")
    public ModelAndView editGallery(@PathVariable Long id) {
        Gallery gallery = galleryService.findById(id);
        if (gallery != null) {
            ModelAndView modelAndView = new ModelAndView("/manager/editgallery");
            modelAndView.addObject("gallery", gallery);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/admin/edit-gallery")
    public ModelAndView updateGallery(@ModelAttribute("gallery") Gallery gallery) {
        galleryService.save(gallery);
        ModelAndView modelAndView = new ModelAndView("/manager/editgallery");
        modelAndView.addObject("gallery", gallery);
        modelAndView.addObject("message", "gallery updated successfully");
        return modelAndView;
    }
    //Edit gallery

    //Delete gallery
    @GetMapping("/admin/delete-gallery/{id}")
    public String deleteGallery(@PathVariable Long id) {
        Gallery gallery = galleryService.findById(id);
        if (gallery != null) {
            galleryService.remove(gallery.getId());
            return "redirect:/admin/galleries";
        }
        return "error.404";
    }
    //Delete gallery

    //Detail gallery
    @GetMapping("/admin/detail-gallery/{id}")
    public ModelAndView detailGallery(@PathVariable Long id) {
        Gallery gallery = galleryService.findById(id);
        if (gallery != null) {
            Iterable<Category> category = categoryService.findAll();// View Category
            ModelAndView modelAndView = new ModelAndView("/manager/detailgallery");
            modelAndView.addObject("gallery", gallery);
            modelAndView.addObject("cateList", category);// View Category
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    //Detail gallery

    private static String UPLOAD_LOCATION1 = "/home/hp/IdeaProjects/Gallery-CaseStudy/src/main/webapp/imageCate/";

    //View list category
    @GetMapping("/admin/categories")
    public ModelAndView listCategory() {
        Iterable<Category> category = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/manager/listcate");
        modelAndView.addObject("cateList", category);
        return modelAndView;
    }
    //View list category

    //Create category
    @GetMapping("/admin/create-category")
    public ModelAndView createCategory() {
        ModelAndView modelAndView = new ModelAndView("/manager/addcate");
        modelAndView.addObject("categoryCreate", new CategoryUpload());
        return modelAndView;
    }

    @PostMapping("/admin/create-category")
    public ModelAndView saveCategory(@ModelAttribute("categoryCreate") CategoryUpload categoryUpload) {
        MultipartFile multipartFileCate = categoryUpload.getMultipartFileCate();
        String path = UPLOAD_LOCATION1 + multipartFileCate.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFileCate.getBytes(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pathFile = multipartFileCate.getOriginalFilename();
        Category categoryDb = new Category();
        categoryDb.setId(categoryUpload.getId());
        categoryDb.setName(categoryUpload.getName());
        categoryDb.setImageCate(pathFile);
        categoryService.save(categoryDb);
        ModelAndView modelAndView = new ModelAndView("/manager/addcate");
        modelAndView.addObject("categoryCreate", new CategoryUpload());
        modelAndView.addObject("message", "New Category created successfully");
        return modelAndView;
    }
    //Create category

    //Edit category
    @GetMapping("/admin/edit-category/{id}")
    public ModelAndView editCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/manager/editcate");
            modelAndView.addObject("categoryEdit", category);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/admin/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("categoryEdit") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/manager/editcate");
        modelAndView.addObject("categoryEdit", category);
        modelAndView.addObject("message", "category updated successfully");
        return modelAndView;
    }
    //Edit category

    //Delete category
    @GetMapping("/admin/delete-category/{id}")
    public String deleteCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            categoryService.remove(category.getId());
            return "redirect:/admin/categories";
        }
        return "error.404";
    }
    //Delete category

    //View category
    @GetMapping("/admin/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ModelAndView("/error.404");
        }

        Iterable<Gallery> galleries = galleryService.findAllByCategory(category);
        Iterable<Category> categorylist = categoryService.findAll();// View Category

        ModelAndView modelAndView = new ModelAndView("/manager/index");
        modelAndView.addObject("category", category);
        modelAndView.addObject("galleries", galleries);
        modelAndView.addObject("cateList", categorylist);// View Category
        return modelAndView;
    }
    //View category
}
