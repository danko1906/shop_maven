package com.geekbrains.shop.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id//IDENTITY- дефолтная генерация, какой айди база данных дала тот и присвоим
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "products_categories",joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    public Product(Long id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

}
