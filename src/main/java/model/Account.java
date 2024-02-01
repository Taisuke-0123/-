package model;

import java.time.LocalDate;

public class Account {
	private String userId;
	private String pass;
	private String petName;
	private String animals;
	private LocalDate petBd;
	
	public Account(String userId,String pass, String petName,String animals, LocalDate petBd) {
		this.userId = userId;
		this.pass = pass;
		this.petName = petName;
		this.animals = animals;
		this.petBd = petBd;
	}
	public String getUserId() {return userId;}
	public String getPass() {return pass;}
	public String getPetName() {return petName;}
	public String getAnimals() {return animals;}
	public LocalDate getPetBd() {return petBd;}
	

}
