package com.productmanager.gestionproduits.dao;


import com.productmanager.gestionproduits.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String username);
}
