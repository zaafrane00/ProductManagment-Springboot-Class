package com.productmanager.gestionproduits.services;

import com.productmanager.gestionproduits.dao.UserRepository;
import com.productmanager.gestionproduits.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
    private final UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = ur.findByUserName(username);
        List<GrantedAuthority> ga = new ArrayList<>();

        user.getRoles()
                .forEach(r -> ga.add(new SimpleGrantedAuthority(r.getRole())));

        return new User(user.getUserName(),user.getPassword(),ga);
    }
}
