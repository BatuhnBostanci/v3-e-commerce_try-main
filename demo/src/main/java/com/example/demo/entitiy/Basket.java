package com.example.demo.entitiy;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double basketAmount;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketProduct> basketProducts;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Basket() {
    }

    public Basket(Long id, double basketAmount, List<BasketProduct> basketProducts, User user) {
        this.id = id;
        this.basketAmount = basketAmount;
        this.basketProducts = basketProducts;
        this.user = user;
    }

    // Getter ve Setter'lar
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBasketAmount() {
        return basketAmount;
    }

    public void setBasketAmount(double basketAmount) {
        this.basketAmount = basketAmount;
    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
