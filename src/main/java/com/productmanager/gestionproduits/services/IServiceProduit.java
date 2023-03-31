package com.productmanager.gestionproduits.services;

import com.productmanager.gestionproduits.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceProduit {

    void saveProduit(Product p, MultipartFile mf) throws IOException;
    List<Product> getAllProduit();
    Page<Product> getProduitBMC(String mc, Pageable p);
    List <Product> getProduitByCat(Integer idcat);
    Product getProduit(Integer id);
    void deleteProduit (Integer id);
}
