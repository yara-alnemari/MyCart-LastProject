package com.udacity.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    double price;

    @Column(name = "url")
    String url;

    public Product(String name, String description, String url, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.url = url;
    }
}
