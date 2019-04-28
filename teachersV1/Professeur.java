package teachersV1;

import teachersV1.exceptions.EleveInconnu;

public class Professeur extends Personne {

	/**
	 * Le constructeur avec les parametres.
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Professeur(String nom, String prenom) {
		super(nom, prenom);
	}

	/**
	 * Defini ou modifie la note d'un eleve en fonction de sa position dans le tableau. 
	 * 
	 * @param p
	 *            La promotion de l'eleve.
	 * @param id
	 *            l'id de l'eleve.
	 * @param valeur
	 *            la valeur de la note.
	 * @param index
	 *            L'index de l'eleve dans le tableau
	 */
	public void setNote(Promotion p, int id, float valeur, int index) {
		Eleve corrected = null;
		try {
			corrected = p.search(id);
			if (corrected.getNotes()[index] == null)
				corrected.getNotes()[index] = new Evaluation(this, corrected,
						valeur);
			else {
				corrected.getNotes()[index].setValeur(valeur);
				corrected.getNotes()[index].setCorrecteur(this);
			}
		} catch (EleveInconnu e) {
			System.out
					.println("L'eleve n'existe pas ou est dans la mauvaise promotion!");
		}
	}

	/**
	 * 
	 * 
	 * @return .
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom + " " + prenom);
		return sb.toString();
	}

	/**
	 * Retorune si deux professseurs sont egaux.
	 * 
	 *
     * @param o
     * @return 
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Professeur) {
			Professeur prof = (Professeur) o;
			return (this.nom.equals(prof.nom) && this.prenom
					.equals(prof.prenom));

		}
		return false;
	}
	
	/**
	 * 
	 * 
	 * @return 
	 */
	public String getNom() {
		return super.nom;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public String getPrenom() {
		return super.prenom;
	}

}