package teachersV1.main;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class MainInteract {

	public static void main(String[] args) {

		try {
			while (true) { 
				System.out.println(Interaction.menu());
				int res = -1;

				while (res < 0 || res > 9) {
					Scanner sc = new Scanner(System.in);
					res = sc.nextInt();
				}

				switch (res) {
				case 0:
					Interaction.creerEleve();
					break;
				case 1:
					Interaction.creerProfesseur();
					break;
				case 2:
					Interaction.ajouterEleve();
					break;
				case 3:
					Interaction.ajouterNotes();
					break;
				case 4:
					Interaction.afficherPromotion();
					break;
				case 5:
					Interaction.afficherEleve(0);
					break;
				case 6:
					Interaction.afficherEleve(1);
					break;
				case 7:
					Interaction.TrierElevesPromotion(0);
					break;
				case 8:
					Interaction.TrierElevesPromotion(1);
					break;
				case 9: default:
					System.out.println("Fin du programme.");
					System.exit(0);
					break;
				}

			}
		} catch (NoSuchElementException e) {
			System.out.println("Programme interommpu’.");
		}
	}

}
