package com.example.musical_instrument.service.impl;

import com.example.musical_instrument.entity.Category;
import com.example.musical_instrument.pojo.CategoryPojo;
import com.example.musical_instrument.repository.CategoryRepository;
import com.example.musical_instrument.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveData(CategoryPojo categoryPojo) {
        Category category = new Category();
        category.setCategory_name(categoryPojo.getCategory_name());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateData(Integer id, CategoryPojo categoryPojo) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        category.setCategory_name(categoryPojo.getCategory_name());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteData(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        categoryRepository.delete(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }
}
