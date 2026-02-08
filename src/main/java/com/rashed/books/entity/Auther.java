package com.rashed.books.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rashed.books.base.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authers")
public class Auther extends BaseEntity {

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
