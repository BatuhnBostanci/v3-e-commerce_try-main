package com.example.demo.entitiy;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "magaza_id")  // Foreign key olarak mağazayı işaret eder
    private Magaza magaza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Magaza getMagaza() {
        return magaza;
    }

    public void setMagaza(Magaza magaza) {
        this.magaza = magaza;
    }

    public void setName(String category) {
        this.categoryName = category;
    }

    public String getName() {
        return this.categoryName;
    }
}
