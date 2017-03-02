package testMusicExcepciones;

public class Cancion {
	
	String titulo;
	String autor;
	int fecha;
	
	Cancion(String titulo, String autor, int fecha) 
			throws CancionNoValidaException, AutorNoValidoException, 
			FechaNoValidaException{
		setTitulo(titulo);
		setArtista(autor);
		setAnnoGrabacion(fecha);
		
	}

	String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) throws CancionNoValidaException {
		if(titulo.length()!=0)
			this.titulo = titulo;
		else
			throw new CancionNoValidaException("La canción no es válida.");
	}

	String getArtista() {
		return autor;
	}

	private void setArtista(String autor) throws AutorNoValidoException {
		if(autor.length()!=0)
			this.autor=autor;
		else
			throw new AutorNoValidoException("El autor no es válido.");
	}

	int getAnnoGrabacion() {
		return fecha;
	}

	private void setAnnoGrabacion(int annoGrabacion) throws FechaNoValidaException {
		if(annoGrabacion>1877 || annoGrabacion<2016)
			this.fecha=annoGrabacion;
		else
			throw new FechaNoValidaException("La fecha no es válida.");
	}

	@Override
	public String toString() {
		return "Cancion [Cancion=" + titulo + ", Autor=" + autor + ", Fecha=" + fecha + "\n]";
	}
}
