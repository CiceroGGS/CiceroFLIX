package com.ciceroflix.controller;

import com.ciceroflix.entity.Category;

import com.ciceroflix.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciceroflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    /************************************************************/
    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }
    /************************************************************/
    @PostMapping()
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }
    /************************************************************/
    @GetMapping("/{id}")
    public Category getByCategoryId(@PathVariable Long id) {
        return categoryService.findById(id);
    }
    /************************************************************/
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
    /************************************************************/

}
