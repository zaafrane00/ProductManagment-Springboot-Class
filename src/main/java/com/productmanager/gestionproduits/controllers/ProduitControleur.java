package com.productmanager.gestionproduits.controllers;

import com.productmanager.gestionproduits.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.productmanager.gestionproduits.services.IServiceCategorie;
import com.productmanager.gestionproduits.services.IServiceProduit;
import java.io.IOException;

@Controller
@AllArgsConstructor
public class ProduitControleur {

    private final IServiceProduit sp;
    private final IServiceCategorie sc;

    @GetMapping("/hello")
    public void hello(){
        System.out.println("sssss");
    }

    @GetMapping("/home")
    public String getProducts(Model m,
                              @RequestParam(name="mc",defaultValue = "") String mc,
                              @RequestParam(name="page",defaultValue="1") int page,
                              @RequestParam(name = "size",defaultValue="5") int size

    ){
        Page<Product> pages = sp.getProduitBMC(mc, PageRequest.of(page-1, size));
        m.addAttribute("data",pages.getContent());
        m.addAttribute("currentPage",pages.getNumber());
        m.addAttribute("pages",new int[pages.getTotalPages()]);
        m.addAttribute("mc",mc);
        return "produits";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        sp.deleteProduit(id);
        return "redirect:/home";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model m){
        m.addAttribute("data", new Product());
        m.addAttribute("categories",sc.getAllCategories());
        return "addProduct";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product produit, @RequestParam("file") MultipartFile mf) throws IOException {
        sp.saveProduit(produit,mf);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id,Model m){
        Product product = sp.getProduit(id);
        m.addAttribute("data", product);
        m.addAttribute("categories",sc.getAllCategories());
        return "addProduct";
    }
}
