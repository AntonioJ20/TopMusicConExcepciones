package testMusicExcepciones;
import utiles.*;

public class TestTopMusic {

	public static void main(String[] args) {
		
		String tituloMenu = "TopMusic";
		String[] opcionesMenu = {"A�adir canci�n en una posici�n espec�fica",
								"Sacar canci�n del TopMusic", "Subir puesto",
								"Bajar puesto", "Mostrar TopMusic",
								"Mostrar el TOP del topMusic"};
		
		Menu menu = new Menu(tituloMenu, opcionesMenu);
		
		Lista lista = new Lista();
		lista.addLista(null);
		int opcion;
		do{
			opcion=menu.gestionar();
			
			switch(opcion){
				
			case 1:
				annadir(lista);
				break;
			
			case 2:
				sacar(lista);
				break;
			
			case 3:
				subir(lista);
				break;
				
			case 4:
				bajar(lista);
				break;
				
			case 5:
				System.out.println(lista);
				break;
				
			case 6:
				mostrarTop(lista);
				break;				
			
			case 7:
				break;
				
			default:
				error();
			}
			
		}while(opcion!=7);
	}

	
	/**
	 * A�ade una canci�n a la lista en la posici�n indicada
	 * @param lista La lista en la que se a�ade la canci�n
	 */
	private static void annadir(Lista lista){
		
		try {
			lista.annadir(Teclado.leerCadena("T�tulo de la canci�n a a�adir: "), 
					Teclado.leerCadena("Artista/grupo de la canci�n a a�adir: "), 
					Teclado.leerEntero("A�o de grabaci�n de la canci�n a a�adir: "), 
					(Teclado.leerEntero("Posici�n en la que se introducir� la nueva canci�n: ")) + 1);
		} catch (CancionNoValidaException | AutorNoValidoException | FechaNoValidaException | PosicionNoValidaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	
	/**
	 * Elimina una canci�n de la posici�n indicada de la lista
	 * @param lista La lista en la que se elimina la canci�n
	 */
	private static void sacar(Lista lista){
		try {
			lista.sacar(Teclado.leerEntero("Posici�n de la canci�n que se va a eliminar: "));
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}			
		}
	
	/**
	 * Sube un puesto una canci�n de la lista seg�n su posici�n actual
	 * @param lista La lista con la que se trabaja
	 */
	private static void subir(Lista lista){				
		try {
			lista.subir((Teclado.leerEntero("Posici�n de la canci�n que va a subir un puesto: ")) + 1);
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Baja un puesto una canci�n de la lista seg�n su posici�n actual
	 * @param lista La lista con la que se trabaja
	 */
	private static void bajar(Lista lista){
		try{
			lista.bajar((Teclado.leerEntero("Posici�n de la canci�n que va a bajar un puesto: ")) + 1);
		} catch (PosicionNoValidaException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Muestra la canci�n en primera posici�n
	 * @param lista La lista con la que se trabaja
	 */
	private static void mostrarTop(Lista lista){		
			System.out.println(lista.mostrarTop());
	}
	
	/**
	 * Muestra un mensaje de error
	 */
	private static void error(){
		System.out.println("Error. Opci�n no v�lida.\n");
	}
}