package com.example.demo.controller;

import com.example.demo.entitiy.Basket;
import com.example.demo.entitiy.BasketProduct;
import com.example.demo.request.BasketRequest;
import com.example.demo.response.BasketResponse;
import com.example.demo.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baskets")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Basket>> getBasketsByUserId(@PathVariable Long userId) {
        try {
            List<Basket> baskets = basketService.getBasketsByUserId(userId);
            return ResponseEntity.ok(baskets);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Basket> saveBasket(@RequestBody Basket basket) {
        try {
            Basket savedBasket = basketService.saveBasket(basket);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBasket);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/addProduct")
    public ResponseEntity<BasketProduct> addProductToBasket(@RequestBody BasketProduct basketProduct) {
        try {
            BasketProduct addedProduct = basketService.addProductToBasket(basketProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasket(@PathVariable Long id) {
        try {
            basketService.deleteBasket(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

