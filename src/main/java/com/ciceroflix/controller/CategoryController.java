package com.ciceroflix.controller;

import com.ciceroflix.controller.request.CategoryRequest;
import com.ciceroflix.controller.response.CategoryResponse;
import com.ciceroflix.entity.Category;

import com.ciceroflix.mapper.CategoryMapper;
import com.ciceroflix.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ciceroflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    /************************************************************/
    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<Category> categories = categoryService.findAll();
        List<CategoryResponse> list = categories.stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        return ResponseEntity.ok(list);
    }
    /************************************************************/
    @PostMapping()
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }
    /************************************************************/
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id) {
        Optional<Category> optCategory = categoryService.findById(id);
        if(optCategory.isPresent()){
            CategoryResponse category = CategoryMapper.toCategoryResponse(optCategory.get());
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /************************************************************/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    /************************************************************/

}
