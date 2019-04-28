package teachersV1.exceptions;



@SuppressWarnings("serial")
public class EleveInconnu extends Exception {

	/**
	 * Affiche le message d'erreur.
	 * 
	 * @param message
	 *           .
	 */
	public EleveInconnu(String message) {
		super(message);
	}
}
