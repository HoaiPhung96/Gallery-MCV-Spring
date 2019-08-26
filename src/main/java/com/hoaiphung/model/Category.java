package com.hoaiphung.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String imageCate;

    @OneToMany(targetEntity = Gallery.class)
    private List<Gallery> galleries;

    public Category() {
    }

    public Category(@NotEmpty String name, @NotEmpty String imageCate) {
        this.name = name;
        this.imageCate = imageCate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageCate() {
        return imageCate;
    }

    public void setImageCate(String imageCate) {
        this.imageCate = imageCate;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }
}
