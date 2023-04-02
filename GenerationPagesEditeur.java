import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.nio.file.Files;

public class GenerationPagesEditeur
{
	public static void generer(String repertoire, ArrayList<Editeur> alEditeur,ArrayList<Categorie> alCategorie , ArrayList<Jeu> alJeu)
	{
		PrintWriter pw = null;
		//boucle qui s'active pour tous les éditeurs
		for ( Editeur edi : alEditeur)
		{
			try{	pw = new PrintWriter ( new File ( "../" + repertoire + "/editeur/" + edi.getNom() + ".html"), "utf-8" ); }
			catch (Exception e){e.printStackTrace();}
			int[] nbrCat=new int[alCategorie.size()];
			//tableau de compteur des catégories initiliser à 0 
			for (int i = 0; i < nbrCat.length; i++)
			{
				nbrCat[i]=0;
			}
			//écriture de l'HTML
			pw.println ( "<!DOCTYPE html>");
			pw.println ( "<html>" );
			pw.println ( "\t<head>");
			pw.println ("\t\t<meta charset=\"UTF-8\" lang=\"fr\"/>");
			pw.println ( "\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../Generateur/ressources/CSS/GenerationPages.css\" />");
			pw.println ( "\t</head>");
			pw.println ( "\t<body>" );
			pw.println ("\t\t<header>\n\t\t\t<h1> Ludothèque du Havre </h1>\n\t\t\t<h2>"+edi.getNom()+"</h2>");
			pw.println ( "\t\t</header>" );
			pw.println ( "\t\t<nav>");
			pw.println ( "\t\t\t<a href=\"../index.html\"><img src=\"../../Generateur/ressources/images/logo/Logo.jpg\" height=\"150\" width=\"250\" alt=\"image vers accueil\"/></a>");
			pw.println ("\t\t</nav>");
			pw.println ( "\t\t<img class=\"img\" src=\"../../Generateur/ressources/images/editeurs/" +edi.getLogo() + "\"/><br/>" );
			int lin=0;
			for (Categorie cat : alCategorie)
			{
				int categorie=0;
				for ( Jeu jeux : alJeu)
				{
					//vérifie si l'éditeur est l'éditeur du jeux
					if(edi.getNom().equals(jeux.getEditeur().getNom()))
					{
						//permet de savoir à quelle catégorie appartient le jeux
						if(cat.equals(jeux.getCategorie()))
						{
							//permet d'affiché une seule fois la catégorie
							if(categorie==0)
							{
								pw.println("\t\t<article class=\"center\">");
								pw.println("\t\t\t<h2><u>Catégorie :</u> " + cat.toString() +"</h2>");categorie++;
								pw.println ("\t\t</article>");
							}
							pw.println("\t\t<article class=\"description\">");
							pw.println("\t\t\t<u>Titre du jeu 			:</u> " + jeux.getTitre() 		 + "<br/>");
							pw.println("\t\t\t<u>Date de sortie 			:</u> " + jeux.getDateDeSortie() + "<br/>");
							pw.println("\t\t\t<u>Nombre minimum de joueur :</u> " + jeux.getNbJoueurMini() + "<br/>");
							pw.println("\t\t\t<u>Nombre maximum de joueur :</u> " + jeux.getNbJoueurMaxi() + "<br/>");
							pw.println("\t\t\t<u>Temps de jeu moyen 		:</u>  " + jeux.getTempsMoyen() 	 +" min"+ "<br/>");
							pw.println("\t\t\t<u>Catégorie		:</u>  " + jeux.getCategorie() 	 + "<br/>");
							pw.println("\t\t\t<u>Age minimum 				:</u>  " + jeux.getAgeMini() 	 +" ans"+ "<br/>");
							pw.println("\t\t\t<u>Premier auteur 			:</u>  " + jeux.getAuteur1() 	 + "<br/>");
							//vérifie si un deuxième auteur existe
							if(jeux.getAuteur2()!=null){pw.println("\t\t\t<u>Deuxième auteur :</u> " +jeux.getAuteur2() + "<br/>");}
							pw.println("\t\t</article>");
							pw.println ( "\t\t<article class=\"image\">");
							pw.println ( "\t\t\t<img src=\"../../Generateur/ressources/images/couvertures/" +jeux.getImage() + "\"/><br/>" );
							pw.println("\t\t</article>");
							//compteur de catégorie
							nbrCat[lin]=nbrCat[lin]+1;
						}
					}
				}
				categorie=0;
				lin++;
			}
			pw.println ("\t\t<footer>" );
			//affiche le compteur des catégories
			for (int i = 0; i < nbrCat.length; i++)
			{
				pw.print("\t\t\t"+alCategorie.get(i)+": " +nbrCat[i]+"&emsp;");
			}
			pw.println ("</br>");
			pw.println ("\t\t\t</br>");
			pw.println ("\t\t\t<u>Groupe :</u>© Small World " );
			pw.println ("\t\t\t</br>");
			pw.println ("\t\t\t</br>");
			pw.println ("\t\t\t<u>Membres :</u> <p>Barton Mathieu | De Carvalho Alexandre | Dubuc Lucas | Duchemin Julien | Vero Nicolas");
			pw.println ("\t\t</footer>" );
			pw.println ( "\t</body>" );
			pw.println ( "</html>" );
			pw.close();
		}
  	}
}