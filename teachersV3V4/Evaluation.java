package teachersV3V4;

public class Evaluation {
	/**
	 * Le correcteur.
	 */
	private Professeur correcteur;

	/**
	 * L'eleve corrige.
	 */
	private final Eleve corrige;

	/**
	 * La valeur de la note.
	 */
	private float valeur;

	/**
	 * Constructeur evalutation.
	 * 
	 * @param correcteur
	 *            Correcteur en parametre.
	 * @param corrige
	 *            L'eleve corrige en parametre.
	 * @param valeur
	 *            La valeur de la note en parametre .
	 */
	public Evaluation(Professeur correcteur, Eleve corrige, float valeur) {
		this.correcteur = correcteur;
		this.corrige = corrige;
		this.valeur = valeur;
	}

	/**
	 * AFFICHER LA NOTE.
	 * 
	 * @return RETOURNE LA VALEUR DE LA NOTE DANS UN STRING.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getValeur());
		return sb.toString();
	}

	/**
	 * Getteur.
	 * 
	 * @return Le correcteur.
	 */
	public Professeur getCorrecteur() {
		return correcteur;
	}

	/**
	 * 
	 * 
	 * @return 
	 */
	public Eleve getCorrige() {
		return corrige;
	}

	/**
	 * 
	 * 
	 * @return Retourne la valeur de la note 
	public float getValeur() {
		return valeur;
	}

	/**
	 * Setteur
	 * 
	 * @param valeur
	 *            
	 */
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	/**
	 * 
	 * 
	 * @param grader
	 *            
	 */
	public void setCorrected(Professeur grader) {
		this.correcteur = grader;
	}

    AbstractStringBuilder getValeur() {
        throw new UnsupportedOperationException("Pas encore supporté."); 
    }
}