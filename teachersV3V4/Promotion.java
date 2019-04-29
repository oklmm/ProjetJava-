package teachersV3V4;

import java.util.ArrayList;
import java.util.Collections;

import teachersV3V4.exceptions.EleveInconnu;

/**
 * Pour trier les eleves d'une promotion et savoir exactement dans quel promo est un eleve 
 */
public class Promotion {
	/**
	 * Le nom de la promo.
	 */
	private String nom;

	/**
	 * La liste des eleves (ArrayList).
	 */
	private ArrayList<Eleve> list;

	/**
	 * Le constructeur avec parametre 
	 * 
	 * @param nom
	 *            Le nom de la promo.
	 */
	public Promotion(String nom) {
		this.nom = nom;
		setList(new ArrayList<Eleve>());
	}

	/**
	 * Chercher un eleve dans la liste.
	 * 
	 * @param id
	 *            id de l'eleve.
	 * @return L'eleve.
	 * @throws EleveInconnu
	 *             .
	 */
	public Eleve search(int id) throws EleveInconnu {
		Eleve s = null;
		boolean found = false;
		int i = 0;

		while (i < getList().size() && !found) {
			s = getList().get(i);
			if (s.getId() == id)
				found = true;
			i++;
		}

		if (!found) {
			throw new EleveInconnu("Pas d'eleve avec un id " + id
					+ " dans la promotion " + nom + " !");
		} else {
			return s;
		}
	}

	/**
	 * Afficher dans la promotion.
	 * 
	 * @return La promotion dans un string .
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i;
		sb.append("=======================\n\tPROMOTION\n=======================\n");
		for (i = 0; i < getList().size(); i++) {
			sb.append(getList().get(i));
		}
		return sb.toString();
	}

	/**
	 * Ajoute un eleve dans la promotion.
	 * 
	 * @param eleve
	 *             Eleve.
	 * @return 
	 */
	public int add(Eleve eleve) {
		int i;
		boolean error = false;
		for (i = 0; i < getList().size(); i++) {
			if (getList().get(i).getId() == eleve.getId()) {
				error = true;
			}
		}
		if (error) {
			System.out.println("Erreur : meme id dans la promotion!");
		} else {
			getList().add(eleve);
			if (eleve.getP() != null) {
				eleve.setP(null);
			}
			eleve.setP(this);
			return 1;
		}
		return 0;
	}
	
	/**
	 * Supprimer un eleve.
	 * 
	 * @param s
	 *            Eleve.
	 * @return
	 */
	public int remove(Eleve s) {
		int i;
		for (i = 0; i < getList().size(); i++) {
			if (getList().get(i).getId() == s.getId()) {
				getList().remove(i);
				return 1;
			}
		}
		return 0;
	}

	/**
	 * Tri : Ordre croissant ou decroissant.
	 * 
	 * @param mode
	 *     
	 */
	public int sort(int mode) {
		if (this.getList() != null) {
			if (mode == 0) { /* si mode = 0; croissant */

				Collections.sort(getList());

			} else if (mode == 1) { /* If mode=1; decroissant */

				Collections.sort(getList(), Collections.reverseOrder());

			} else {
				return 0;
			}
			return 1;
		}
		return 0;
	}

	/**
	 * Retourne si deux promos sont egaux
	 * 
	 * @param o
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
	 * Avoir le nom de la promo.
	 * 
	 * @return Le nom de la promo.
	 */
	public String getNom() {
		return nom;
	}

	public ArrayList<Eleve> getList() {
		return list;
	}

	public void setList(ArrayList<Eleve> list) {
		this.list = list;
	}

    public void trier(int i) {
        throw new UnsupportedOperationException("Pas encore supporte.");
    }

    public void supprimer(Eleve s) {
        throw new UnsupportedOperationException("Pas encore supporte."); 
    }

    public int ajouter(Eleve s) {
        throw new UnsupportedOperationException("Pas encore supporte.");
    }

    public void ajouter(Eleve eleve) {
        throw new UnsupportedOperationException("Pas encore supporte."); 
    }
}