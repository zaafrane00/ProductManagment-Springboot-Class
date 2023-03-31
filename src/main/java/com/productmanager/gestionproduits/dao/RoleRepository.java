package com.productmanager.gestionproduits.dao;

import com.productmanager.gestionproduits.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<AppRole,Integer> {
}
