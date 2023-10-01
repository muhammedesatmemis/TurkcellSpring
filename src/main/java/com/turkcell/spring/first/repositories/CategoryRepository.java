package com.turkcell.spring.first.repositories;

import com.turkcell.spring.first.entities.Category;
import com.turkcell.spring.first.entities.dtos.CategoryForListingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByCategoryNameContaining(String categoryName);
    Category findByCategoryName(String categoryName);
    List<Category> findByDescription(String description);
    List<Category> findByCategoryNameStartingWith(String prefix);
    @Query(value = "Select c FROM Category c WHERE c.categoryName LIKE %:categoryName%", nativeQuery = false)
    List<Category> search(String categoryName);
    @Query(value = "Select c FROM Category c WHERE c.categoryName LIKE :categoryName%", nativeQuery = false)
    List<Category> searchFirst(String categoryName);
    @Query(value = "Select c FROM Category c WHERE c.categoryName LIKE %:categoryName", nativeQuery = false)
    List<Category> searchEnd(String categoryName);
    @Query(value = "Select * from categories Where category_name LIKE %:categoryName%", nativeQuery = true)
    List<Category> searchNative(String categoryName);
    @Query(value = "Select * from categories Where category_name LIKE :categoryName%", nativeQuery = true)
    List<Category> searchNativeFirst(String categoryName);

    @Query(value="SELECT new " +
            "com.turkcell.spring.first.entities.dtos.CategoryForListingDto(c.categoryId, c.categoryName) FROM Category c")
    List<CategoryForListingDto> getForListing();

}