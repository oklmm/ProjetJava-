package teachersV1.main;

import teachersV1.Professeur;
import teachersV1.Promotion;
import teachersV1.Eleve;
import teachersV1.exceptions.EleveInconnu;


public class Main {
        @SuppressWarnings("empty-statement")
	public static void main(String[] args) {

		Promotion p1 = new Promotion("2021");
		Promotion p2 = new Promotion("2020");

		/**
		 * .
		 */
		Eleve student1 = new Eleve("Abdou", "Kane", 1);
		Eleve student2 = new Eleve("Adin", "Hrelja", 2);
		Eleve student3 = new Eleve("Wesh", "Morray", 3);

		Professeur prof1 = new Professeur("Patrick", "Teller");
		Professeur prof2 = new Professeur("Olga", "Mekhelova");

		/**
		 * Mettre les eleves dans leur promotion
		 * 
		 
		 */
		p1.add(student1);
		p1.add(student2);
		p2.add(student3);

		
		 ;
		prof2.setNote(p1, 1, 13, 1);
		prof1.setNote(p1, 1, 15, 7);

		prof1.setNote(p1, 2, 18, 0);
		prof1.setNote(p1, 2, 16, 3);
		prof1.setNote(p1, 2, 15, 5);

		

		try {
			System.out.println(p1.search(1));
			System.out.println(p1.search(2));
			
			System.out.println(p2.search(3));
			
			System.out.println(p1.search(5));
		} catch (EleveInconnu e) {
			System.out.println(e.getMessage());
		}

		/**
		 * Affiche la moyenne des eleves 
		 */
		System.out.println();
		System.out.println(student1.afficherMoyennes());
		System.out.println(student2.afficherMoyennes());
		System.out.println(student3.afficherMoyennes());

		/**
		 * Trier les promotions.
		 */
		System.out.println();
		System.out.println("Ordre croissant :");
		p1.sort(0);
		System.out.println(p1);

		System.out.println("Ordre descendant :");
		p1.sort(1);
		System.out.println(p1);
	}
}
