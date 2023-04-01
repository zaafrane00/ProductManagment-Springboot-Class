package com.productmanager.gestionproduits.controllers;

import com.productmanager.gestionproduits.entities.Product;
import com.productmanager.gestionproduits.services.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProductControllerRest {

    private  IServiceProduit sp;

    @GetMapping("/all")
    public List<Product> index(){
        return sp.getAllProduit();
    }

    @GetMapping(path = "/image/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable Integer id){
        return sp.getImage(id);
    }
}
