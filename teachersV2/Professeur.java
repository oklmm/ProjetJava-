package teachersV2;

import teachersV2.exceptions.EleveInconnu;



public class Professeur extends Personne {

	
	public Professeur(String name, String prenom) {
		super(name, prenom);
	}

	
	public void setNote(Promotion p, int id, float valeur, int index) {
		Eleve corrige = null;
		try {
			corrige = p.search(id);
			if (corrige.getNotes()[index] == null)
				corrige.getNotes()[index] = new Evaluation(this, corrige,
						valeur);
			else {
				corrige.getNotes()[index].setValeur(valeur);
				corrige.getNotes()[index].setCorrecteur(this);
			}
		} catch (EleveInconnu e) {
			System.out
					.println("L'eleve n'est pas dans la bonne promotion ou n'existe pas");
		}
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom + " " + prenom);
		return sb.toString();
	}

	
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Professeur) {
			Professeur prof = (Professeur) o;
			return (this.nom.equals(prof.nom) && this.prenom
					.equals(prof.prenom));

		}
		return false;
	}
	
	
	public String getNom() {
		return super.nom;
	}
	
	public String getPrenom() {
		return super.prenom;
	}

}