import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;

public class GenerationPageAccueil {
    public static void generer(String repertoire, ArrayList<Auteur> alAuteur, ArrayList<Editeur> alEditeur) {

        PrintWriter pw = null;

        int cptBr = 0;
        int cptBr1 = 1;
        
        try {    
            pw = new PrintWriter(new File( "../" + repertoire + "/index.html" ), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ecriture en HTML
        pw.println("<!DOCTYPE html>");
        pw.println("<html>\n<head>\n<meta charset=\"UTF-8\" lang=\"fr\"/>");
        pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../Generateur/ressources/CSS/GenerationPages.css\" />");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<header>\n<img class=\"logo\" src=\"../Generateur/ressources/images/logo/Logo.jpg\" height=\"100%\" width=\"10%\" alt=\"image vers accueil\"/>");
        pw.println("<h1>Ludothèque du Havre :</h1>");
        pw.println("<h3>&nbsp;Vous pourrez trouver ici tous ce que vous propose notre ludothèque en passant par les auteurs et les éditeurs de jeux de sociétés</h3>");
        pw.println("</header>");
        pw.println("<article class=\"center\">");
        pw.println("<h2>Auteurs :</h2>");
        pw.println("</article>");
        pw.println("<article class=\"auteur\">");
        pw.println("<table>");

        for(Auteur aut : alAuteur) {

            // Permet de faire un tableau de tous les auteurs présents
            boolean addTabs = cptBr % 8 == 0;

            if(addTabs) pw.println(GenerationPageAccueil.addTr());
            
            pw.println("<td><a class=\"auteur\" href=\"../" + repertoire  + "/auteur/" + aut.getPrenomNom() + ".html\">" + aut.getPrenomNom() + "</a>&emsp;&emsp;</td>");
            cptBr++;
            
            if(addTabs) pw.println(GenerationPageAccueil.addTr());
        }

        pw.println("</table>");
		pw.println("</article>");
        pw.println("<article class=\"center\">");
        pw.println("<h2>Editeurs :</h2>");
        pw.println("</article>");
        pw.println("<article class=\"editeur\">");
        pw.println("<table>");

        // Boucle qui prend tous les auteurs
        for(Editeur edi : alEditeur) {

            // Permet de faire un tableau de tous les éditeurs présents
            boolean addTabs = cptBr1 % 5 == 1;
            
            if(addTabs) pw.println(GenerationPageAccueil.addTr());

            pw.println("<td>\n<a class=\"editeur\" href=\"../"+ repertoire  +"/editeur/" + edi.getNom() +".html\">" + edi.getNom() + "</a></br></br>" );
            pw.println("<a href=\"../"+ repertoire  +"/editeur/" + edi.getNom() +".html\"> <img  class=\"accueil\" src=\"../Generateur/ressources/images/editeurs/" +edi.getLogo() + "\"/></a>");
            pw.println("</td>");

            if(addTabs) pw.println(GenerationPageAccueil.addTr());
            cptBr1++;
        }

        pw.println("</table>");
        pw.println("</article>\n<footer>\n<h1>Ludothèque</h1>");
        pw.println("<h3>© Small word </br>\n(Julien.D, Nicolas.V, Mathieu.B, Lucas.D, Alexandre.D)</h3>");
        pw.println("</footer>\n</body>\n</html>");
        pw.close();
    }

    public static String addTr() {
        return "</tr>";
    }
}
