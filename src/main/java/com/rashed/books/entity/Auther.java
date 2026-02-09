package com.rashed.books.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rashed.books.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authers")
public class Auther extends BaseEntity {

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "auther")
    private List<Book> books=new ArrayList<>();



    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
