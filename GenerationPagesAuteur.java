import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;


public class GenerationPagesAuteur
{
	public static void generer(String repertoire, ArrayList<Auteur> alAuteur, ArrayList<Jeu> alJeu)
	{
  		PrintWriter pw = null;
		int cptJeux;
		int tpsTotal=0;
		int tpsTotalMoy=0;
		//boucle qui s'active pour tout les auteurs
		for ( Auteur aut : alAuteur)
		{
			try{	pw = new PrintWriter ( new File ( "../" + repertoire + "/auteur/" + aut.getPrenomNom() + ".html"), "UTF-8" ); }
			catch (Exception e){e.printStackTrace();}
			//remet tout les compteur à zéro pour chaque auteurs
			cptJeux = 0;
			tpsTotalMoy=0;
			tpsTotal=0;
			//écriture en HTML
			pw.println ( "<!DOCTYPE html>");
			pw.println ( "<html>" );
			pw.println ( "\t<head>");
			pw.println ( "\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../Generateur/ressources/CSS/GenerationPages.css\" />");
			pw.println ("\t\t<meta charset=\"UTF-8\" lang=\"fr\"/>");
			pw.println ( "\t</head>");
			pw.println ( "\t<body>" );
			pw.println ("\t\t<header>\n\t\t\t<h1> Ludothèque du Havre </h1>\n\t\t\t<h2>" +aut.getPrenomNom() + "</h2>");
			pw.println ( "\t\t</header>" );
			pw.println ( "\t\t<nav>");
			pw.println ( "\t\t\t<a href=\"../index.html\"><img src=\"../../Generateur/ressources/images/logo/Logo.jpg\" height=\"200\" width=\"300\" alt=\"image vers accueil\"/></a>");
			pw.println ("\t\t</nav>");

				for ( Jeu jeux : alJeu)
				{
					//vérifie que les auteurs sont bien les auteurs du jeux
					if(aut.getPrenomNom().equals(jeux.getAuteur1().getPrenomNom()))
					{
						cptJeux++;
						pw.println("\t\t<article class=\"description\">");
						pw.println("\t\t\t<u>Numéro du jeu :</u> " + cptJeux + "<br/>");
						pw.println("\t\t\t<u>Titre du jeu :</u> " + jeux.getTitre() + "<br/>");
						pw.println("\t\t\t<u>Date de sortie :</u> " + jeux.getDateDeSortie() + "<br/>");
						pw.println("\t\t\t<u>Nombre minimum de joueur :</u> "	+ jeux.getNbJoueurMini() + "<br/>");
						pw.println("\t\t\t<u>Nombre maximum de joueur :</u> " + jeux.getNbJoueurMaxi() + "<br/>");
						pw.println("\t\t\t<u>Temps de jeu moyen :</u> " + jeux.getTempsMoyen() +" min"+ "<br/>");
						tpsTotal+=jeux.getTempsMoyen();
						pw.println("\t\t\t<u>Age minimum	:</u> " + jeux.getAgeMini() 	 +" ans"+ "<br/>");
						pw.println("\t\t\t<u>Catégorie 				:</u> " + jeux.getCategorie() 	 + "<br/>");
						pw.println("\t\t\t<u>Editeur 					:</u> " + jeux.getEditeur() 	 + "<br/>");
						//si le deuxième auteur n'existe pas il n'est pas écrit
						if(jeux.getAuteur2()!=null){pw.println("\t\t\t<u>Deuxieme auteur :</u> " 		 + jeux.getAuteur2() + "<br/>");}
						pw.println("\t\t</article>");
						pw.println ( "\t\t<article class=\"image\">");
						pw.println ( "\t\t\t<img src=\"../../Generateur/ressources/images/couvertures/" + jeux.getImage() + "\"/><br/>" );
						pw.println ( "\t\t</article>");
					}
					//permet de vérifié si l'auteur est le deuxième auteur du jeux 
					if(jeux.getAuteur2()!=null)
					{
						if(aut.getPrenomNom().equals(jeux.getAuteur2().getPrenomNom()))
						{
							cptJeux++;
							pw.println("\t\t<article class=\"description\">");
							pw.println("\t\t\t<u>Numéro du jeu 			:</u> " + cptJeux + "<br/>");
							pw.println("\t\t\t<u>Titre du jeu 			:</u> " 		+ jeux.getTitre() 		 + "<br/>");
							pw.println("\t\t\t<u>Date de sortie 			:</u> " 		+ jeux.getDateDeSortie() + "<br/>");
							pw.println("\t\t\t<u>Nombre minimum de joueur :</u> " 		+ jeux.getNbJoueurMini() + "<br/>");
							pw.println("\t\t\t<u>Nombre maximum de joueur :</u> " 		+ jeux.getNbJoueurMaxi() + "<br/>");
							pw.println("\t\t\t<u>Temps de jeu moyen :		</u>  " 		+ jeux.getTempsMoyen() 	 +" min"+ "<br/>");
							tpsTotal+=jeux.getTempsMoyen();
							pw.println("\t\t\t<u>Age minimum :			</u>  " 		+ jeux.getAgeMini() 	 +" ans"+ "<br/>");
							pw.println("\t\t\t<u>Catégorie :				</u>  " 		+ jeux.getCategorie() 	 + "<br/>");
							pw.println("\t\t\t<u>Editeur :				</u>  " 		+ jeux.getEditeur() 	 + "<br/>");
							pw.println("\t\t\t<u>Premier auteur :</u> "					+ jeux.getAuteur1() 	 + "<br/>");
							pw.println("\t\t</article>");
							pw.println ( "\t\t<article class=\"image\">");
							pw.println ( "\t\t\t<img src=\"../../Generateur/ressources/images/couvertures/"+ jeux.getImage() +"\"  alt=\"image du jeu\" 	/><br/>" );
							pw.println ( "\t\t</article>");
						}
					}
				}
			//calcule du temps moyen des jeux de l'auteur
			tpsTotalMoy=tpsTotal/cptJeux;
			pw.println ("\t\t<footer>" );
			pw.println ( "\t\t\t<u>Nombre(s) de jeux de l'auteur sur notre site  :</u> " + cptJeux );
			pw.println ("\t\t\t</br>");
			pw.println ( "\t\t\t<u>Temps moyen total des jeux de l'auteur :</u> " + tpsTotalMoy +" min" );
			pw.println ("\t\t\t</br>");
			pw.println ("\t\t\t<u>Groupe :</u>© Small World " );
			pw.println ("\t\t\t</br>");
			pw.println ("\t\t\t<u>Membres :</u> <p>Barton Mathieu | De Carvalho Alexandre | Dubuc Lucas | Duchemin Julien | Vero Nicolas");
			pw.println ("\t\t</footer>" );
			pw.println ( "\t<body>" );
			pw.println ( "</html>" );
			pw.close();
		}
  	}
}