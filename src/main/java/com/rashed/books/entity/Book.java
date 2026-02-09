package com.rashed.books.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rashed.books.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="books")
@EntityListeners(AuditingEntityListener.class)
public class Book extends BaseEntity {

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
