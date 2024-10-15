package com.example.demo.CategoryService;

import com.example.demo.entitiy.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.request.CategoryRequest;
import com.example.demo.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MagazaRepository magazaRepository;

    /**
     * Yeni bir kategori oluşturur.
     */
    public CategoryResponse createCategory(CategoryRequest request, Long magazaId) {
        Magaza magaza = magazaRepository.findById(magazaId)
                .orElseThrow(() -> new RuntimeException("Mağaza bulunamadı"));

        Category category = toEntity(request);
        category.setMagaza(magaza);  // Kategoriyi mağazaya bağlama
        categoryRepository.save(category);
        return toResponse(category);
    }

    /**
     * Tüm kategorileri döner.
     */
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : categories) {
            categoryResponses.add(toResponse(category));
        }
        return categoryResponses;
    }

    /**
     * Kategori günceller.
     */
    public CategoryResponse updateCategory(CategoryRequest request, Long id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
        existingCategory.setCategoryName(request.getCategory());
        categoryRepository.save(existingCategory);
        return toResponse(existingCategory);
    }

    /**
     * Kategori siler.
     */
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    // Request ve Response dönüştürücüler
    public Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setCategoryName(request.getCategory());
        return category;
    }

    public CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setCategoryName(category.getCategoryName());
        return response;
    }

    public CategoryResponse createProductCategory(CategoryRequest request) {
        return null;
    }

    public List<CategoryResponse> getAllProductCategories() {
        return null;
    }

    public CategoryResponse updateProductCategory(CategoryRequest request, int id) {
        return null;
    }

    public void deleteProductCategory(int id) {

    }
}
