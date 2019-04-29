package teachersV3V4;

import java.util.HashSet;
import java.util.Set;

import teachersV3V4.exceptions.NotesVides;

public class Eleve extends Personne implements Comparable<Eleve> {

	private Promotion p;

	
	static final int NB_EVALUATIONS = 10;

	public final Evaluation marks[] = new Evaluation[NB_EVALUATIONS];

	
	private final int id;

	
	public Eleve(String nom, String prenom, int id) {
		super(nom, prenom);
		this.id = id;
		p = null;
	}

	
	public float moyenne() throws NotesVides {
		int NumeroDeNotes = 0;

		float sum = 0;

		int i = 0;
		while (i < 10) {
			if (getNotes()[i] != null) {
				sum += getNotes()[i].getValeur();
				NumeroDeNotes++;
			}
			i++;
		}

		if (NumeroDeNotes == 0) {
			throw new NotesVides(super.toString() + " n'a pas de notes !");

		} else {
			return sum / NumeroDeNotes;
		}
	}

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
					sb.append("\n\tMoyenne: ").append(this.moyenne())
							.append("\n");
				}
			} catch (NotesVides e) {
				System.out.println(super.toString() + " n'a pas de notes  !");
			}
		}
		return sb.toString();
	}

	public String afficherNoms() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.nom + " " + super.prenom);

		return sb.toString();
	}

	
	public String afficherMoyenne() {
		StringBuilder sb = new StringBuilder();

		try {
			if (this.moyenne() != 0) {
				sb.append(super.toString() + ", Moyenne: ").append(this.moyenne());
			}
		} catch (NotesVides e) {
			System.out.println(super.toString() + "  n'a pas de notes !");
		}

		return sb.toString();
	}

	
	public Set<Professeur> getCorrecteurs() {
		Set<Professeur> list = new HashSet<Professeur>();

		for (int i = 0; i < getNotes().length; i++) {
			if (getNotes()[i] != null)
				list.add(getNotes()[i].getCorrecteur());
		}
		return list;
	}

	
	@Override
	public int compareTo(Eleve eleve) {
		float moyenne1 = 0;
		float moyenne2 = 0;

		try {
			moyenne1 = this.moyenne();
			moyenne2 = eleve.moyenne();
		} catch (NotesVides e) {
			e.getMessage();
		}

		if (moyenne1 > moyenne2)
			return 1;
		if (moyenne1 == moyenne2)
			return 0;
		return -1;
	}

	
	public Evaluation[] getNotes() {
		return marks;
	}

	
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Eleve) {
			Eleve s = (Eleve) o;
			return (this.nom.equals(s.nom) && this.prenom
					.equals(s.prenom));

		}
		return false;
	}

	public String getNom() {
		return super.nom;
	}
	
	
	public String getPrenom() {
		return super.prenom;
	}
	
	
	public int getId() {
		return id;
	}

	
	
	public Promotion getP() {
		return p;
	}

	
	public void setP(Promotion p) {
		this.p = p;
	}

    Evaluation[] getMarks() {
        throw new UnsupportedOperationException("Pas encore supporte."); 
    }

    public String afficherNom() {
        throw new UnsupportedOperationException("Pas encore supporte.");
    }
}