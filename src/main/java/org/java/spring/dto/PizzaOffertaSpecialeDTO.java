package org.java.spring.dto;

public class PizzaOffertaSpecialeDTO {

	private int pizza_id;
	private String titolo;
	
	public int getPizza_id() {
		return pizza_id;
	}



	public void setPizza_id(int pizza_id) {
		this.pizza_id = pizza_id;
	}



	public String getTitolo() {
		return titolo;
	}



	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	@Override
	public String toString() {
		
		return getPizza_id() + " - " + getTitolo();
	}
}
