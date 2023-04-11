package com.productmanager.gestionproduits.services;

import com.productmanager.gestionproduits.dao.ProductRepository;
import com.productmanager.gestionproduits.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    private JavaMailSender mailSender;

    @Override
    public void saveProduit(Product p, MultipartFile mf) throws IOException {
        if(!mf.isEmpty())
            p.setPhoto(saveImage2(mf));
        pr.save(p);
    }

    @Override
    public List<Product> getAllProduit() {
        sendEmail("zaafranehamza@gmail.com","subject","body");
        return pr.findAll();
    }

    @Override
    public Page<Product> getProduitBMC(String mc, Pageable p) {
        sendEmail("zaafranehamza@gmail.com","subject","body");
        return pr.findByNomContains(mc,p);
    }


    @Override
    public List<Product> getProduitByCat(Integer idcat) {
      //  sendEmail("zaafranehamza@gmail.com","subject","body");
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

    @Override
    public byte[] getImage(Integer id) {
        try{
            String path=System.getProperty("user.home") + "/images/";
            Path p = Paths.get(path,getProduit(id).getPhoto());
            return Files.readAllBytes(p);
        }catch (IOException e){
            e.printStackTrace();
        }
            return null;
    }

    private String saveImage(MultipartFile mf) throws IOException {
        String nomFile = mf.getOriginalFilename();
        String[] tab = nomFile.split("\\.");
        String newName = tab[0] + System.currentTimeMillis() + "." + tab[1];
        Path p = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/images/",newName);
        Files.write(p,mf.getBytes());
        return newName;
    }

    private String saveImage2(MultipartFile mf) throws IOException {
        String nomFile = mf.getOriginalFilename();
        String[] tab = nomFile!=null? nomFile.split("\\."): null;
        String newName = tab[0] + System.currentTimeMillis() + "." + tab[1];
        String path=System.getProperty("user.home") + "/images/";
        if(Files.notExists(Paths.get(path))){
            Files.createDirectories(Paths.get(path));
        }
        Path p = Paths.get(path,newName);
        Files.write(p,mf.getBytes());
        return newName;
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
