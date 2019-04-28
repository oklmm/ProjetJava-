package teachersV2;

import java.util.ArrayList;
import java.util.Collections;

import teachersV2.exceptions.EleveInconnu;
import teachersV2.Eleve;


public class Promotion {
	
	private String nom;

	
	private ArrayList<Eleve> list;

	
	public Promotion(String name) {
		this.nom = name;
		list = new ArrayList<Eleve>();
	}

	
	public Eleve search(int id) throws EleveInconnu {
		Eleve s = null;
		boolean found = false;
		int i = 0;

		while (i < list.size() && !found) {
			s = list.get(i);
			if (s.getId() == id)
				found = true;
			i++;
		}

		if (!found) {
			throw new EleveInconnu("Pas d'eleve avec un ID " + id
					+ " dans la promotion " + nom + " !");
		} else {
			return s;
		}
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i;
		sb.append("=======================\n\tPROMOTION\n=======================\n");
		for (i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		return sb.toString();
	}

	
	public int ajouter(Eleve student) {
		int i;
		boolean error = false;
		for (i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == student.getId()) {
				error = true;
			}
		}
		if (error) {
			System.out.println("Erreur : meme ID dans la promotion!");
		} else {
			list.add(student);
			if (student.getP() != null) {
				student.setP(null);
			}
			student.setP(this);
			return 1;
		}
		return 0;
	}

	public int supprimer(Eleve s) {
		int i;
		for (i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == s.getId()) {
				list.remove(i);
				return 1;
			}
		}
		return 0;
	}

	
	public int trier(int mode) {
		if (this.list != null) {
			if (mode == 0) { 

				Collections.sort(list);

			} else if (mode == 1) { 
				Collections.sort(list, Collections.reverseOrder());

			} else {
				return 0;
			}
			return 1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Promotion) {
			Promotion p = (Promotion) o;
			return (this.nom.equals(p.nom));

		}
		return false;
	}

	
	public String getNom() {
		return nom;
	}

}