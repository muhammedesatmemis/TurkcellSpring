package com.turkcell.spring.first.controllers;

import com.turkcell.spring.first.business.abstracts.CategoryService;
import com.turkcell.spring.first.entities.Category;

import com.turkcell.spring.first.entities.dtos.CategoryForAddDto;
import com.turkcell.spring.first.entities.dtos.CategoryForListingDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
//http://localhost:8080/swagger-ui/index.html
// localhost:8080/categories/action
public class CategoriesController {

    private CategoryService categoryService;
    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // localhost:8080/categories
    @GetMapping()
    public List<CategoryForListingDto> getAllCategories() {
        List<CategoryForListingDto> categoriesInDb = categoryService.getAllCategories();
        return categoriesInDb;
    }

    // localhost:8080/categories/getCategoryById/5
    @GetMapping("getCategoryById/{id}")
    public Category getCategoryById(@PathVariable("id") int id) {
        Category category = categoryService.getCategory(id);
        return category;
    }
    // localhost:8080/categories/addCategory
    //{
    //    "categoryId": 10,
    //    "categoryName": "Bisiklet",
    //    "description": "Arazi, Yarış"
    //}
    @PostMapping("addCategory")
    public ResponseEntity addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return new ResponseEntity("Kategori eklendi", HttpStatus.CREATED);
    }
    // localhost:8080/categories/updateCategory/10
    //{
    //    "categoryName": "UTV"
    //}
    @PutMapping("updateCategory/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category updatedCategory) {
        Category updated = categoryService.updateCategory(categoryId, updatedCategory);
        return new ResponseEntity<>(updated, HttpStatus.OK);

    }
    // localhost:8080/categories/deleteCategory/10
    @DeleteMapping("deleteCategory/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity("Kategori silindi", HttpStatus.OK);
    }

    // localhost:8080/categories/getByName/Beverages
    @GetMapping("getByName/{name}")
    public List<Category> getCategoriesByName(@PathVariable("name")String name) {
        return categoryService.getCategoriesByName(name);
    }

    // localhost:8080/categories/findByDescription/Soft drinks, coffees, teas, beers, and ales
    @GetMapping("findByDescription/{description}")
    public List<Category> findByDescription(@PathVariable("description")String description){
        return categoryService.findByDescription(description);
    }

    // localhost:8080/categories/findByCategoryNameStartingWith/P
    @GetMapping("findByCategoryNameStartingWith/{prefix}")
    public List<Category> findByCategoryNameStartingWith(@PathVariable("prefix")String prefix) {
        return categoryService.findByCategoryNameStartingWith(prefix);
    }

    // localhost:8080/categories/search/Con
    @GetMapping("search/{name}")
    public List<Category> search(@PathVariable("name") String name) {
        return categoryService.search(name);
    }

    // localhost:8080/categories/searchFirst/B
    @GetMapping("searchFirst/{categoryName}")
    public List<Category> searchFirst(@PathVariable("categoryName") String categoryName) {
        return categoryService.searchFirst(categoryName);
    }

    // localhost:8080/categories/searchEnd/s
    @GetMapping("searchEnd/{categoryName}")
    public List<Category> searchEnd(@PathVariable("categoryName") String categoryName) {
        return categoryService.searchEnd(categoryName);
    }

    // localhost:8080/categories/searchNative/Be
    @GetMapping("searchNative/{categoryName}")
    public List<Category> searchNative(@PathVariable("categoryName") String categoryName) {
        return categoryService.searchNative(categoryName);
    }

    // localhost:8080/categories/searchNativeFirst/D
    @GetMapping("searchNativeFirst/{categoryName}")
    public List<Category> searchNativeFirst(@PathVariable("categoryName") String categoryName) {
        return categoryService.searchNativeFirst(categoryName);
    }

    @PostMapping("addCategoryToDto")
    public ResponseEntity addCategoryToDto(@RequestBody @Valid CategoryForAddDto request){
        categoryService.addCategoryToDto(request);
        //categoryRepository.save(category);
        return new ResponseEntity("Kategori eklendi", HttpStatus.CREATED);
    }


}