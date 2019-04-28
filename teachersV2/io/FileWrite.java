package teachersV2.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import teachersV2.Professeur;
import teachersV2.exceptions.NotesVides;

public class FileWrite {

	
	private final String filename;

	
	public FileWrite(String filename) throws IOException {
		this.filename = filename;
	}

	
	public void write(String filename) throws FileNotFoundException {

		BufferedWriter writer = null;

		try {

			final FileWriter filewriter = new FileWriter(filename);
			writer = new BufferedWriter(filewriter);

			
			while (FileReadService.sList.size() > 0) {

				
				writer.write("1;" + FileReadService.sList.get(0).getNom()
						+ ";" + FileReadService.sList.get(0).getPrenom()
						+ ";" + FileReadService.sList.get(0).getId());
				writer.write("\n");

				writer.write("2;"
						+ FileReadService.sList.get(0).getP().getNom());
				writer.write("\n");

				Iterator<Professeur> it = FileReadService.sList.get(0)
						.getCorrecteurs().iterator();
				writer.write("3");
				while (it.hasNext()) {
					Professeur prof = it.next();
					writer.write(";" + prof.getNom() + ";"
							+ prof.getPrenom());
				}
				writer.write("\n");

				
				writer.write("4");
				for (int i = 0; i < FileReadService.sList.get(0).getNotes().length; i++) {
					if (FileReadService.sList.get(0).getNotes()[i] == null) {
						writer.write(";");
					} else {
						writer.write(";"
								+ FileReadService.sList.get(0).getNotes()[i]
										.toString());
					}
				}
				writer.write("\n");

				
				writer.write("5");
				for (int i = 0; i < FileReadService.sList.get(0).getNotes().length; i++) {
					if (FileReadService.sList.get(0).getNotes()[i] == null) {
						writer.write(";");
					} else {
						int index = FileRead.getProfesseur(FileReadService.sList
								.get(0).getNotes()[i].getCorrecteur());
						writer.write(";" + index);
					}
				}
				writer.write("\n");

				
				try {
					writer.write("6;" + FileReadService.sList.get(0).moyenne());
				} catch (NotesVides e) {
					e.printStackTrace();
				}

				FileReadService.sList.remove(0);
				writer.write("\n");
			}

			System.out.println("Ecriture terminée\n");

		} catch (IOException e) {
			e.printStackTrace(System.err);
		} finally {

			if (writer != null) {

				try {
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace(System.err);
				}

				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace(System.err);
				}

			}
		}

	}



	public String getFilename() {
		return filename;
	}

}
