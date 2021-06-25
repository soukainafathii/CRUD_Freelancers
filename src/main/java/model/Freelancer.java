package model;

import java.io.Serializable;

public class Freelancer implements Serializable {
 private int id;
 private String nom, prenom, email;
 private String nb_annees_exp;
 private String competences;
 
 
public Freelancer() {
	super();
}


public Freelancer(String nom, String prenom, String email, String nb_annees_exp, String competences) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.nb_annees_exp = nb_annees_exp;
	this.competences = competences;
}


public Freelancer(int id, String nom, String prenom, String email, String nb_annees_exp, String competences) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.nb_annees_exp = nb_annees_exp;
	this.competences = competences;
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


public String getNb_annees_exp() {
	return nb_annees_exp;
}


public void setNb_annees_exp(String string) {
	this.nb_annees_exp = string;
}


public String getCompetences() {
	return competences;
}


public void setCompetences(String competences) {
	this.competences = competences;
}
 
 


}
