package teachersV1;

import java.util.HashSet;
import java.util.Set;

import teachersV1.exceptions.NotesVides;


public class Eleve extends Personne implements Comparable<Eleve> {
	/**
	 * 
	 */
	private Promotion p;

	/**
	 * Le nom de l'evalutation
	 */
	static final int NB_EVALUATIONS = 10;

	/**
	 * La note d'un eleve.
	 */
	private final Evaluation marks[] = new Evaluation[NB_EVALUATIONS];

	/**
	 * id de l'eleve.
	 */
	private final int id;

	/**
	 * lES CONSTRUCTEURS AVEC PARAMETRES.
	 * 
	 * @param nom
	 *          
	 * @param prenom
	 *           
	 * @param id
	 *           .
	 */
	public Eleve(String nom, String prenom, int id) {
		super(nom, prenom);
		this.id = id;
		p = null;
	}

	/**
	 * Donne la moyenne d'un eleve.
	 * 
	 * @return La moyenned'un eleve.
	 * @throws NotesVides
	 *             
	 */
	public float moyenne() throws NotesVides {
		int numerodeNotes = 0;

		float sum = 0;

		int i = 0;
		while (i < 10) {
			if (getNotes()[i] != null) {
				sum += getNotes()[i].getValeur();
				numerodeNotes++;
			}
			i++;
		}

		if (numerodeNotes == 0) {
			throw new NotesVides(super.toString() + " n'a pas de notes ");

		} else {
			return sum / numerodeNotes;
		}
	}

	/**
	 * Affiche l'eleve.
	 * 
	 * @return l'eleve dans un string.
	 */
	@Override
	public String toString() {
		int i;
		StringBuilder sb = new StringBuilder();

		if (this.getNotes() != null) {
			try {
				if (moyenne() != 0) {
					sb.append(super.toString());
					sb.append("\n\tPromotion: " + p.getNom());
					sb.append("\n\tId: ").append(id).append("\n\tNotes: ");

					for (i = 0; i < NB_EVALUATIONS; i++) {
						if (this.marks[i] != null) {
							sb.append(marks[i] + " ");
						}
					}

					sb.append("\n\tCorrecteurs(s): ").append(this.getCorrecteurs());
					sb.append("\n\tMoyennes: ").append(this.moyenne())
							.append("\n");
				}
			} catch (NotesVides e) {
				System.out.println(super.toString() + " n'a pas de notes !");
			}
		}
		return sb.toString();
	}

	/**
	 * Affiche un eleve avec nom et prenom.
	 * 
	 * @return l'eleve.
	 */
	public String afficherNoms() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.nom + " " + super.prenom);

		return sb.toString();
	}

	/**
	 * Affiche l'eleve avec son nom prenom et moyenne.
	 * 
	 * @return.
	 */
	public String afficherMoyennes() {
		StringBuilder sb = new StringBuilder();

		try {
			if (this.moyenne() != 0) {
				sb.append(super.toString() + ", Average: ").append(this.moyenne());
			}
		} catch (NotesVides e) {
			System.out.println(super.toString() + " doesn't have marks !");
		}

		return sb.toString();
	}

	/**
	 * Retourne la liste des correcteurs.
	 * 
	 * @return .
	 */
	public Set<Professeur> getCorrecteurs() {
		Set<Professeur> list = new HashSet<Professeur>();

		for (int i = 0; i < getNotes().length; i++) {
			if (getNotes()[i] != null)
				list.add(getNotes()[i].getCorrecteur());
		}
		return list;
	}

	/**
	 * Compare la moyenne de deux eleves.
	 */
	@Override
	public int compareTo(Eleve student) {
		float moyenne1 = 0;
		float moyenne2 = 0;

		try {
			moyenne1 = this.moyenne();
			moyenne2 = student.moyenne();
		} catch (NotesVides e) {
			e.getMessage();
		}

		if (moyenne1 > moyenne2)
			return 1;
		if (moyenne1 == moyenne2)
			return 0;
		return -1;
	}

	/**
	 * Retourne si deux eleves sont egaux.
	 * 
	 * @param o
	 *           
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Eleve) {
			Eleve s = (Eleve) o;
			return (this.nom.equals(s.nom) && this.prenom
					.equals(s.prenom));

		}
		return false;
	}

	/**
	 * .
	 * 
	 * @return 
	 */
	public Evaluation[] getNotes() {
		return marks;
	}
	
	/**
	 *
     * @return 
	 */
	public String getNom() {
		return super.nom;
	}
	
	/**
	 * 
	 */
	public String getPrenom() {
		return super.prenom;
	}

	/**
	 *
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
     * @return 
	 */
	public Promotion getP() {
		return p;
	}

	/**
	 *
     * @param p
	 */
	public void setP(Promotion p) {
		this.p = p;
	}
}