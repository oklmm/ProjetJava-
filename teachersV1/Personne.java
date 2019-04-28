package teachersV1;

abstract class Personne {
	/**
	 * 
	 */
	protected final String nom;

	/**
	
	 */
	protected final String prenom;

	/**
	 * Le constructeur sans parametre.
	 */
	protected Personne() {
		nom = prenom = null;
	}

	/**
	 * Le constructeur avec parametre.
	 * 
	 * @param nom
	 *            Le nom de la personne.
	 * @param prenom
	 *            Le nom de la personne.
	 */
	protected Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Afficher le nom et le prenom de la personne.
	 * 
	 * @return .
	 */
	@Override
	public String toString() {
		return "(" + nom + ", " + prenom + ")";
	}
}