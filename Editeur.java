public class Editeur {
	private String nom;
	private String logo;

	public Editeur(String nom, String logo) {
		this.nom = nom;
		this.logo = logo;
	}

	public String getNom() { 
		return this.nom;  
	}
	
	public String getLogo() { 
		return this.logo; 
	}

	public String toString() {
		return this.nom;
	}
}
