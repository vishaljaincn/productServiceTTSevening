package dev.naman.productservicettsevening.services;

public interface CategoryService {
    String getAllCategories();

    String getProductsInCategory(Long categoryId);
}
