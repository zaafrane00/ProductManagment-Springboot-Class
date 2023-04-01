package com.productmanager.gestionproduits.dao;

import com.productmanager.gestionproduits.entities.Fournisseur;
import com.productmanager.gestionproduits.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {

    public Page<Product> findByNomContains(String mc, Pageable p);

}
