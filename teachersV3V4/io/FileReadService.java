package teachersV3V4.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import teachersV3V4.Professeur;
import teachersV3V4.Promotion;
import teachersV3V4.Eleve;


public abstract class FileReadService {

	
	public static ArrayList<Eleve> sList = new ArrayList<Eleve>();

	

	public static ArrayList<Professeur> profList = new ArrayList<Professeur>();

	
	public static ArrayList<Promotion> pList = new ArrayList<Promotion>();

	
	public void read(String filename, String separator) throws IOException {
		if (filename != null) {

			
			profList.removeAll(profList);
			BufferedReader reader = new BufferedReader(new java.io.FileReader(
					filename));

			String line;
			while ((line = reader.readLine()) != null) {

				final String[] tokens = line.split(separator);
				getLignes(tokens);
			}
			reader.close();
		}
	}

	
	public abstract void afficherLignes(String[] tokens);

	
	public abstract void getLignes(String[] tokens);

}
