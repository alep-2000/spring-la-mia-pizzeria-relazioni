package org.java.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.java.spring.db.pojo.OffertaSpeciale;
import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.OffertaSpecialeService;
import org.java.spring.db.service.PizzaService;
import org.java.spring.dto.PizzaOffertaSpecialeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OffertaSpecialeController {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private OffertaSpecialeService offertaSpecialeService;
	
	@GetMapping("/pizzas/offerta")
	public String getOffertaForm(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		
		return "offerta-form";
	}
	@PostMapping("/pizzas/offerta")
	public String storeOfferte(
			@ModelAttribute PizzaOffertaSpecialeDTO pizzaOffertaSpecialeDTO
		) {
		
		Pizza pizza = pizzaService.findById(pizzaOffertaSpecialeDTO.getPizza_id());
		
		OffertaSpeciale offertaSpeciale = new OffertaSpeciale(
				LocalDate.now(),
				LocalDate.now(),
				pizzaOffertaSpecialeDTO.getTitolo(),
				pizza);
		
		offertaSpecialeService.save(offertaSpeciale);
		
		return "redirect:/";
	}
}
