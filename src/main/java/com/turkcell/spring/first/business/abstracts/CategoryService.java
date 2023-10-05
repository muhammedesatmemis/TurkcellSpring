package com.turkcell.spring.first.business.abstracts;

import com.turkcell.spring.first.entities.Category;
import com.turkcell.spring.first.entities.dtos.CategoryForAddDto;
import com.turkcell.spring.first.entities.dtos.CategoryForListingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    void addCategory(Category category);
    void addCategoryToDto(CategoryForAddDto request);

    void deleteCategory(int categoryId);
    Category updateCategory(int categoryId, Category category);

    Category getCategory(int categoryId);
    List<CategoryForListingDto> getAllCategories();



    List<Category> getCategoriesByName(String name);
    List<Category> findByDescription(String description);
    List<Category> findByCategoryNameStartingWith(String prefix);
    List<Category> search(String name);
    List<Category> searchFirst(String categoryName);
    List<Category> searchEnd(String categoryName);
    List<Category> searchNative(String categoryName);
    List<Category> searchNativeFirst(String categoryName);

}
