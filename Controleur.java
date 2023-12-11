public class Controleur {
	private Metier metier;

	public Controleur(String repDestination) {
		this.metier = new Metier();
		this.metier.genererPages(repDestination);
	}

	public static void main(String[] rep) {
		String repCible = "ludotheque";
		
		if(rep.length > 0)
			repCible = rep[0];

		new Controleur(repCible);
	}
}