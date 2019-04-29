package teachersV3V4.main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teachersV3V4.io.FileRead;
import teachersV3V4.io.FileReadService;
import teachersV3V4.jFreeChart.PieChart;

// c'est le main pour lancer le programme avec jfreechart
public class Main {

	/**
	 * On doit entrer la destination d'un fichier csv pour lire les données.
	 * 
	 * @param args
	 *           La liste des arguments
	 */
	public static void main(String[] args) {
		try {
			// Nom des arguments de commandes
			FileReadService fr = new FileRead();
			for (int i = 0; i < args.length; i++) {
				System.out.println("Lecture " + args[i]);
				String path = args[i];
				fr.read(path, ";");
			}

			/*
			 * On affiche la note des eleves
			 */
			for (int i = 0; i < FileRead.sList.size(); i++) {
				PieChart demo = new PieChart("Notes des eleves !", FileRead.sList
						.get(i).afficherNom(), FileRead.sList.get(i));
				demo.pack();
				demo.setVisible(true);

			}

			/*
			 * On affiche la moyenne des eleves dans une promotion
			 */
			for (int i = 0; i < FileRead.pList.size(); i++) {
				PieChart demo = new PieChart("Moyenne promotion !",
						FileRead.pList.get(i).getNom(), FileRead.pList.get(i));
				demo.pack();
				demo.setVisible(true);
			}

			try {
				System.out.println("Fichier csv non lu ou renseigné. Ecrire n'importe quoi pour arreter le programme.");
				Scanner sc = new Scanner(System.in);
				int res = sc.nextInt();
				System.out.println(res);
				System.exit(0);
			} catch (NoSuchElementException e) {
				System.out.println("Programme interrompu.");
			}

		} catch (IOException e) {
			System.err
					.println("Fichier non trouve . Avez vous mis la bonne destination?\n");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Erreur de colonnes trouver dans le fichier. Raison: "
					+ e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			System.err
					.println("/!\\ Svp formattez correctement votre fichier csv "
							+ e.getLocalizedMessage() + "\n");
		} catch (NoSuchElementException e) {
			System.err.println("Pas de reponse trouvée!");
		}
	}

}
