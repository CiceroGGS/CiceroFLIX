package com.ciceroflix.service;

import com.ciceroflix.entity.Category;
import com.ciceroflix.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Category findById(Long id) {
        Optional<Category> optCategory = repository.findById(id);
        if(optCategory.isPresent()){
            return optCategory.get();
        } else {
            return null;
        }
    }

    /************************************************************/

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
