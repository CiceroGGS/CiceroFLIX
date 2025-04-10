package com.ciceroflix.mapper;

import com.ciceroflix.controller.request.CategoryRequest;
import com.ciceroflix.controller.response.CategoryResponse;
import com.ciceroflix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())  // Usa getter da entidade Category
                .name(category.getName())
                .build();
    }

}
