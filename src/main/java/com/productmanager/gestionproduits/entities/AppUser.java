package com.productmanager.gestionproduits.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class AppUser {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List<AppRole> roles = new ArrayList<>();
}
