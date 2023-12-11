import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;

public class GenerationPagesAuteur {
	public static void generer(String repertoire, ArrayList<Auteur> alAuteur, ArrayList<Jeu> alJeu) {
  		
		PrintWriter pw = null;
		int cptJeux;
		int tpsTotal = 0;
		int tpsTotalMoy = 0;

		// Boucle qui s'active pour tous les auteurs
		for(Auteur aut : alAuteur) {
			
			try{	
				pw = new PrintWriter(new File( "../" + repertoire + "/auteur/" + aut.getPrenomNom() + ".html"), "UTF-8"); 
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Remet tous les compteurs à zéro pour chaque auteur
			cptJeux = 0;
			tpsTotalMoy = 0;
			tpsTotal = 0;
			
			// Ecriture en HTML
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../Generateur/ressources/CSS/GenerationPages.css\" />");
			pw.println("<meta charset=\"UTF-8\" lang=\"fr\"/>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<header>\n<h1>Ludothèque du Havre</h1>\n<h2>" + aut.getPrenomNom() + "</h2>");
			pw.println("</header>");
			pw.println("<nav>");
			pw.println("<a href=\"../index.html\"><img src=\"../../Generateur/ressources/images/logo/Logo.jpg\" height=\"200\" width=\"300\" alt=\"image vers accueil\"/></a>");
			pw.println("</nav>");

			for(Jeu jeux : alJeu) {
				// Vérifie que les auteurs sont bien les auteurs du jeux
				if(aut.getPrenomNom().equals(jeux.getAuteur1().getPrenomNom())) {
					
					cptJeux++;
					tpsTotal += jeux.getTempsMoyen();

					pw.println("<article class=\"description\">");
					pw.println("<u>Numéro du jeu :</u>"            + cptJeux                + "<br/>");
					pw.println("<u>Titre du jeu :</u>"             + jeux.getTitre()        + "<br/>");
					pw.println("<u>Date de sortie :</u>"           + jeux.getDateDeSortie() + "<br/>");
					pw.println("<u>Nombre minimum de joueur :</u>" + jeux.getNbJoueurMini() + "<br/>");
					pw.println("<u>Nombre maximum de joueur :</u>" + jeux.getNbJoueurMaxi() + "<br/>");
					pw.println("<u>Temps de jeu moyen :</u>"       + jeux.getTempsMoyen()   + " min" + "<br/>");
					pw.println("<u>Age minimum :</u>"              + jeux.getAgeMini() 	    + " ans" + "<br/>");
					pw.println("<u>Catégorie :</u>"                + jeux.getCategorie() 	+ "<br/>");
					pw.println("<u>Editeur :</u>"                  + jeux.getEditeur() 	    + "<br/>");

					// Si le deuxième auteur n'existe pas, il n'est pas écrit
					if(jeux.getAuteur2() != null) 
						pw.println("<u>Deuxieme auteur :</u> " + jeux.getAuteur2() + "<br/>");
					
					pw.println("</article>");
					pw.println("<article class=\"image\">");
					pw.println("<img src=\"../../Generateur/ressources/images/couvertures/" + jeux.getImage() + "\"/><br/>");
					pw.println("</article>");
				}

				// Permet de vérifier si l'auteur est le deuxième auteur du jeu
				if(jeux.getAuteur2() != null) {
					if(aut.getPrenomNom().equals(jeux.getAuteur2().getPrenomNom())) {
						
						cptJeux++;
						tpsTotal += jeux.getTempsMoyen();

						pw.println("<article class=\"description\">");
						pw.println("<u>Numéro du jeu :</u>"            + cptJeux                + "<br/>");
						pw.println("<u>Titre du jeu :</u>" 			   + jeux.getTitre() 		+ "<br/>");
						pw.println("<u>Date de sortie :</u>" 		   + jeux.getDateDeSortie() + "<br/>");
						pw.println("<u>Nombre minimum de joueur :</u>" + jeux.getNbJoueurMini() + "<br/>");
						pw.println("<u>Nombre maximum de joueur :</u>" + jeux.getNbJoueurMaxi() + "<br/>");
						pw.println("<u>Temps de jeu moyen :</u>" 	   + jeux.getTempsMoyen()   + " min" + "<br/>");
						pw.println("<u>Age minimum :</u>" 		       + jeux.getAgeMini() 	    + " ans" + "<br/>");
						pw.println("<u>Catégorie :</u>" 			   + jeux.getCategorie() 	+ "<br/>");
						pw.println("<u>Editeur :</u>" 				   + jeux.getEditeur() 	    + "<br/>");
						pw.println("<u>Premier auteur :</u> "		   + jeux.getAuteur1() 	    + "<br/>");
						pw.println("</article>");
						pw.println("<article class=\"image\">");
						pw.println("<img src=\"../../Generateur/ressources/images/couvertures/" + jeux.getImage() + "\"  alt=\"image du jeu\" 	/><br/>");
						pw.println("</article>");
					}
				}
			}

			// Calcul du temps moyen des jeux de l'auteur
			tpsTotalMoy = tpsTotal / cptJeux;

			pw.println("<footer>");
			pw.println("<u>Nombre(s) de jeux de l'auteur sur notre site :</u>" + cptJeux);
			pw.println("</br>");
			pw.println("<u>Temps moyen total des jeux de l'auteur :</u>" + tpsTotalMoy + " min");
			pw.println("</br>");
			pw.println("<u>Groupe :</u>© Small World");
			pw.println("</br>");
			pw.println("<u>Membres :</u> <p>Barton Mathieu | De Carvalho Alexandre | Dubuc Lucas | Duchemin Julien | Vero Nicolas");
			pw.println("</footer>");
			pw.println("<body>");
			pw.println("</html>");
			pw.close();
		}
  	}
}