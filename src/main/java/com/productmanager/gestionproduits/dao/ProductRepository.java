package com.productmanager.gestionproduits.dao;

import com.productmanager.gestionproduits.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Page<Product> findByNomContains(String mc, Pageable p);

    @Query("select p from Product p where p.cat.id=:id")
    public List<Product> getProductByCat(@Param("id")Integer id);
}
