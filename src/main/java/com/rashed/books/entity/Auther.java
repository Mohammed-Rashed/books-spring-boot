package com.rashed.books.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rashed.books.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authers")
public class Auther extends BaseEntity {

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

//    @Pattern(regexp = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")
//    private String ipAddress;

    @JsonManagedReference
    @OneToMany(mappedBy = "auther")
    private List<Book> books=new ArrayList<>();



    public List<Book> getBooks() {
        return books;
    }

//    public String getIpAddress() {
//        return ipAddress;
//    }
//
//    public void setIpAddress(String ipAddress) {
//        this.ipAddress = ipAddress;
//    }

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
