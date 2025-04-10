package com.ciceroflix.service;

import com.ciceroflix.entity.Category;
import com.ciceroflix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.repository= categoryRepository;
    }

    /************************************************************/

    public List<Category> findAll() {
        return repository.findAll();
    }

    /************************************************************/

    public Category saveCategory(Category category){
        return repository.save(category);
    }

    /************************************************************/

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    /************************************************************/

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
