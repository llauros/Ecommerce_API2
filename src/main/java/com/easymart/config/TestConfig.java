package com.easymart.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.easymart.entities.ProductEntity;
import com.easymart.entities.UserEntity;
import com.easymart.repositories.ProductRepository;
import com.easymart.repositories.UserRepository;

@Component
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner  {

	@Autowired
	 private UserRepository repo;
	
	@Autowired
	 private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// DATABASE SEEDING FOR USER
		UserEntity user1, user2;
		user1 = new UserEntity("Maria Brown", "maria@gmail.com", "123456");
		user2 = new UserEntity("Alex Green", "alex@gmail.com", "123456");
		repo.saveAll(Arrays.asList(user1, user2));
		
		ProductEntity p1, p2, p3, p4, p5, p6, p7;
			
		p1 = new ProductEntity("The Lord of the Rings", "Lorem ipsum dolor amet", new BigDecimal("90.5"), null);
		p2 = new ProductEntity("Smart TV", "Nulla eu purus. Maecenas ante", new BigDecimal("2190.0"), null);
		p3 = new ProductEntity("Macbook Pro", "Nam eleifend maximus tortor", new BigDecimal("1250.0"), null);
		p4 = new ProductEntity("PC Gamer", "Donec aliquet odio ac rhoncus cursus", new BigDecimal("1200.0"), null);
		p5 = new ProductEntity("Redmi X3", "The better smartphone.", new BigDecimal("800.99"), null);
		p6 = new ProductEntity("Hidratante", "Neutrogena matte 3 em 1", new BigDecimal("20.33"), null);
		p7 = new ProductEntity("Garrafa de agua", "Vendida em Jundiai", new BigDecimal("1555.99"), null);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
		
	}

}
