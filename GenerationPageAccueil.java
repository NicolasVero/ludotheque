import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;



public class GenerationPageAccueil
{
    public static void generer( String repertoire, ArrayList<Auteur> alAuteur, ArrayList<Editeur> alEditeur)
    {
        PrintWriter pw = null;
        //compteurs des tableaux 
        int cptBr=0;
        int cptBr1=1;
        try{    pw = new PrintWriter ( new File ( "../" + repertoire + "/index.html" ), "utf-8"); }
        catch (Exception e){e.printStackTrace();}
        //écriture en HTML
        pw.println ( "<!DOCTYPE html>");
        pw.println ( "<html>\n\t<head>\n\t\t<meta charset=\"UTF-8\" lang=\"fr\"/>" );
        pw.println ( "\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../Generateur/ressources/CSS/GenerationPages.css\" />");
        pw.println ( "\t</head>");
        pw.println ( "\t<body>" );
        pw.println ( "\t\t<header>\n\t\t\t<img class=\"logo\" src=\"../Generateur/ressources/images/logo/Logo.jpg\" height=\"100%\" width=\"10%\" alt=\"image vers accueil\"/>" );
        pw.println ( "\t\t\t<h1>Ludothèque du Havre :</h1>");
        pw.println ( "\t\t\t<h3>&nbsp;Vous pourrez trouver ici tous ce que vous propose notre ludothèque en passant par les auteurs et les éditeurs de jeux de sociétés</h3>");
        pw.println ( "\t\t</header>");
        pw.println ("\t\t<article class=\"center\">");
        pw.println ("\t\t\t<h2>Auteurs :</h2>");
        pw.println ("\t\t</article>");
        pw.println ("\t\t<article class=\"auteur\">");
        pw.println ("\t\t\t<table>");
        //boucle qui s'active tout les auteurs
        for ( Auteur aut : alAuteur )
        {
            //permet de faire un tableau de tout les auteurs présents
            if(cptBr%8==0 ){pw.println("\t\t\t\t<tr>");}
            pw.println ( "\t\t\t\t\t<td><a class=\"auteur\" href=\"../"+ repertoire  +"/auteur/" + aut.getPrenomNom() +".html\">" + aut.getPrenomNom() + "</a>&emsp;&emsp;</td>");
            cptBr++;
            if(cptBr%8==0){pw.println("\t\t\t\t</tr>");}
        }
        pw.println("\t\t\t</table>");
		pw.println ("\t\t</article>");
        pw.println("\t\t<article class=\"center\">");
        pw.println("\t\t\t<h2>Editeurs :</h2>");
        pw.println("\t\t</article>");
        pw.println("\t\t<article class=\"editeur\">");
        pw.println("\t\t\t<table>");
        //boucle qui prend tout les auteurs
        for ( Editeur edi : alEditeur )
        {
            //permet de faire un tableau de tout les éditeurs présents
            if(cptBr1%5==1 ){pw.println("\t\t\t\t<tr>");}
            pw.println ( "\t\t\t\t\t<td>\n\t\t\t\t\t\t<a class=\"editeur\" href=\"../"+ repertoire  +"/editeur/" + edi.getNom() +".html\">" + edi.getNom() + "</a></br></br>" );
            pw.println ( "\t\t\t\t\t\t<a href=\"../"+ repertoire  +"/editeur/" + edi.getNom() +".html\"> <img  class=\"accueil\" src=\"../Generateur/ressources/images/editeurs/" +edi.getLogo() + "\"/></a>");
            pw.println ( "\t\t\t\t\t</td>");
            if(cptBr1%5==0){pw.println("\t\t\t\t</tr>");}
            cptBr1++;
        }
        pw.println("\t\t\t</table>");
        pw.println("\t\t</article>\n\t\t<footer>\n\t\t\t<h1>Ludothèque</h1>");
        pw.println("\t\t\t<h3>© Small word </br>\n\t\t\t (Julien.D, Nicolas.V, Mathieu.B, Lucas.D, Alexandre.D)</h3>");
        pw.print("\t\t</footer>\n\t</body>\n</html>");
        pw.close();
      }
}
