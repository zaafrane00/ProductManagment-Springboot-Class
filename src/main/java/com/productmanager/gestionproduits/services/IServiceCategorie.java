package com.productmanager.gestionproduits.services;

import com.productmanager.gestionproduits.entities.Category;

import java.util.List;

public interface IServiceCategorie {

    void addCategorie(Category c);
    List<Category> getAllCategories();
}
