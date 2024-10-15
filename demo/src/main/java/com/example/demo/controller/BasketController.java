package com.example.demo.controller;

import com.example.demo.entitiy.Basket;
import com.example.demo.entitiy.BasketProduct;
import com.example.demo.request.BasketRequest;
import com.example.demo.response.BasketResponse;
import com.example.demo.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baskets")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping("/user/{userId}")
    public List<Basket> getBasketsByUserId(@PathVariable Long userId) {
        return basketService.getBasketsByUserId(userId);
    }

    @PostMapping
    public Basket saveBasket(@RequestBody Basket basket) {
        return basketService.saveBasket(basket);
    }

    @PostMapping("/addProduct")
    public BasketProduct addProductToBasket(@RequestBody BasketProduct basketProduct) {
        return basketService.addProductToBasket(basketProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteBasket(@PathVariable Long id) {
        basketService.deleteBasket(id);
    }
}

