package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Ingrediente;
import org.java.spring.db.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import jakarta.validation.Valid;

@Controller
public class IngredienteController {

	@Autowired
	private IngredienteService ingredienteService;
	
	@GetMapping("pizzas/ingredienti")
	public String getIngredienti(Model model) {
		
		List<Ingrediente> index = ingredienteService.findAll();
		
		model.addAttribute("ingredienti", index);
		
		
		return "ingredienti";
	}
	
	
	@GetMapping("/pizzas/ingredienti{id}")
	public String getIngrediente(Model model,
			@PathVariable int id) {
		
		Ingrediente ingrediente = ingredienteService.findById(id);
		model.addAttribute("ingrediente", ingrediente);
		
		return "ingredienti";
	}
	
	@GetMapping("/pizzas/ingredienti/create")
	public String createIngredienti(Model model) {
		
		Ingrediente ingrediente = new Ingrediente();
		
		model.addAttribute("ingrediente", ingrediente);
		
		return "ingrediente-form";
	}
	
	@PostMapping("/pizzas/ingredienti/create")
	public String storeIngrediente(
			Model model,
			@Valid @ModelAttribute Ingrediente ingrediente, 
			BindingResult bindingResult) {
			
		
		return saveIngrediente(model, ingrediente, bindingResult);
	}
	
	@PostMapping("/pizzas/ingredienti/delete/{id}")
	public String deleteIngrediente(@PathVariable int id) {
		
		Ingrediente ingrediente = ingredienteService.findById(id);
		ingredienteService.delete(ingrediente);
		
		return "redirect:/";
	}
	
	private String saveIngrediente(Model model,
			@Valid @ModelAttribute Ingrediente ingrediente, 
			BindingResult bindingResult) {
		
		System.out.println("Ingrediente:\n" + ingrediente);
		System.out.println("\n---------------\n");
		System.out.println("Error:\n" + bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("ingrediente", ingrediente);
			return "ingrediente-form";
		}
		
		ingredienteService.save(ingrediente);
	
		return "redirect:/";
	}
}
