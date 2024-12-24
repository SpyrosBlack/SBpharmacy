package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Category;
import com.nyc.sbpharmacy.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

}
