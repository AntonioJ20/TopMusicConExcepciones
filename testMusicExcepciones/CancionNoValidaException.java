package testMusicExcepciones;

public class CancionNoValidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CancionNoValidaException(String msj){
		super(msj);
	}
}
