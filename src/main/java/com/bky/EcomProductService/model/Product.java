package com.bky.EcomProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PRODUCT")
public class Product extends BaseModel{
    private String title;
    private double price;

    private String description;

    private String image;
    @ManyToOne
    private Category category;
}
