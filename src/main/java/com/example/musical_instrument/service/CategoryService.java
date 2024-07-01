package com.example.musical_instrument.service;

import com.example.musical_instrument.entity.Category;
import com.example.musical_instrument.pojo.CategoryPojo;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category saveData(CategoryPojo categoryPojo);
    Category updateData(Integer id, CategoryPojo categoryPojo);
    void deleteData(Integer id);
    Category findById(Integer id);
}
