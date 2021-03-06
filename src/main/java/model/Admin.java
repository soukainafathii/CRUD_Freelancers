package model;

import java.io.Serializable;

public class Admin implements Serializable{
	
private int id;
private String nom,prenom,email,password;

public Admin() {
	super();
}

public Admin(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}

public Admin(int id, String nom, String prenom, String email, String password) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



}
