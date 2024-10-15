package com.example.demo.service;

import com.example.demo.entitiy.Basket;
import com.example.demo.entitiy.BasketProduct;
import com.example.demo.entitiy.Product;
import com.example.demo.repository.BasketProductRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.BasketRepository;
import com.example.demo.request.BasketRequest;
import com.example.demo.response.BasketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private BasketProductRepository basketProductRepository;

    /**
     * Kullanıcıya ait tüm sepetleri döner.
     */
    public List<Basket> getBasketsByUserId(Long userId) {
        return basketRepository.findByUserId(userId);
    }

    /**
     * Yeni bir sepet kaydeder.
     */
    public Basket saveBasket(Basket basket) {
        if (basket == null || basket.getUser() == null) {
            throw new IllegalArgumentException("Sepet veya kullanıcı bilgisi eksik.");
        }
        return basketRepository.save(basket);
    }

    /**
     * Sepete ürün ekler.
     */
    public BasketProduct addProductToBasket(BasketProduct basketProduct) {
        if (basketProduct == null || basketProduct.getBasket() == null || basketProduct.getProduct() == null) {
            throw new IllegalArgumentException("Ürün veya sepet bilgisi eksik.");
        }
        return basketProductRepository.save(basketProduct);
    }

    /**
     * Sepeti id ile siler.
     */
    public void deleteBasket(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Geçersiz sepet ID.");
        }
        basketRepository.deleteById(id);
    }
}
