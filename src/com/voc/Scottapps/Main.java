package com.voc.Scottapps;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Dico dico = new Dico();
		Scanner clavier = new Scanner(System.in);
		String nom, def, nature, dec, article;char type, genre, lettre;
		boolean continuer = true;
		Mot motuser;
		int mode = 0;
		while (continuer){
			mode = 0;
			clearConsole();
			System.out.println("\tEntre:\n1.ajouter un mot au repertoire\n2.chercher un mot\n3.afficher tout les mot commençant par...\n4.supprimer un mot du repertoire\n5.quitter");
			mode = clavier.nextInt();
			if (mode == 1){
				System.out.print("\nEntre son nom:");
				clavier.nextLine();
				nom = clavier.nextLine();
				System.out.print("\nEntre son type(F/L):");
				type = clavier.nextLine().charAt(0);
				
				if (type == 'F'){
					System.out.print("\nEntre la nature du mot:");
					nature = clavier.nextLine();
					nature.toLowerCase();
					System.out.print("\nEntre la definition du mot (mettez des underscores \"_\" pour les sauts de lignes):");
					def = clavier.nextLine();
					def = Dico.cvLn(def);
					if (nature.contains("nom")){
						System.out.print("\nEntre l'article du mot:");
						article = clavier.nextLine();
						motuser = new Mfran(nom, nature, def, article);
					}else{
					motuser = new Mfran(nom, nature, def);
					}
					if (dico.contains(motuser)){
						System.out.println("ce mot existe deja le voici:");
						dico.chrMot(motuser);
					}else{
					System.out.println("\nVoici votre mot:\n"+motuser.toString());
					dico.addMot(motuser);
					}
				}
				if (type == 'L'){
					System.out.print("\nEntre la declinaison du mot:");
					dec = clavier.nextLine();
					System.out.print("\nEntre la definition du mot:");
					def = clavier.nextLine();
					System.out.print("\nEntre le genre du mot:");
					genre = clavier.nextLine().charAt(0);
					motuser = new Mlat(nom, def, dec, genre);
					System.out.println("\nVoici votre mot:\n"+motuser.toString());
					dico.addMot(motuser);	
				}
			}
			
			if (mode == 2){
				System.out.print("\nEntre le mot a chercher:");
				clavier.nextLine();
				nom = clavier.nextLine();
				System.out.println("");
				motuser = new Mlat(nom);
				dico.chrMot(motuser);
			}
			
			if (mode == 3){
				System.out.print("\nEntre la lettre de reference:");
				clavier.nextLine();
				lettre = clavier.nextLine().charAt(0);
				dico.chrLettre(lettre);
			}
			
			if (mode == 4){
				System.out.print("\nEntre le mot a supprimer:");
				clavier.nextLine();
				nom = clavier.nextLine();
				motuser = new Mfran(nom);
				dico.delMot(motuser);
			}
			
			if (mode  == 5) continuer = false;
		}
		clavier.close();
	}
	
	public static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e){}
	}
}
