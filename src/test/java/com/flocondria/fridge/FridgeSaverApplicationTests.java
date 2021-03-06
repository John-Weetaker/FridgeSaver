package com.flocondria.fridge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flocondria.fridge.domain.Product;
import com.flocondria.fridge.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FridgeSaverApplicationTests implements CommandLineRunner {

	@Test
	public void contextLoads() {
	}
	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("Pain d'épices", "Bjorg"));
		productRepository.save(new Product("Riz basmati", "Taureau ailé"));
		productRepository.save(new Product("1254869863"));
		productRepository.save(new Product("Chocolat 85%", "Lindt"));

		System.out.println("\n*************Original Products*************");
		productRepository.findAll().forEach(System.out::println);

		// Modification of the Products
		productRepository.findAll().forEach(Product -> {
			Product.setBrand(Product.getBrand().toUpperCase());
			productRepository.save(Product);
		});

		System.out.println("\n*************Products Modified*************");
		productRepository.findAll().forEach(System.out::println);

		productRepository.deleteAll();
		System.out.println("\n*************Products removed*************");
		productRepository.findAll().forEach(System.out::println);

		
	}

}
