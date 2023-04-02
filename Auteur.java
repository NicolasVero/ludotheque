public class Auteur
{
	private String nom;
	private String prenom;

	// Permet de créer un auteur à partir d'une chaine unique.
	// On part du principe que le premier blanc rencontré dans cette chaine
	// sépare le prénom du nom, s'il n'y a pas de blanc cela  signifie  que
	// l'on n'a pas de prénom
	public Auteur ( String prenomNom )
	{
		int  indiceBlanc;

		indiceBlanc = prenomNom.indexOf(' ');


		if ( indiceBlanc != -1 )
		{
			this.prenom = prenomNom.substring ( 0, indiceBlanc );
			this.nom    = prenomNom.substring ( indiceBlanc+1  );
		}
		else
		{
			this.prenom = null;
			this.nom    = prenomNom;
		}

	}

	public String getPrenomNom()
	{
		if ( prenom == null ) return this.nom;
		return this.prenom + " " + this.nom;
	}

	public String getPrenom   () { return this.prenom;                  }
	public String getNom      () { return this.nom;                     }

	public String toString()
	{
		return getPrenomNom();
	}
}