package com.infodev.emart.emart.repo;


import com.infodev.emart.emart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
