package com.easymart.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.easymart.entities.CategoryEntity;
import com.easymart.entities.ProductEntity;
import com.easymart.entities.UserEntity;
import com.easymart.repositories.CategoryRepository;
import com.easymart.repositories.ProductRepository;
import com.easymart.repositories.UserRepository;

@Component
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner  {

	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	 private ProductRepository productRepository;
	
	@Autowired
	 private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// DATABASE SEEDING FOR USER
		UserEntity user1, user2;
		ProductEntity p1, p2, p3, p4, p5, p6, p7;
		CategoryEntity c1, c2, c3, c4, c5;
		
		// DATABASE SEEDING FOR USER
		user1 = new UserEntity("Maria Brown", "maria@gmail.com", "123456");
		user2 = new UserEntity("Alex Green", "alex@gmail.com", "123456");
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		//DATABASE SEEDING FOR CATEGORY
		c1 = new CategoryEntity("Moda");
		c2 = new CategoryEntity("Eletrônicos");
		c3 = new CategoryEntity("Saúde");
		c4 = new CategoryEntity("Construção");
		c5 = new CategoryEntity("Livros");
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
			
		// DATABASE SEEDING FOR PRODUCT
		p1 = new ProductEntity("The Lord of the Rings", "Lorem ipsum dolor amet", new BigDecimal("90.5"), null, c2);
		p2 = new ProductEntity("Smart TV", "Nulla eu purus. Maecenas ante", new BigDecimal("2190.0"), null, c1);
		p3 = new ProductEntity("Macbook Pro", "Nam eleifend maximus tortor", new BigDecimal("1250.0"), null, c3);
		p4 = new ProductEntity("PC Gamer", "Donec aliquet odio ac rhoncus cursus", new BigDecimal("1200.0"), null, c5);
		p5 = new ProductEntity("Redmi X3", "The better smartphone.", new BigDecimal("800.99"), null, c4);
		p6 = new ProductEntity("Hidratante", "Neutrogena matte 3 em 1", new BigDecimal("20.33"), null, c4);
		p7 = new ProductEntity("Garrafa de agua", "Vendida em Jundiai", new BigDecimal("1555.99"), null, c1);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
		
	}

}
