package teachersV1;

import java.util.ArrayList;
import java.util.Collections;

import teachersV1.exceptions.EleveInconnu;


public class Promotion {
	/**
	 * The nom de la promotion.
	 */
	private String nom;

	/**
	 * La liste des eleves(ArrayList).
	 */
	private ArrayList<Eleve> list;

	/**
	 * Le constructeur avec un parametre .
	 * 
	 * @param nom
	 *            Le nom de la promotion.
	 */
	public Promotion(String nom) {
		this.nom = nom;
		list = new ArrayList<Eleve>();
	}

	/**
	 * Cherche un eleve existant dans la liste .
	 * 
	 * @param id
	 *            id de l'eleve
	 * @return l'eleve.
	 * @throws EleveInconnu
	 *             Si l'eleve n'existe pas .
	 */
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
			throw new EleveInconnu("Pas d'eleve avec un id" + id
					+ " dans la promotion " + nom + " !");
		} else {
			return s;
		}
	}

	/**
	 * Affiche la promotion.
	 * 
	 * @return la promotion dans un String.
	 */
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

	/**
	 * Ajoute un eleve dans la promotion.
	 * 
	 * @param eleve
	 *            Eleve.
	 * @return <code>1</code> si l'ajout est bon, <code>0</code>
	 *         sinon.
	 */
	public int add(Eleve eleve) {
		int i;
		boolean error = false;
		for (i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == eleve.getId()) {
				error = true;
			}
		}
		if (error) {
			System.out.println("Erreur : Meme id dans la promotion!");
		} else {
			list.add(eleve);
			if (eleve.getP() != null) {
				eleve.setP(null);
			}
			eleve.setP(this);
			return 1;
		}
		return 0;
	}

	/**
         * Trie la liste des eleves dependant du mode de triage (croissant ou decroissant) 
	 * 
	 * 
	 * @param mode
	 *            <code>0</code> ordre croissant or <code>1</code>  ordre decroissant
	 *            .
	 * @return La liste triée.
	 */
	public int sort(int mode) {
		if (this.list != null) {
			if (mode == 0) { /* Si mode = 0; Croissant */

				Collections.sort(list);

			} else if (mode == 1) { /* Si mode = 1; Decroissant */

				Collections.sort(list, Collections.reverseOrder());

			} else {
				return 0;
			}
			return 1;
		}
		return 0;
	}

	/**
	 * .
	 * 
	 * @param o
     * @return 
	 *            
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Promotion) {
			Promotion p = (Promotion) o;
			return (this.nom.equals(p.nom));

		}
		return false;
	}

	/**
	 * .
	 * 
	 * @return .
	 */
	public String getNom() {
		return nom;
	}
}