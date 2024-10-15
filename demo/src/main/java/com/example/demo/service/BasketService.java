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

    public List<Basket> getBasketsByUserId(Long userId) {
        return basketRepository.findByUserId(userId);
    }

    public Basket saveBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    public BasketProduct addProductToBasket(BasketProduct basketProduct) {
        return basketProductRepository.save(basketProduct);
    }

    public void deleteBasket(Long id) {
        basketRepository.deleteById(id);
    }
}
