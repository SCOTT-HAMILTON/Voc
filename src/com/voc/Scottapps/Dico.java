package com.voc.Scottapps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Dico {
	private FileInputStream fichierI;
	private FileOutputStream fichierO;
	private byte buff[] = new byte[1];
	
	public Dico(){
	}
	
	public boolean isEmpty(){
		try{
		fichierI.reset();
		if (fichierI.read(buff) == -1)return true;
		else return false;
		}catch (IOException e){
			return false;
		}
	}
	
	public void addMot(Mot mot){
		String sep = System.getProperty("file.separator");
		int nbrSaut = 0;
			try{
				String debut = "";
				buff = new byte[1];
				//debut
				int taille = 0;
				String temp = mot.toString(); 
				for (int i = 0; i < mot.length(); i++){
					if (temp.charAt(i) == '\n') nbrSaut++;
				}
				FileInputStream fichier = null;
				try{
				fichier = new FileInputStream(new File("repertoire"+sep+mot.getNom().charAt(0)+".txt"));
				}catch(IOException e){}
				int t = 0;
				do{
					t = fichier.read(buff);
					debut += (char) buff[0];
					taille++;
				}while(t != -1);
				fichierO = new FileOutputStream(new File("repertoire"+sep+mot.getNom().charAt(0)+".txt"));
				buff = new byte[mot.length()+taille+nbrSaut];
				int i = 0;
				for (i = 0; i < debut.length(); i++){
					buff[i] = (byte) debut.charAt(i);
				}

				//suite
				int j = i;
				for (i = 0; i < mot.length(); i++){
					if (temp.charAt(i) == '\n'){
						buff[j] = 13;
						buff[j+1] = 10;
						j++;
					}else{
						buff[j] = (byte) temp.charAt(i);
					}
					j++;
				}
				fichierO.write(buff);
			}catch(IOException e){}
	}
	public void chrLettre(char lettre){
		if (java.lang.Character.isUpperCase(lettre)){
			lettre = java.lang.Character.toLowerCase(lettre);
		}
		byte buff[] = new byte[1];
		String sep = System.getProperty("file.separator");
		try{
			fichierI = new FileInputStream(new File("repertoire"+sep+lettre+".txt"));
			int i = 0;
			for(i = 0; fichierI.read(buff) != -1; i++){
				System.out.print((char)buff[0]);
			}
			if (i == 0) System.out.println("Ce fichier est vide.");
		}catch(IOException e){}
	}
	public void chrMot(Mot mot){
		String sep = System.getProperty("file.separator");
		String temp = "";
		String suite = "";
		int nbrSaut = 0;
		boolean contains = false;
		try{
			fichierI = new FileInputStream(new File("repertoire"+sep+mot.getNom().charAt(0)+".txt"));
			int t = 0;
			buff = new byte[1];
			buff[0] = 0;
			
			while (t != -1){
				temp = "";
				do{
					t = fichierI.read();
					temp += (char) t;
				}while (t != 10 && t != -1);
				if (temp.contains(mot.getNom())){
					contains = true;
					t = 0;
					suite = "";
					while (nbrSaut < 2 && t != -1){
						t = fichierI.read();
						if (t == 10) nbrSaut++;
						else nbrSaut = 0;
						if (t != -1){
							suite += (char)t;
						}
					}
					System.out.println(temp+suite);
					t = -1;
				}
			}
			
			
		}catch(IOException e){}
		finally{
			if (!contains){
				System.out.println("Ce mot n'est pas dans le repertoire. Vous pouvez l'ajouter.");
			}
		}
	}
	
	public void delMot(Mot mot){
		String sep = System.getProperty("file.separator");
		String temp = "";
		String result = "";
		int nbrSaut = 0;
		boolean contains = false;
		try{
			fichierI = new FileInputStream(new File("repertoire"+sep+mot.getNom().charAt(0)+".txt"));
			int t = 0;
			buff = new byte[1];
			buff[0] = 0;
			
			while (t != -1){
				temp = "";
				do{
					t = fichierI.read();
					if (t != -1){
					temp += (char) t;
					}
				}while (t != 10 && t != -1);
				if (temp.contains(mot.getNom())){
					contains = true;
					while (nbrSaut < 2 && t != -1){
						t = fichierI.read();
						if (t == 10) nbrSaut++;
						else nbrSaut = 0;
					}
				}else{
					result += temp; 
				}
			}
			buff = new byte[result.length()+1];

			for (int i = 0; i < result.length(); i++){
				buff[i] = (byte) result.charAt(i);
			}
			fichierO = new FileOutputStream(new File("repertoire"+sep+mot.getNom().charAt(0)+".txt"));
			fichierO.write(buff);
		}catch(IOException e){}
		finally{
			if (!contains){
				System.out.println("Ce mot n'est pas dans le repertoire. Vous pouvez l'ajouter.");
			}
			else{
				System.out.println("le mot a bien ete supprimer.");
			}
		}
	}
	
	public boolean contains(Mot mot){
		String sep = System.getProperty("file.separator");
		String temp = "";
		String result = "";
		int nbrSaut = 0;
		boolean contains = false;
		try{
			fichierI = new FileInputStream(new File("repertoire"+sep+mot.getNom().charAt(0)+".txt"));
			int t = 0;
			buff = new byte[1];
			buff[0] = 0;
			
			while (t != -1 && !contains){
				temp = "";
				do{
					t = fichierI.read();
					temp += (char) t;
				}while (t != 10 && t != -1);
				if (temp.contains(mot.getNom())){
					contains = true;
				}
			}
		}catch(IOException e){}
		if (!contains){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static String cvLn(String texte){
		char temp;
		String result = "";
		for (int i = 0; i < texte.length(); i++){
			if (texte.charAt(i) == '_'){
				System.out.println("oui");
				temp = '\n';
			}
			else{
				temp = texte.charAt(i);
			}
			result += temp;
		}
		return result;
	}
	
	public static String cvLn2(String texte){
		char temp;
		String result = "";
		char ln = System.getProperty("line.separator").charAt(0);
		for (int i = 0; i < texte.length(); i++){
			if (texte.charAt(i) == '_'){
				System.out.println("oui");
				temp = ln;
			}
			else{
				temp = texte.charAt(i);
			}
			result += temp;
		}
		return result;
	}
	
}

