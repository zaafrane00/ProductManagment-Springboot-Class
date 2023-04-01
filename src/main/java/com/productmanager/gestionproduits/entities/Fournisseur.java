package com.productmanager.gestionproduits.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String adresse;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "product_fournisseur",
            joinColumns = @JoinColumn(name = "fournisseur_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
