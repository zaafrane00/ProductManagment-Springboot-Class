package com.productmanager.gestionproduits.controllers;

import com.productmanager.gestionproduits.entities.Product;
import com.productmanager.gestionproduits.services.IServiceFournisseur;
import com.productmanager.gestionproduits.services.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class FournisseurController {

    private final IServiceProduit iServiceProduit;
    private final IServiceFournisseur iServiceFournisseur;



    @GetMapping("/fourniseurs")
    public String getFourniseurs(Model m){
        m.addAttribute("data",iServiceFournisseur.getAllFournisseurs());
        return "fourniseurs";
    }

    @GetMapping("/fourniseur/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        iServiceFournisseur.delete(id);
        return "redirect:/fourniseurs";
    }

    @GetMapping("/fourniseur/produits/{id}")
    public String getForuniseurProduits(Model m,@PathVariable("id") Integer id){
        m.addAttribute("data",iServiceFournisseur.getFournisseur(id).getProducts());
        return "fournisseures_produits";
    }


}
