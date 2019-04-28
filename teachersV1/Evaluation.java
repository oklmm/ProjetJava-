package teachersV1;


public class Evaluation {
	/**
	 * Le correcteur.
	 */
	private Professeur correcteur;

	/**
	 * L'eleve a corriger.
	 */
	private final Eleve corrige;

	/**
	 * La valeur de la note 
	 */
	private float valeur;

	/**
	 * Constructeur de l'evaluation.
	 * 
	 * @param correcteur
	 *            Le correcteur.
	 * @param corrige
	 *            
	 * @param valeur
	 *            La valeur de la note.
	 */
	public Evaluation(Professeur correcteur, Eleve corrige, float valeur) {
		this.correcteur = correcteur;
		this.corrige = corrige;
		this.valeur = valeur;
	}

	/**
	 * Afficher les notes .
	 * 
     * @return 
	 * @retourne La valeur de la note dans un String.
	 */
	@Override
	public String toString() {
		return "(" + getValeur() + ")";
	}

	/**
     * @return	 
	 */
	public Professeur getCorrecteur() {
		return correcteur;
	}

	/**
     * @return	 
	 */
	public Eleve getCorrige() {
		return corrige;
	}

	/**
     * @return	 
	 */
	public float getValeur() {
		return valeur;
	}

	/**
     * @param valeur	
	 */
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	/**
	 
	 */
	public void setCorrecteur(Professeur correcteur) {
		this.correcteur = correcteur;
	}
}