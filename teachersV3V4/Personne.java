package teachersV3V4;

abstract class Personne {
	/**
	 * Le nom de la personne
	 */
	protected final String nom;

	/**
	 * Le prenom de la personne.
	 */
	protected final String prenom;

	/**
	 * Le constructeur sans parametre.
	 */
	protected Personne() {
		nom = prenom = null;
	}

	/**
	 * le CONSTRUCTEUR AVEC PARAMETRE.
	 * 
	 * @param nom
	 *            Le nom de la personne
	 * @param prenom
	 *            Le prenom de la personne.
	 */
	protected Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Affiche le nom et le prenom de la personne.
	 * 
	 * @return Retourne le nom de la personne dans un string .
	 */
	@Override
	public String toString() {
		return "(" + nom + ", " + prenom + ")";
	}
}