public class Jeu
{
	private Categorie categorie;
	private String    titre;
	private String    dateDeSortie;
	private Auteur    auteur1;
	private Auteur    auteur2;
	private Editeur   editeur;
	private int       nbJoueurMini;
	private int       nbJoueurMaxi;
	private int       tempsMoyen;
	private int       ageMini;
	private String    image;

	public Jeu ( Categorie categorie,
	             String    titre,
	             String    dateDeSortie,
	             Auteur    auteur1,
	             Auteur    auteur2,
	             Editeur   editeur,
	             int       nbJoueurMini,
	             int       nbJoueurMaxi,
	             int       tempsMoyen,
	             int       ageMini,
	             String    image          )

	{
		this.categorie    = categorie;
		this.titre        = titre;
		this.dateDeSortie = dateDeSortie;
		this.auteur1      = auteur1;
		this.auteur2      = auteur2;
		this.editeur      = editeur;
		this.nbJoueurMini = nbJoueurMini;
		this.nbJoueurMaxi = nbJoueurMaxi;
		this.tempsMoyen   = tempsMoyen;
		this.ageMini      = ageMini;
		this.image        = image;
	}

	public Categorie getCategorie   (){ return this.categorie;                 }
	public String    getTitre       (){ return this.titre;                     }
	public String    getDateDeSortie(){ return this.format(this.dateDeSortie); }
	public Auteur    getAuteur1     (){ return this.auteur1;                   }
	public Auteur    getAuteur2     (){ return this.auteur2;                   }
	public Editeur   getEditeur     (){ return this.editeur;                   }
	public int       getNbJoueurMini(){ return this.nbJoueurMini;              }
	public int       getNbJoueurMaxi(){ return this.nbJoueurMaxi;              }
	public int       getTempsMoyen  (){ return this.tempsMoyen;                }
	public int       getAgeMini     (){ return this.ageMini;                   }
	public String    getImage       (){ return this.image;                     }



	// Méthode utilitaire indépendante de tout Objet
	// Transforme une date au format AAAAMMJJ en date au Format JJ/MM/AAAA
	// On part du principe que la donnée en entrée est correcte
	private String format ( String date )
	{
		// AAAAMMJJ
		// 01234567

		return date.substring ( 6, 8 ) + "/" +
		       date.substring ( 4, 6 ) + "/" +
		       date.substring ( 0, 4 );
	}



	// Ici la méthode toString ne donne pas toutes les informations, elle permet juste de
	// vérifier les données principales du Jeu.
	// Toute la mise en forme doit être normalement faites dans une partie IHM.
	// Pour vous ce sera de la responsabilité des méthodes  qui  généreront  les  données
	// de faire la mise en forme
	public String toString()
	{
		String sRet = String.format ("%-10s",    this.getDateDeSortie() )      + " | " +
		              String.format ("%-45s",    this.titre )                  + " | " +
		              String.format ("%-15s",    this.categorie.getLibelle() ) + " | " +
		              String.format ("%-22s",    this.editeur.getNom()       ) + " | " +
		              String.format ("%-18.18s", this.auteur1                ) + " | ";

		if ( this.auteur2 != null )
			sRet +=  String.format ("%-18.18s", this.auteur2                ) + " | ";
		else
			sRet += String.format ("%-18s",     ""                          ) + " | ";

		return sRet;
	}


}