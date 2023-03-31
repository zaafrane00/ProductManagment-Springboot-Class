package com.productmanager.gestionproduits.services;

import com.productmanager.gestionproduits.dao.ProductRepository;
import com.productmanager.gestionproduits.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@AllArgsConstructor
@Service
public class ServiceProduit implements IServiceProduit{

    private final ProductRepository pr;

    @Override
    public void saveProduit(Product p, MultipartFile mf) throws IOException {
        if(!mf.isEmpty())
            p.setPhoto(saveImage(mf));
        pr.save(p);
    }

    @Override
    public List<Product> getAllProduit() {
        return pr.findAll();
    }

    @Override
    public Page<Product> getProduitBMC(String mc, Pageable p) {
        return pr.findByNomContains(mc,p);
    }


    @Override
    public List<Product> getProduitByCat(Integer idcat) {
        return pr.getProductByCat(idcat);
    }

    @Override
    public Product getProduit(Integer id) {
        return pr.findById(id).orElse(null);
    }

    @Override
    public void deleteProduit(Integer id) {
        pr.deleteById(id);
    }

    private String saveImage(MultipartFile mf) throws IOException {
        String nomFile = mf.getOriginalFilename();
        String tab[] = nomFile.split("\\.");
        String newName = tab[0] + System.currentTimeMillis() + "." + tab[1];
        Path p = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/images/",newName);
        Files.write(p,mf.getBytes());
        return newName;
    }
}
