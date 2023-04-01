package com.productmanager.gestionproduits.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productmanager.gestionproduits.entities.Product;
import com.productmanager.gestionproduits.services.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/product/add")
    public void addProduct(@RequestParam("produit")String produit, @RequestParam("file")MultipartFile mf){
        try{
            Product p=new ObjectMapper().readValue(produit,Product.class);
            sp.saveProduit(p,mf);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
