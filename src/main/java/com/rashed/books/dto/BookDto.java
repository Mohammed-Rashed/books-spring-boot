package com.rashed.books.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rashed.books.entity.Auther;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

public class BookDto {

    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @NotBlank
    private String name;
    @Min(value = 5)
    @Max(value = 500)
    private double price;



    @NotNull
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="auther_id", referencedColumnName = "id")
    private Auther auther;



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
