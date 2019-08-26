package com.hoaiphung.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min = 5, max = 20)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String password;

    @Column(updatable = false)
    @CreationTimestamp
    private Date dateCreate;

    @UpdateTimestamp
    private Date lastEdit;

    public User() {
    }

    public User(@NotEmpty @Size(min = 5, max = 20) String name, @NotEmpty @Size(min = 5, max = 20) String password, Date dateCreate, Date lastEdit) {
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
