package com.productmanager.gestionproduits.services;

import com.productmanager.gestionproduits.entities.Fournisseur;
import com.productmanager.gestionproduits.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceFournisseur {

    List<Fournisseur> getAllFournisseurs();

    List<Product> getProducts(Integer id);

    void delete(Integer id);

    Fournisseur getFournisseur(Integer id);

    Page<Product> getFournisseurBMC(String mc, Pageable p);
}
