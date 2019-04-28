package teachersV2.main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teachersV2.Professeur;
import teachersV2.Promotion;
import teachersV2.Eleve;
import teachersV2.exceptions.EleveInconnu;
import teachersV2.core.Core;
import teachersV2.io.FileRead;
import teachersV2.io.FileReadService;
import teachersV2.io.FileWriteService;

public class Main {

	
	public static String menu() {
		StringBuilder sb = new StringBuilder();

		sb.append("========== Menu ==========\n");
		sb.append("0- Faire tous les tests ! (Fichier .csv vide)\n");
		sb.append("1- Afficher tous les eleves\n");
		sb.append("2- Afficher tous les professeurs\n");
		sb.append("3- Afficher une promotion\n");
		sb.append("4- Afficher un eleve (nom, promotion, notes, correcteurs)\n");
		sb.append("5- Afficher un eleve avec son nom et moyenne\n");
		sb.append("6- Trier les eleves d'une promotion\n");
		sb.append("7- Gerer les notes \n");
		sb.append("8- Gerer les eleves\n");
		sb.append("9- Gerer les professeurs\n");
		sb.append("10- Gerer une promotion\n");
		sb.append("11- Sauvegarder un fichier\n");
		sb.append("12- Quitter le Programme");

		return sb.toString();
	}
	

	public static void allTests() {
		Promotion p1 = new Promotion("2021");
		Core.ajouterPromotion(p1);
		Promotion p2 = new Promotion("2020");
		Core.ajouterPromotion(p2);

		
		Eleve student1 = new Eleve("Adin", "Hrelja", 1);
		Core.ajouterEleve(student1);
		Eleve student2 = new Eleve("Abdou", "Kane", 2);
		Core.ajouterEleve(student2);
		Eleve student3 = new Eleve("Wesh", "Morray", 3);
		Core.ajouterEleve(student3);

		Professeur prof1 = new Professeur("Olga", "Mekhelova");
		Core.ajouterProfesseurs(prof1);
		Professeur prof2 = new Professeur("Patrick", "Teller");
		Core.ajouterProfesseurs(prof2);

		
		p1.ajouter(student1);
		p1.ajouter(student2);
		p2.ajouter(student3);

		
		prof1.setNote(p1, 1, 12, 0);
		prof2.setNote(p1, 1, 13, 1);
		prof1.setNote(p1, 1, 15, 7);

		prof1.setNote(p1, 2, 18, 0);
		prof1.setNote(p1, 2, 16, 3);
		prof1.setNote(p1, 2, 15, 5);
		
		prof1.setNote(p2, 3, 20, 6);

		
		try {
			System.out.println(p1.search(1));
			System.out.println(p1.search(2));
			System.out.println(p2.search(3));
		} catch (EleveInconnu e) {
			System.out.println(e.getMessage());
		}

		
		System.out.println();
		System.out.println(student1.afficherMoyenne());
		System.out.println(student2.afficherMoyenne());
		System.out.println(student3.afficherMoyenne());

		
		System.out.println();
		System.out.println("ORDRE CROISSANT :");
		p1.trier(0);
		System.out.println(p1);

		System.out.println("ORDRE DECROISSANT :");
		p1.trier(1);
		System.out.println(p1);
	}

	
	public static void main(String[] args) {

		try {
			
			FileReadService fr = new FileRead();
			for (int i = 0; i < args.length; i++) {
				System.out.println("lECTURE: " + args[i]);
				String path = args[i];
				fr.read(path, ";");
			}

			try {
				while (true) { 
					System.out.println(menu());
					int res = -1;

					while (res < 0 || res > 12) {
						Scanner sc = new Scanner(System.in);
						res = sc.nextInt();
					}

					switch (res) {
					case 0:
						allTests();
						FileWriteService.runWrite();
						System.out.println("FIN DU PROGRAMME");
						System.exit(0);
						break;
					case 1:
						Core.afficherListeEleves();
						break;
					case 2:
						Core.displayProfessorList();
						break;
					case 3:
						Core.afficherPromotion();
						break;
					case 4:
						Core.afficherEleve(0);
						break;
					case 5:
						Core.afficherEleve(1);
						break;
					case 6:
						Core.TrierElevePromotion();
						break;
					case 7:
						Core.gererNotes();
						break;
					case 8:
						Core.gererEleves();
						break;
					case 9:
						Core.manageProfessors();
						break;
					case 10:
						Core.addPromotionStudent();
						break;
					case 11:
						FileWriteService.runWrite();
						System.out.println("FIN DU PROGRAMME");
						System.exit(0);
						break;
					case 12: default:
						System.out.println("FIN DU PROGRAMME");
						System.exit(0);
						break;
					}

				}
			} catch (NoSuchElementException e) {
				System.out.println("INTERROMPRE LE PROGRAMME");
			}
		} catch (IOException e) {
			System.err
					.println("FICHIER NON TROUVE \n");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Erreur dans les colonnes du fichier "
					+ e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			System.err
					.println("/!\\ Formattez bien votre fichier csv "
							+ e.getLocalizedMessage() + "\n");
		} catch (NoSuchElementException e) {
			System.err.println("Pas de reponses trouvé!");
		}
	}
}
