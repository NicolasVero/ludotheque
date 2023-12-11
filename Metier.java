import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import iut.algo.Decomposeur;


public class Metier {

	private ArrayList<Categorie> alCategorie;
	private ArrayList<Editeur>   alEditeur;

	private ArrayList<Auteur>    alAuteur;
	private ArrayList<Jeu>       alJeu;


	public Metier() {
		initCategorie();
		initEditeur();

		initAuteur();
		initJeu();
	}

	private void initCategorie() {
		
		alCategorie = new ArrayList<Categorie> ();

		try {
			Scanner scFic = new Scanner(new File("./ressources/data/categorie.data" ), "utf-8");

			while(scFic.hasNextLine())
				alCategorie.add(new Categorie(scFic.nextLine()));
		
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
	}


	private void initEditeur() {

		String nom, logo;
		Decomposeur dec;

		alEditeur = new ArrayList<Editeur> ();

		try {
			Scanner scFic = new Scanner(new File("./ressources/data/editeur.data" ), "utf-8");

			while(scFic.hasNextLine()) {
				dec = new Decomposeur(scFic.nextLine());
				alEditeur.add(new Editeur(dec.getString(0), dec.getString(1)));
			}
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
	}

	private void initAuteur() {

		Scanner     scFic;
		Decomposeur dec;
		String      prenomNom;

		alAuteur = new ArrayList<Auteur>();

		try {
			scFic = new Scanner(new File("./ressources/data/jeu.data"), "utf-8");

			while(scFic.hasNextLine()) {
				dec = new Decomposeur(scFic.nextLine());

				// Récupération du premier Auteur (toujours renseigné)
				prenomNom = dec.getString(3);

				if(this.rechercherAuteur(prenomNom) == null)
					alAuteur.add(new Auteur(prenomNom));

				// Récupération du deuxième Auteur (rarement renseigné)
				prenomNom = dec.getString(4);

				if(!prenomNom.equals("") && this.rechercherAuteur(prenomNom) == null)
					alAuteur.add(new Auteur(prenomNom));
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	private void initJeu() {

		Scanner     scFic;
		Decomposeur dec;

		// Variables intermédiaires pour créer un Auteur
		Categorie categorie;
		Auteur    auteur1, auteur2;
		Editeur   editeur;
		String    titre, dateDeSortie, image;
		int       nbJoueurMini, nbJoueurMaxi, tempsMoyen, ageMini;

		// A chaque que l'on récupère un nouveau nom  d'auteur, il  faut
		// vérifier qu'il ne se trouve pas déjà dans alAuteur.
		// On part du principe qu'il y a pas d'homonyme sur nom et prénom

		this.alJeu = new ArrayList<Jeu>();

		try {
			scFic = new Scanner(new File("./ressources/data/jeu.data"), "utf-8");

			while(scFic.hasNextLine()) {
				dec = new Decomposeur(scFic.nextLine());

				categorie    = this.rechercherCategorie( dec.getChar   ( 0));
				titre        =                           dec.getString ( 1); 
				dateDeSortie =                           dec.getString ( 2); 
				auteur1      = this.rechercherAuteur   ( dec.getString ( 3));
				auteur2      = this.rechercherAuteur   ( dec.getString ( 4));
				editeur      = alEditeur.get           ( dec.getInt    ( 5) -1 );
				nbJoueurMini =                           dec.getInt    ( 6);
				nbJoueurMaxi =                           dec.getInt    ( 7);
				tempsMoyen   =                           dec.getInt    ( 8);
				ageMini      =                           dec.getInt    ( 9);
				image        =                           dec.getString (10);

				alJeu.add(new Jeu (categorie, titre, dateDeSortie, auteur1, auteur2, editeur, nbJoueurMini,nbJoueurMaxi, tempsMoyen, ageMini, image));
			}
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	}

	private Auteur rechercherAuteur(String prenomNom) {                                                    
		for(Auteur aut : alAuteur)
			if(aut.getPrenomNom().equals(prenomNom)) 
				return aut;

		return null;
	}

	private Categorie rechercherCategorie(char initial) {                                                     
		for(Categorie cat : alCategorie)
			if(cat.getLibelle().charAt(0) == initial) 
				return cat;

		return null;
	}

	public void genererPages( String repDest) {                                                     
		try {
			if(!Files.exists(Paths.get("../" + repDest)))
				Files.createDirectory(Paths.get("../" + repDest));

			if(!Files.exists(Paths.get("../" + repDest + "/auteur")))
				Files.createDirectory(Paths.get("../" + repDest + "/auteur"));
			
			if(!Files.exists(Paths.get("../" + repDest + "/editeur")))
				Files.createDirectory(Paths.get("../" + repDest + "/editeur"));
		
		} catch(Exception e) { 
			e.printStackTrace(); 
		}

		GenerationPageAccueil.generer(repDest, alAuteur, alEditeur );
		GenerationPagesAuteur.generer(repDest, alAuteur, alJeu);
		GenerationPagesEditeur.generer(repDest, alEditeur,alCategorie, alJeu);
	}

	public String toString() {

		String sRet = "Categorie\n";

		for(Categorie cat : alCategorie)
			sRet += cat.toString() + "\n";

		sRet += "\nEditeur\n";

		for(Editeur ed : alEditeur)
			sRet += ed.toString() + "\n";

		sRet += "\nAuteur\n";

		for(Auteur aut : alAuteur)
			sRet += aut.toString() + "\n";

		sRet += "\nJeu\n";

		for(Jeu jeu : alJeu)
			sRet += jeu.toString() + "\n";

		return sRet;
	}
}