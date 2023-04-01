package com.productmanager.gestionproduits.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private double prix;
    private int quantitie;
    @ManyToOne
    private Category cat;
    private String photo;
    @ManyToMany(mappedBy = "products",cascade = CascadeType.PERSIST)
    private List<Fournisseur> fournisseurs;


}
