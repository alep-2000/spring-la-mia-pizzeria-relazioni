package org.java.spring;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaRelazioniApplication implements CommandLineRunner{

	@Autowired
	private PizzaService pizzaService;
		
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaRelazioniApplication.class, args);
		
	}


	@Override
	public void run(String... args) throws Exception {
	
		
		pizzaService.save(new Pizza("Margherita", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200", 6.99));
		pizzaService.save(new Pizza("Marinara", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 8));
		pizzaService.save(new Pizza("Bufala", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 18));
		pizzaService.save(new Pizza("Funghi", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 15.50));
		pizzaService.save(new Pizza("Salsiccia", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 6.30));
		pizzaService.save(new Pizza("Capricciosa", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 10.50));
		pizzaService.save(new Pizza("Carbonara", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 22.80));
		pizzaService.save(new Pizza("4 Formaggi", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 10.50));
	}
}
