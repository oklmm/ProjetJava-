package teachersV2;


public class Evaluation {
	
	private Professeur correcteur;

	
	private final Eleve corrige;

	
	private float valeur;

	
	
	public Evaluation(Professeur Correcteur, Eleve corrige, float valeur) {
		this.correcteur = Correcteur;
		this.corrige = corrige;
		this.valeur = valeur;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getValeur());
		return sb.toString();
	}

	
	public Professeur getCorrecteur() {
		return correcteur;
	}

	
	public Eleve getCorrige() {
		return corrige;
	}

	
	
	public float getValeur() {
		return valeur;
	}

	
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	
	

	public void setCorrecteur(Professeur grader) {
		this.correcteur = grader;
	}
}