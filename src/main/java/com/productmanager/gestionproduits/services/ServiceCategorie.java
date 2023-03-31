package com.productmanager.gestionproduits.services;

import com.productmanager.gestionproduits.dao.CategoryRepository;
import com.productmanager.gestionproduits.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategorie {

    private final CategoryRepository cr;
    @Override
    public void addCategorie(Category c) {
        cr.save(c);
    }

    @Override
    public List<Category> getAllCategories() {
        return cr.findAll();
    }
}
