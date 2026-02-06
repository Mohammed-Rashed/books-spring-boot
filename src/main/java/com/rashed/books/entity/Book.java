package com.rashed.books.entity;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="auther_id", referencedColumnName = "id")
    private Auther auther;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Auther getAuther() {
        return auther;
    }

    public void setAuther(Auther auther) {
        this.auther = auther;
    }
}
