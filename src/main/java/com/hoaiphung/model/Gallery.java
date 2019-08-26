package com.hoaiphung.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "gallerys")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String decscription;
    @NotEmpty
    private String image;

    @Column(updatable = false)
    @CreationTimestamp
    private Date dateCreate;

    @UpdateTimestamp
    private Date lastEdit;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Gallery() {
    }

    public Gallery(@NotEmpty String name, @NotEmpty String decscription, @NotEmpty String image, Date dateCreate, Date lastEdit) {
        this.name = name;
        this.decscription = decscription;
        this.image = image;
        this.dateCreate = dateCreate;
        this.lastEdit = lastEdit;
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

    public String getDecscription() {
        return decscription;
    }

    public void setDecscription(String decscription) {
        this.decscription = decscription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(Date lastEdit) {
        this.lastEdit = lastEdit;
    }

    @Override
    public String toString() {
        return String.format("Gallery[id=%d, name='%s', decscription='%s', image='%s',dateCreate='%s',lastEdit='%s' ]", id, name, decscription, image, dateCreate, lastEdit);
    }
}
