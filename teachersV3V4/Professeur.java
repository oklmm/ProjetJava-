package teachersV3V4;

import teachersV3V4.exceptions.EleveInconnu;

/**
 * Le professeur peut ajouter des notes des eleves et leur id. Il peut ajouter ou modifier des notes. 
 *
 */
public class Professeur extends Personne {

	/**
	 * Le contructeur avec parametre
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Professeur(String nom, String prenom) {
		super(nom, prenom);
	}

	/**
	 *  Ajouter ou modifier une note dependant du tableau de l'eleve.
	 * 
	 * @param p
	 *            .
	 * @param id
	 *           
	 * @param valeur
	 *           
	 * @param index
	 *            
	 */
	public void setNote(Promotion p, int id, float valeur, int index) {
		Eleve corrected = null;
		try {
			corrected = p.search(id);
			if (corrected.getMarks()[index] == null)
				corrected.getMarks()[index] = new Evaluation(this, corrected,
						valeur);
			else {
				corrected.getMarks()[index].setValeur(valeur);
				corrected.getMarks()[index].setCorrected(this);
			}
		} catch (EleveInconnu e) {
			System.out
					.println("L'eleve n'existe pas ou n'est pas dans la bonne promo!");
		}
	}

	/**
	 * 
	 * 
	 * @return Le professeur dans un string.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom + " " + prenom);
		return sb.toString();
	}

	/**
	 * Retourne si deux profs sont egaux
	 * 
	 * @param o
	 *            
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