package teachersV2.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class FileWriteService {

	
	public static void runWrite() throws FileNotFoundException {
		if (FileReadService.sList.isEmpty()) {
			System.out.println("Il n'ya pas d'eleves!");
		} else {
			for (int i = 0; i < FileReadService.sList.size(); i++) {
				try {
					
					if (FileReadService.sList.get(i).getP().equals(null))
						;
				} catch (NullPointerException e) {
					System.out.println("L'eleve"
							+ FileReadService.sList.get(i).afficherNoms()
							+ " n'a pas de promotion !");
				}
			
				if (FileReadService.sList.get(i).getCorrecteurs().isEmpty()) {
					System.out.println("L'eleve "
							+ FileReadService.sList.get(i).afficherNoms()
							+ " n'a pas de correcteur !");
					
				} else if (FileReadService.sList.get(i).getNotes().equals(null)) {
					System.out.println("L'eleve "
							+ FileReadService.sList.get(i).afficherNoms()
							+ " n'a pas de notes!");
				} else {
					System.out.println("Choisir une destination de sauvegarde (...\\file.csv) :");

					Scanner sc = new Scanner(System.in);
					String filename = sc.nextLine();

					FileWrite fw = null;
					try {
						fw = new FileWrite(filename);
					} catch (IOException e) {
						e.printStackTrace();
					}
					fw.write(filename);
				}
			}
		}
	}
}
