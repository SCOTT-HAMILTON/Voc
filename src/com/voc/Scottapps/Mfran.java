package com.voc.Scottapps;

public class Mfran extends Mot{
	private String nom; 
	private String nat;
	private String def;
	private String article;
	
	public Mfran(String nom, String nat, String def){
		this.nom = nom;
		this.nat = nat;
		this.def = def;
		this.article = "rien";
	}
	
	public Mfran(String nom, String nat, String def, String article){
		this.nom = nom;
		this.nat = nat;
		this.def = def;
		this.article = article;
	}
	
	public Mfran(String nom){
		this.nom = nom;
	}
	
	public int length(){
		String taille = this.toString();
		return taille.length();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString(){
		String lnsep = System.getProperty("line.separator");
		String result = "";
		if (this.article == "rien"){
			result = nom+"("+nat+"):"+lnsep+def+lnsep+lnsep;
		}else{
			result = this.article+" "+nom+"("+nat+"):"+lnsep+def+lnsep+lnsep;
		}
		return result;
	}
	
}
