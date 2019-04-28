package teachersV1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import teachersV1.Professeur;
import teachersV1.Promotion;
import teachersV1.Eleve;


public class Interaction {

	/**
	 * 
	 */
	static ArrayList<Eleve> sList = new ArrayList<Eleve>();

	/**
	
	 */
	static ArrayList<Professeur> profList = new ArrayList<Professeur>();

	/**

	 */
	static ArrayList<Promotion> pList = new ArrayList<Promotion>();

	/**
	 *
	 * 
	 * @return le menu dans un string.
	 */
	public static String menu() {
		StringBuilder sb = new StringBuilder();

		sb.append("========== MENU ==========\n");
		sb.append("0- Creer un eleve\n");
		sb.append("1- Creer un professeur\n");
		sb.append("2- Mettre un eleve dans une promotion\n");
		sb.append("3- Mettre des notes d'un eleve\n");
		sb.append("4- Afficher tous les eleves d'une \n");
		sb.append("5- Afficher un eleve (nom, promotion, notes, correcteurs)\n");
		sb.append("6- Afficher un eleve avec son nom et sa promotion\n");
		sb.append("7- Trier les eleves par ordre croissant\n");
		sb.append("8- Afficher les eleves par ordre decroissant\n");
		sb.append("9- Quitter le Programme");

		return sb.toString();
	}

	/**
	 * Creer un eleve.
	 * 
	 * @return 
	 */
	public static int creerEleve() {
		System.out.println("=== Creation d'un eleve ===");
		Scanner scId = new Scanner(System.in);
		System.out.print("Donner un nom: ");
		String nom = "";
		while (nom.equals("")) {
			Scanner scName = new Scanner(System.in);
			nom = scName.nextLine();
		}
		System.out.print("Donner un prenom: ");
		String prenom = "";
		while (prenom.equals("")) {
			Scanner scPrenom = new Scanner(System.in);
			prenom = scPrenom.nextLine();
		}
		System.out.print("Donner un id: ");
		try {
			int id = scId.nextInt();
			Eleve eleve = new Eleve(nom, prenom, id);

			// .
			boolean exist = false;
			for (int i = 0; i < sList.size(); i++) {
				if (sList.get(i).equals(eleve)) {
					exist = true;
				}
			}

			if (!exist) {
				sList.add(eleve);
				System.out.println("Eleve" + eleve.afficherNoms()
						+ " Creé.");
			} else {
				System.out.println("Cet eleve existe!");
			}

			System.out.println();
		} catch (InputMismatchException e) {
			System.out.println("Entrer un numero valide");
			return 0;
		}
		return 1;
	}

	/**
	 * Creer un professeur.
	 */
	public static void creerProfesseur() {
		System.out.println("=== Creation d'un professeur ===");
		System.out.print("Donner un nom : ");
		String name = "";
		while (name.equals("")) {
			Scanner scNom = new Scanner(System.in);
			name = scNom.nextLine();
		}
		System.out.print("Donner un prenom: ");
		String prenom = "";
		while (prenom.equals("")) {
			Scanner scPrenom = new Scanner(System.in);
			prenom = scPrenom.nextLine();
		}
		Professeur prof = new Professeur(name, prenom);

		// On cherche si le prof n'existe pas deja dans la liste
		boolean exist = false;
		for (int i = 0; i < profList.size(); i++) {
			if (profList.get(i).equals(prof)) {
				exist = true;
			}
		}

		if (!exist) {
			profList.add(prof);
			System.out.println("Professeur " + prof + " ajouté.");
		} else {
			System.out.println("Ce professeur existe!");
		}
		System.out.println();
	}

	/**
	.
	 */
	public static void afficherListEleves() {
		if (sList.isEmpty()) {
			System.out.println(" ya pas d'eleves!");
		} else {
			int i;
			for (i = 0; i < sList.size(); i++) {
				System.out.print(i + ":" + sList.get(i).afficherNoms() + " ");
			}
			System.out.println();
		}
	}

	/**
	 * .
	 * 
	 * @param mode
	 *           
	 */
	public static void afficherEleve(int mode) {
		if (sList.isEmpty()) {
			System.out.println("Y'a pas d'eleves !");
		} else {
			System.out.println("Quel eleve voulez vous choisir?");
			afficherListEleves();
			Scanner scIndexS = new Scanner(System.in);

			Eleve s = null;
			while (s == null) {
				int iS = scIndexS.nextInt();
				s = ChoisirListeEleves(iS);
			}
			if (mode == 0) {
				System.out.println(s);
			} else {
				System.out.println(s.afficherMoyennes());
			}
		}
	}

	/**
	 * 
     * @param index
	 * @return 	 */
	public static Eleve ChoisirListeEleves(int index) {
		if (sList.isEmpty()) {
			System.out.println("Il ya pas d'eleves!");
		} else {
			Eleve s = null;
			try {
				s = sList.get(index);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Choisir un eleve dans la liste!");
				return null;
			}
			return s;
		}
		return null;
	}

	/**
	 * 
	 */
	public static void afficherListeProfesseur() {
		if (profList.isEmpty()) {
			System.out.println("Il y'a pas de professeurs !");
		} else {
			int i;
			for (i = 0; i < profList.size(); i++) {
				System.out.print(i + ":" + profList.get(i) + " ");
			}
			System.out.println();
		}
	}

	/**
	 * .
     * @param index
     * @return 
	 */
	public static Professeur ChoisirListeProfesseur(int index) {
		if (profList.isEmpty()) {
			System.out.println("Ya pas de professeurs !");
		} else {
			Professeur prof = null;
			try {
				prof = profList.get(index);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Choisir un professeur existant  !");
				return null;
			}
			return prof;
		}
		return null;
	}

	/**
	 * Display the Promotion List.
	 */
	public static void afficherListePromotion() {
		if (pList.isEmpty()) {
			System.out.println("Il y' a pas de promotions !");
		} else {
			int i;
			for (i = 0; i < pList.size(); i++) {
				System.out.print(i + ":" + pList.get(i).getNom() + " ");
			}
			System.out.println();
		}
	}

	/**
	 *
	 */
	public static void afficherPromotion() {
		if (pList.isEmpty()) {
			System.out.println("Ya pas de promotion !");
		} else {
			System.out.println("Quelle promotion voulez vous ajouter ?");
			afficherListePromotion();
			Scanner scIndexP = new Scanner(System.in);

			Promotion p = null;
			while (p == null) {
				int iP = scIndexP.nextInt();
				p = ChoisirListePromotion(iP);
			}
			System.out.println(p);
		}
	}

	/**
	 * Choose the promotion in the actual List in the Program.
	 * 
	 * @param index
	 *            The index of the Promotion List.
	 * @return The promotion.
	 */
	public static Promotion ChoisirListePromotion(int index) {
		if (pList.isEmpty()) {
			System.out.println("Il y'a pas de promotions !");
		} else {
			Promotion p = null;
			try {
				p = pList.get(index);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Choisir une promotion existante !");
				return null;
			}
			return p;
		}
		return null;
	}

	/**
	 * Ajouter un eleve dans la promotion
	 */
	public static void ajouterEleve() {
		if (sList.isEmpty()) {
			System.out.println("No eleve !");
		} else {
			System.out
					.println("Creer une promotion (0) ou en choisir un  (1) ?");
			int res = -1;

			while (res < 0 || res > 1) {
				Scanner sc = new Scanner(System.in);
				res = sc.nextInt();
			}
			//
			if (res == 0) {
				Scanner scNom = new Scanner(System.in);
				System.out.print("Donner un nom: ");
				String name = scNom.nextLine();
				Promotion pNew = new Promotion(name);

				//
				boolean exist = false;
				for (int i = 0; i < pList.size(); i++) {
					if (pList.get(i).equals(pNew)) {
						exist = true;
					}
				}

				if (!exist) {
					pList.add(pNew);
					System.out.println("Promotion " + pNew.getNom()
							+ " created.");
				} else {
					System.out.println("This promotion still exist !");
				}

				System.out.println("Which student do you want to add in ?");
				afficherListEleves();
				Scanner scIndex = new Scanner(System.in);

				Eleve s = null;
				while (s == null) {
					int i = scIndex.nextInt();
					s = ChoisirListeEleves(i);
				}
				pNew.add(s);
				System.out.println("Eleve " + s.afficherNoms()
						+ " ajoute dans la promotion " + pNew.getNom());

				
			} else {
				if (pList.isEmpty()) {
					System.out.println("Pas de promotions !");
				} else {
					System.out
							.println("Vous voulez ajouter quelle promotion");
					afficherListePromotion();
					Scanner scIndexP = new Scanner(System.in);

					Promotion p = null;
					while (p == null) {
						int iP = scIndexP.nextInt();
						p = ChoisirListePromotion(iP);
					}

					System.out.println("Vous voulez ajouter quel eleve?");
					afficherListEleves();
					Scanner scIndexS = new Scanner(System.in);

					Eleve s = null;
					while (s == null) {
						int iS = scIndexS.nextInt();
						s = ChoisirListeEleves(iS);
					}
					if (p.add(s) != 0) {
						System.out.println("Eleve " + s.afficherNoms()
								+ " ajouter dans la promotion" + p.getNom());
					}
				}
			}
		}
	}

	/**
	 *
	 */
	public static void ajouterNotes() {
		if (sList.isEmpty()) {
			System.out.println("Pas d'eleves!");

		} else if (profList.isEmpty()) {
			System.out.println("Pas de profs !");
		} else if (pList.isEmpty()) {
			System.out.println("PAs de promotion!");
		} else {

			System.out.println("Vous voulez qui comme correcteurs ?");
			afficherListeProfesseur();
			Scanner scIndexProf = new Scanner(System.in);

			Professeur prof = null;
			while (prof == null) {
				int iProf = scIndexProf.nextInt();
				prof = ChoisirListeProfesseur(iProf);
			}

			System.out.println("Vous voulez ajouter la note de qui?");
			afficherListEleves();
			Scanner scIndexS = new Scanner(System.in);

			Eleve s = null;
			while (s == null) {
				int iS = scIndexS.nextInt();
				s = ChoisirListeEleves(iS);
			}

			if (s.getP().equals(null)) {
				System.out.println("Cet eleve n'a pas de notes!");
			} else {
				System.out.print("donner une notes: ");
				int valeur = -1;
				while (valeur < 0 || valeur > 20) {
					Scanner scValue = new Scanner(System.in);
					valeur = scValue.nextInt();
				}
				System.out.print("Donner ou vous voulez mettre la note: ");
				int index = -1;
				while (index < 0 || index > 10) {
					Scanner scIndex = new Scanner(System.in);
					index = scIndex.nextInt();
				}
				prof.setNote(s.getP(), s.getId(), valeur, index);

				System.out.println("Noter avec la valeur " + valeur
						+ " ajouter dans les eleves " + s.afficherNoms()
						+ " avec le correcteur " + prof);
			}
		}

	}

	/**
	 * 
	 * @param mode
	 *            if <code>0</code> the sort is in ascending order,
	 *            <code>1</code>descending order otherwise.
	 */
	public static void TrierElevesPromotion(int mode) {
		if (sList.isEmpty()) {
			System.out.println(" pas d'eleves!");

		} else if (pList.isEmpty()) {
			System.out.println("Pas de promotion!");

		} else {

			System.out.println("Vous voulez quelle promotion?");
			afficherListePromotion();
			Scanner scIndexP = new Scanner(System.in);

			Promotion p = null;
			while (p == null) {
				int iP = scIndexP.nextInt();
				p = ChoisirListePromotion(iP);
			}

			if (mode == 0) {
				p.sort(0);
				System.out.println(p);
			} else {
				p.sort(1);
				System.out.println(p);
			}
		}

	}

}
