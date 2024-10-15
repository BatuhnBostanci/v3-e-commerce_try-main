package com.example.demo.controller;

import com.example.demo.request.CategoryRequest;
import com.example.demo.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoryController {
    @RestController
    @RequestMapping("/api/categories")
    public class CategoryController {

        @Autowired
        private com.example.demo.CategoryService.CategoryService categoryService;

        @PostMapping
        public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
            try {
                CategoryResponse createdCategory = categoryService.createProductCategory(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
            try {
                categoryService.deleteProductCategory(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @GetMapping
        public ResponseEntity<List<CategoryResponse>> getAllCategories() {
            try {
                List<CategoryResponse> categories = categoryService.getAllProductCategories();
                return ResponseEntity.ok(categories);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<CategoryResponse> updateCategory(@RequestBody CategoryRequest request, @PathVariable int id) {
            try {
                CategoryResponse updatedCategory = categoryService.updateProductCategory(request, id);
                return ResponseEntity.ok(updatedCategory);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }
}
