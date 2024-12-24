package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}