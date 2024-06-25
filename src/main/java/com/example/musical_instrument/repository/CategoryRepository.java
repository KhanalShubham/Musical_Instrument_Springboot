package com.example.musical_instrument.repository;

import com.example.musical_instrument.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
