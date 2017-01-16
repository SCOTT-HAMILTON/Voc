package com.voc.Scottapps;

public class Mlat extends Mot{
	private String nom; 
	private String  def;
	private String dec;
	private char genre;

	public Mlat(String nom, String def, String dec, char genre){
		this.nom = nom;
		this.def = def;
		this.dec = dec;
		this.genre = genre;
		nom.toLowerCase();
	}
	
	public Mlat(String nom){
		this.nom = nom;
	}
	
	public int length(){
		String taille = this.toString();
		return taille.length();
	}
	
	public String toString(){
		String lnsep = System.getProperty("line.separator");
		return nom+", "+dec+", "+genre+":"+lnsep+def+lnsep+lnsep;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
