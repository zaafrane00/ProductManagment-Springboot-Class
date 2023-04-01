package com.productmanager.gestionproduits.services;

import com.productmanager.gestionproduits.dao.FournisseurRepository;
import com.productmanager.gestionproduits.entities.Fournisseur;
import com.productmanager.gestionproduits.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceFournisseur implements IServiceFournisseur{

    private FournisseurRepository fournisseurRepository;


    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public List<Product> getProducts(Integer id) {
        Fournisseur fournisseur=getFournisseur(id);
        return fournisseur.getProducts();
    }

    @Override
    public void delete(Integer id) {
        fournisseurRepository.deleteById(id);
    }

    @Override
    public Fournisseur getFournisseur(Integer id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> getFournisseurBMC(String mc, Pageable p) {
        return fournisseurRepository.findByNomContains(mc,p);
    }
}
