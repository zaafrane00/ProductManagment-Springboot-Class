package com.productmanager.gestionproduits.dao;

import com.productmanager.gestionproduits.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
