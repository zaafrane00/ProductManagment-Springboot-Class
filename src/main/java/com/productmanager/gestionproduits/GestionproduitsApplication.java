package com.productmanager.gestionproduits;

import com.productmanager.gestionproduits.dao.CategoryRepository;
import com.productmanager.gestionproduits.dao.ProductRepository;
import com.productmanager.gestionproduits.dao.RoleRepository;
import com.productmanager.gestionproduits.dao.UserRepository;
import com.productmanager.gestionproduits.entities.AppRole;
import com.productmanager.gestionproduits.entities.AppUser;
import com.productmanager.gestionproduits.entities.Category;
import com.productmanager.gestionproduits.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;


@SpringBootApplication
@AllArgsConstructor
public class GestionproduitsApplication  implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;



	public static void main(String[] args) {
		SpringApplication.run(GestionproduitsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Category category1=new Category(null,"Informatique",null);
//		Category category2=new Category(null,"Electronic",null);
//		Category category3=new Category(null,"Desktop",null);
//		categoryRepository.save(category1);
//		categoryRepository.save(category2);
//		categoryRepository.save(category3);
//		Product product1=new Product(null,"PC",0,0,categoryRepository.findById(1).get(),null);
//		Product product2=new Product(null,"PC",0,0,categoryRepository.findById(2).get(),null);
//		Product product3=new Product(null,"TV",0,0,categoryRepository.findById(3).get(),null);
//		productRepository.save(product1);
//		productRepository.save(product2);
//		productRepository.save(product3);


//		AppRole role1 = new AppRole();
//		AppRole role2 = new AppRole();
//
//		role1.setRole("USER");
//		role2.setRole("ADMIN");
//
//		ArrayList<AppRole> roles1 = new ArrayList<>();
//		roles1.add(role1);
//
//		ArrayList<AppRole> roles2 = new ArrayList<>();
//		roles2.add(role2);
//
//
//
//		AppUser user1 = new AppUser();
//		AppUser user2 = new AppUser();
//
//		user1.setUserName("user1");
//		user1.setPassword(passwordEncoder.encode("user1"));
//		user1.setRoles(roles1);
//
//		user2.setUserName("admin");
//		user2.setPassword(passwordEncoder.encode("admin"));
//		user2.setRoles(roles2);
//
//		userRepository.save(user1);
//		userRepository.save(user2);
//		roleRepository.save(role1);
//		roleRepository.save(role2);


	}
}
