package teachersV2.io;

import java.util.ArrayList;

import teachersV2.Professeur;
import teachersV2.Promotion;
import teachersV2.Eleve;
import teachersV2.core.Core;


public class FileRead extends FileReadService {

	
	public static Eleve eleve = null;

	
	public static Professeur professeur = null;

	
	public static Promotion promotion = null;
	
	
	public static ArrayList<Professeur> profListFiles = new ArrayList<Professeur>();

	
	public static int nombreDeleves = 0;

	public static int addProfessorEachFile(Professeur prof) {
		if(prof == null) return 0;
		for(int i = 0; i < profListFiles.size(); i++) {
			if(profListFiles.get(i).equals(prof)) {
				return 0;
			}
		}
		profListFiles.add(prof);
		return 1;
	}
	
	public static int getProfesseur(Professeur prof) {
		int pos = 0;
		if(prof == null) return -1;
		for(int i = 0; i < profListFiles.size(); i++) {
			if(profListFiles.get(i).equals(prof)) {
				pos = i;
			}
		}
		return pos;
	}
	
	@Override
	public void afficherLignes(String[] tokens) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < tokens.length; i++) {
			if (i != tokens.length - 1) {
				sb.append(tokens[i] + ", ");
			} else {
				sb.append(tokens[i]);
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	@Override
	public void getLignes(String[] tokens) {
		int n = Integer.valueOf(tokens[0]);

		switch (n) {

		case 1:
			Eleve s = new Eleve(tokens[1], tokens[2],
					Integer.valueOf(tokens[3]));
			Core.ajouterEleve(s);
			eleve = s;
			break;
		case 2:
			Promotion p = new Promotion(tokens[1]);
			
			if (Core.ajouterPromotion(p) == p) {
				p.ajouter(eleve);
				
			} else {
				Core.ajouterPromotion(p).ajouter(eleve);
			}
			promotion = p;
			break;
		case 3:
			int i = 1;
			while (i != tokens.length) {
				Professeur prof = new Professeur(tokens[i], tokens[i + 1]);

				Core.ajouterProfesseurs(prof);
				addProfessorEachFile(prof);
				
				i = i + 2;
				professeur = prof;
			}
			break;
		case 4:
			Core.initNotes();
			int iMarks;
			for (iMarks = 1; iMarks < tokens.length; iMarks++) {
				if (!tokens[iMarks].equals("")) {
					Core.ajouterNotes(iMarks - 1, tokens[iMarks]);
				}
			}
			break;
		case 5:
			int iProf;
			for (iProf = 1; iProf < tokens.length; iProf++) {
				if (!tokens[iProf].equals("")) {
					
					FileReadService.profList.get(Integer.valueOf(tokens[iProf])).setNote(FileReadService.pList.get(Core.getIndexPromotion(promotion)),
							eleve.getId(),
							Float.valueOf(Core.notes[iProf - 1]), iProf - 1);
				}
			}
			break;
		default:
			break;
		}

	}
}
