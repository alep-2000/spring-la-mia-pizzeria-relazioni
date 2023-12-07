package org.java.spring.db.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60)
	@Length(min = 3, max = 60, message = "Il nome deve essere compreso tra 3 e 60 caratteri")
	@NotBlank(message = "Il nome non può essere nullo")
	private String nome;
	
	@Column(columnDefinition = "TEXT")
	@Length(min = 3, message = "La descrizione deve essere lungo minino 3 caratteri")
	@NotBlank(message = "La descrizione non può essere nulla")
	private String descrizione;
	
	@URL(protocol = "https")
	@NotBlank(message = "Url non può essere nullo")
	private String foto;
	
	@PositiveOrZero(message = "Puoi inserire solamente un numero positivo o uguale a 0") 
	private double prezzo;
	
	public Pizza() { }
	public Pizza(String nome, String descrizione, String foto, double prezzo) {
		
		setNome(nome);
		setDescrizione(descrizione);
		setFoto(foto);
		setPrezzo(prezzo);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getNome() + " - " 
				+ getFoto() + " (" + getPrezzo() + ")";
	}
}
