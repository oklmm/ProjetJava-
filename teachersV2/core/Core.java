package teachersV2.core;

import java.util.InputMismatchException;
import java.util.Scanner;

import teachersV2.Professeur;
import teachersV2.Promotion;
import teachersV2.Eleve;
import teachersV2.io.FileRead;
import teachersV2.io.FileReadService;

public class Core {

	
	static final int NB_EVALUATIONS = 10;

	
	public final static String[] notes = new String[NB_EVALUATIONS];

	
	public static void initNotes() {
		for (int i = 0; i < notes.length; i++) {
			notes[i] = null;
		}
	}

	
	public static void afficherListeEleves() {
		if (FileReadService.sList.isEmpty()) {
			System.out.println("Pas d'eleves");
		} else {
			int i;
			for (i = 0; i < FileReadService.sList.size(); i++) {
				if (i < FileReadService.sList.size() - 1) {
					System.out.print(i + ":("
							+ FileReadService.sList.get(i).afficherNoms()
							+ "), ");
				} else {
					System.out
							.print(i
									+ ":("
									+ FileReadService.sList.get(i)
											.afficherNoms() + ")");
				}
			}
			System.out.println();
		}
	}

	
	public static void afficherEleve(int mode) {
		if (FileReadService.sList.isEmpty()) {
			System.out.println("Pas d'eleves dans le fichier");
		} else {
			System.out.println("Vous choisissez quel eleve");
			int i;
			for (i = 0; i < FileReadService.sList.size(); i++) {
				System.out.print(i + ":("
						+ FileReadService.sList.get(i).afficherNoms() + ") ");
			}
			System.out.println();
			Scanner scIndexS = new Scanner(System.in);

			Eleve s = null;
			while (s == null) {
				int iS = scIndexS.nextInt();
				s = ChoisirListesEleves(iS);
			}
			if (mode == 0) {
				System.out.println(s);
			} else {
				System.out.println(s.afficherMoyenne());
			}
		}
	}

	
	public static Eleve ChoisirListesEleves(int index) {
		Eleve s = null;
		try {
			s = FileReadService.sList.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choisir un eleve existant !");
			return null;
		}
		return s;
	}

	
	public static void displayProfessorList() {
		if (FileRead.profListFiles.isEmpty()) {
			System.out.println("Pas de professeur !");
		} else {
			int i;
			for (i = 0; i < FileRead.profListFiles.size(); i++) {
				System.out.print("(" + FileRead.profListFiles.get(i) + ") ");
			}
			System.out.println();
		}
	}

	
	public static void afficherListePromotion() {
		if (FileReadService.pList.isEmpty()) {
			System.out.println("Il n'ya pas de promotions !");
		} else {
			int i;
			for (i = 0; i < FileReadService.pList.size(); i++) {
				System.out.print(i + ":"
						+ FileReadService.pList.get(i).getNom() + " ");
			}
			System.out.println();
		}
	}

	
	public static void afficherPromotion() {
		if (FileReadService.pList.isEmpty()) {
			System.out.println("Pas de promotion!");
		} else {
			System.out.println("Vous choissez quelle promotion");
			afficherListePromotion();
			Scanner scIndexP = new Scanner(System.in);

			Promotion p = null;
			while (p == null) {
				int iP = scIndexP.nextInt();
				p = choosePromotionList(iP);
			}
			System.out.println(p);
		}
	}

	
	public static void addPromotionStudent() {
		if (FileRead.sList.isEmpty()) {
			System.out.println("Il n'ya pas d'eleves!");
		} else {
			System.out
					.println("Creer une promotion (0) ou choisir une promotion (2)");
			int res = -1;

			while (res < 0 || res > 1) {
				Scanner sc = new Scanner(System.in);
				res = sc.nextInt();
			}
			
			if (res == 0) {
				Scanner scName = new Scanner(System.in);
				System.out.print("Donner un nom: ");
				String name = scName.nextLine();
				Promotion pNew = new Promotion(name);

				
				boolean exist = false;
				for (int i = 0; i < FileRead.pList.size(); i++) {
					if (FileRead.pList.get(i).equals(pNew)) {
						exist = true;
					}
				}

				if (!exist) {
					FileRead.pList.add(pNew);
					System.out.println("Promotion " + pNew.getNom()
							+ " crée.");
				} else {
					System.out.println("La promotion existe deja!");
				}

				System.out.println("Vous voulez ajouter quel eleve ?");
				afficherListeEleves();
				Scanner scIndex = new Scanner(System.in);

				Eleve s = null;
				while (s == null) {
					int i = scIndex.nextInt();
					s = ChoisirListesEleves(i);
				}
				pNew.ajouter(s);
				System.out.println("Eleve " + s.afficherNoms()
						+ " ajouter à Promotion " + pNew.getNom());
    
				
			} else {
				if (FileRead.pList.isEmpty()) {
					System.out.println("Il n'a pas de promotions !");
				} else {
					System.out
							.println("Quelle promotion voulez vous ajouter? ?");
					afficherListePromotion();
					Scanner scIndexP = new Scanner(System.in);

					Promotion p = null;
					while (p == null) {
						int iP = scIndexP.nextInt();
						p = choosePromotionList(iP);
					}

					System.out.println("Quel eleve voulez vous ajouter ?");
					afficherListeEleves();
					Scanner scIndexS = new Scanner(System.in);

					Eleve s = null;
					while (s == null) {
						int iS = scIndexS.nextInt();
						s = ChoisirListesEleves(iS);
					}
					if (p.ajouter(s) != 0) {
						System.out.println("Eleve " + s.afficherNoms()
								+ " ajouté dans la promotion " + p.getNom());
					}
				}
			}
		}
	}

	
	public static Promotion choosePromotionList(int index) {
		Promotion p = null;
		try {
			p = FileReadService.pList.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choisir une promotion existante  !");
			return null;
		}
		return p;
	}

	
	public static int ajouterEleve(Eleve s) {
		if (s == null)
			return 0;
		FileReadService.sList.add(s);
		return 1;
	}

	public static Professeur ajouterProfesseurs(Professeur prof) {
		boolean exist = false;
		int pos = 0;
		if (prof == null)
			return null;
		for (int i = 0; i < FileReadService.profList.size(); i++) {
			if (FileReadService.profList.get(i).equals(prof)) {
				exist = true;
				pos = i;
			}
		}
		if (!exist) {
			FileReadService.profList.add(prof);
			return prof;
		}
		return FileReadService.profList.get(pos);
	}

	
	public static Promotion ajouterPromotion(Promotion p) {
		if (p == null)
			return null;

		
		boolean exist = false;
		int pos = 0;
		for (int i = 0; i < FileReadService.pList.size(); i++) {
			if (FileReadService.pList.get(i).equals(p)) {
				exist = true;
				pos = i;
			}
		}

		if (!exist) {
			FileReadService.pList.add(p);
			return p;
		}
		return FileReadService.pList.get(pos);
	}

	
	public static int ajouterNotes(int index, String value) {
		if ((index < 0 && index > 9)
				|| (Float.valueOf(value) < 0 && Float.valueOf(value) > 20))
			return 0;
		notes[index] = value;
		return 1;
	}

	
	public static int getIndexPromotion(Promotion p) {
		int i, pos = 0;
		for (i = 0; i < FileReadService.pList.size(); i++) {
			if (FileReadService.pList.get(i).equals(p)) {
				pos = i;
			}
		}
		return pos;
	}

	
	public static void TrierElevePromotion() {
		if (FileReadService.sList.isEmpty()) {
			System.out.println("Il n'a pas de promotions!");

		} else if (FileReadService.pList.isEmpty()) {
			System.out.println("Il n'ya pas de promotions!");

		} else {

			System.out
					.println("Trier en ordre croissant ou decroissant?");
			int mode = -1;
			while (mode < 0 || mode > 1) {
				Scanner scMode = new Scanner(System.in);
				mode = scMode.nextInt();
			}

			System.out.println("Quelle promotion voulez vous ?");
			afficherListePromotion();
			Scanner scIndexP = new Scanner(System.in);

			Promotion p = null;
			while (p == null) {
				int iP = scIndexP.nextInt();
				p = choosePromotionList(iP);
			}

			if (mode == 0) {
				p.trier(0);
				System.out.println(p);
			} else {
				p.trier(1);
				System.out.println(p);
			}
		}
	}

	
	public static Professeur ChoisirListeProfesseur(int index) {
		Professeur prof = null;
		try {
			prof = FileRead.profListFiles.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choisir un professeur dans la liste !");
			return null;
		}
		return prof;
	}

	
	public static void gererNotes() {
		if (FileReadService.sList.isEmpty()) {
			System.out.println(" PAS D'ELEVES !");

		} else if (FileRead.profListFiles.isEmpty()) {
			System.out.println("Pas de professeurs !");
		} else if (FileReadService.pList.isEmpty()) {
			System.out.println("Pas de promotion !");
		} else {

			System.out.println("Quel professeur voulez vous?");
			displayProfessorList();
			Scanner scIndexProf = new Scanner(System.in);

			Professeur prof = null;
			while (prof == null) {
				int iProf = scIndexProf.nextInt();
				prof = ChoisirListeProfesseur(iProf);
			}

			System.out.println("Quel eleve voulez vous notez ?");
			afficherListeEleves();
			Scanner scIndexS = new Scanner(System.in);

			Eleve s = null;
			while (s == null) {
				int iS = scIndexS.nextInt();
				s = ChoisirListesEleves(iS);
			}

			if (s.getP().equals(null)) {
				System.out.println("Cet eleve n'a pas de promotions !");
			} else {
				System.out.print("Donnez une note: ");
				int valeur = -1;
				while (valeur < 0 || valeur > 20) {
					Scanner scValue = new Scanner(System.in);
					valeur = scValue.nextInt();
				}
				System.out.print("Dites ou vous voulez mettre la note  : ");
				int index = -1;
				while (index < 0 || index > 10) {
					Scanner scIndex = new Scanner(System.in);
					index = scIndex.nextInt();
				}
				prof.setNote(s.getP(), s.getId(), valeur, index);

				System.out.println("Donner une valeur " + valeur
						+ " Ajouter a un eleve " + s.afficherNoms()
						+ " Avec un correcteur " + prof);
			}
		}

	}

	
	public static int CreationEleve() {
		System.out.println("=== Creation d'eleve ===");
		Scanner scId = new Scanner(System.in);
		System.out.print("Donnez un nom: ");
		String nom = "";
		while (nom.equals("")) {
			Scanner scName = new Scanner(System.in);
			nom = scName.nextLine();
		}
		System.out.print("Donnez un prenom: ");
		String prenom = "";
		while (prenom.equals("")) {
			Scanner scForename = new Scanner(System.in);
			prenom = scForename.nextLine();
		}
		System.out.print("Donnez un id: ");
		try {
			int id = scId.nextInt();
			Eleve eleve = new Eleve(nom, prenom, id);

			
			boolean exist = false;
			for (int i = 0; i < FileReadService.sList.size(); i++) {
				if (FileReadService.sList.get(i).equals(eleve)) {
					exist = true;
				}
			}

			if (!exist) {
				FileReadService.sList.add(eleve);
				System.out.println("Eleve " + eleve.afficherNoms()
						+ " cree.");
			} else {
				System.out.println("Cet eleve existe deja !");
			}

			System.out.println();
		} catch (InputMismatchException e) {
			System.out.println("Entre un nombre valide !");
			return 0;
		}

		return 1;
	}

	
	public static void CreationProfesseur() {
		System.out.println("=== Creation de professeur ===");
		System.out.print("Donnez un nom: ");
		String name = "";
		while (name.equals("")) {
			Scanner scName = new Scanner(System.in);
			name = scName.nextLine();
		}
		System.out.print("Donnez un prenom: ");
		String forename = "";
		while (forename.equals("")) {
			Scanner scForename = new Scanner(System.in);
			forename = scForename.nextLine();
		}
		Professeur prof = new Professeur(name, forename);

		boolean exist = false;
		for (int i = 0; i < FileRead.profListFiles.size(); i++) {
			if (FileRead.profListFiles.get(i).equals(prof)) {
				exist = true;
			}
		}

		if (!exist) {
			FileRead.profListFiles.add(prof);
			System.out.println("Professeur " + prof + " cree.");
		} else {
			System.out.println("Ce professeur n'existe pas!");
		}
		System.out.println();
	}

	
	public static void gererEleves() {
		System.out.print("Vous voulez ajouter (1) ou supprimer un eleve (2)? ");

		int res = -1;

		while (res < 0 || res > 1) {
			Scanner sc = new Scanner(System.in);
			res = sc.nextInt();
		}

		switch (res) {
		case 0:
			CreationEleve();
			break;
		case 1:
			if (FileReadService.sList.isEmpty()) {
				System.out.println("Il n'a pas d'eleves!");
			} else {
				System.out.println("Vous voulez supprimer un eleve?");
				afficherListeEleves();
				Scanner scIndexS = new Scanner(System.in);

				Eleve s = null;
				while (s == null) {
					int iS = scIndexS.nextInt();
					s = ChoisirListesEleves(iS);
					FileReadService.pList.get(iS).supprimer(s);
				}
				FileReadService.sList.remove(s);
				System.out.println("Un eleve " + s.afficherNoms()
						+ " a été supprimé.");
			}
			break;
		default:
			CreationEleve();
			break;
		}
	}

	
	public static void manageProfessors() {

		System.out.print("Vous voulez supprimer un professeur? ");

		int res = -1;

		while (res < 0 || res > 1) {
			Scanner sc = new Scanner(System.in);
			res = sc.nextInt();
		}

		switch (res) {
		case 0:
			CreationProfesseur();
			break;
		case 1:
			if (FileRead.profListFiles.isEmpty()) {
				System.out.println("Il n'y a pas de professeur !");
			} else {
				System.out.println("Quel professeur voulez vous?");
				displayProfessorList();
				Scanner scIndexProf = new Scanner(System.in);

				Professeur prof = null;
				while (prof == null) {
					int iProf = scIndexProf.nextInt();
					prof = ChoisirListeProfesseur(iProf);

				}
				FileRead.profListFiles.remove(prof);
				System.out.println("Le professeur " + prof
						+ " est supprimé.");
			}
			break;
		default:
			CreationProfesseur();
			break;
		}

	}

}
