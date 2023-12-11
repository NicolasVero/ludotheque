import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.nio.file.Files;

public class GenerationPagesEditeur {
	public static void generer(String repertoire, ArrayList<Editeur> alEditeur, ArrayList<Categorie> alCategorie, ArrayList<Jeu> alJeu) {

		PrintWriter pw = null;

		// Boucle qui s'active pour tous les éditeurs
		for(Editeur edi : alEditeur) {
			try {	
				pw = new PrintWriter(new File("../" + repertoire + "/editeur/" + edi.getNom() + ".html"), "utf-8"); 
			} catch (Exception e) {
				e.printStackTrace();
			}

			int[] nbrCat = new int[alCategorie.size()];

			// Tableau de compteur des catégories initilisé à 0 
			for (int i = 0; i < nbrCat.length; i++) 
				nbrCat[i] = 0;
	
			// Ecriture de l'HTML
			pw.println ("<!DOCTYPE html>");
			pw.println ("<html>");
			pw.println ("<head>");
			pw.println ("<meta charset=\"UTF-8\" lang=\"fr\"/>");
			pw.println ("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../Generateur/ressources/CSS/GenerationPages.css\" />");
			pw.println ("</head>");
			pw.println ("<body>");
			pw.println ("<header>\n<h1> Ludothèque du Havre </h1>\n<h2>" + edi.getNom() + "</h2>");
			pw.println ("</header>");
			pw.println ("<nav>");
			pw.println ("<a href=\"../index.html\"><img src=\"../../Generateur/ressources/images/logo/Logo.jpg\" height=\"150\" width=\"250\" alt=\"image vers accueil\"/></a>");
			pw.println ("</nav>");
			pw.println ("<img class=\"img\" src=\"../../Generateur/ressources/images/editeurs/" + edi.getLogo() + "\"/><br/>");
	
			int lin = 0;
			for(Categorie cat : alCategorie) {
				
				int categorie = 0;
				for (Jeu jeux : alJeu) {
					
					// Vérifie si l'éditeur est l'éditeur du jeu
					if(edi.getNom().equals(jeux.getEditeur().getNom())) {
						// Permet de savoir à quelle catégorie appartient le jeu
						if(cat.equals(jeux.getCategorie())) {
							// Permet d'afficher une seule fois la catégorie
							if(categorie == 0) {
								pw.println("<article class=\"center\">");
								pw.println("<h2><u>Catégorie :</u> " + cat.toString() +"</h2>");
								pw.println("</article>");
								categorie++;
							}

							pw.println("<article class=\"description\">");
							pw.println("<u>Titre du jeu :</u>"             + jeux.getTitre() 		+ "<br/>");
							pw.println("<u>Date de sortie :</u>"           + jeux.getDateDeSortie() + "<br/>");
							pw.println("<u>Nombre minimum de joueur :</u>" + jeux.getNbJoueurMini() + "<br/>");
							pw.println("<u>Nombre maximum de joueur :</u>" + jeux.getNbJoueurMaxi() + "<br/>");
							pw.println("<u>Temps de jeu moyen :</u>"       + jeux.getTempsMoyen()   + " min" + "<br/>");
							pw.println("<u>Catégorie :</u>"                + jeux.getCategorie() 	+ "<br/>");
							pw.println("<u>Age minimum :</u>" 			   + jeux.getAgeMini() 	    + " ans" + "<br/>");
							pw.println("<u>Premier auteur :</u>" 		   + jeux.getAuteur1() 	    + "<br/>");
							
							// Vérifie si un deuxième auteur existe
							if(jeux.getAuteur2()!=null)
								pw.println("<u>Deuxième auteur :</u> " +jeux.getAuteur2() + "<br/>");

							pw.println("</article>");
							pw.println("<article class=\"image\">");
							pw.println("<img src=\"../../Generateur/ressources/images/couvertures/" + jeux.getImage() + "\"/><br/>");
							pw.println("</article>");

							nbrCat[lin] = nbrCat[lin] + 1;
						}
					}
				}
				categorie=0;
				lin++;
			}

			pw.println("<footer>");

			// Affiche le compteur des catégories
			for(int i = 0; i < nbrCat.length; i++)
				pw.print(""+alCategorie.get(i)+": " +nbrCat[i]+"&emsp;");
			
			pw.println ("</br>");
			pw.println ("</br>");
			pw.println ("<u>Groupe :</u>© Small World");
			pw.println ("</br>");
			pw.println ("</br>");
			pw.println ("<u>Membres :</u> <p>Barton Mathieu | De Carvalho Alexandre | Dubuc Lucas | Duchemin Julien | Vero Nicolas");
			pw.println ("</footer>");
			pw.println ("</body>");
			pw.println ("</html>");
			pw.close();
		}
  	}
}