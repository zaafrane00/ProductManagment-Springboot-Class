package com.productmanager.gestionproduits.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    @OneToMany(mappedBy = "cat",cascade = CascadeType.ALL)
    private List<Product> produitList;
}
