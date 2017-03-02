package testMusicExcepciones;

import java.util.ArrayList;
import java.util.Collections;

public class Lista{
	
	private ArrayList<Cancion> lista = null;
	
	
	Lista(){
		lista = new ArrayList<Cancion>();
	}

	/**
	 * A�ade un elemento al final de la lista
	 * @param T element El elemento que se va a a�adir
	 */
	void addLista(Cancion element){
		lista.add(null);
	}
	
	/**
	 * A�ade un elemento en la posici�n indicada
	 * @param T element El elemento que va a a�adirse
	 * @param posicion La posici�n en la que se va a a�adir el elemento
	 */
	void annadir(String titulo, String autor, int fecha, int posicion) throws 
					CancionNoValidaException, AutorNoValidoException, FechaNoValidaException,PosicionNoValidaException{
		try{
			Cancion cancion = new Cancion(titulo, autor, fecha);
			lista.add(posicion, cancion);
		} catch(IndexOutOfBoundsException e){
		throw new PosicionNoValidaException("Error. La posici�n no es v�lida.");
		}
	}
	
	/**
	 * Elimina un elemento de la posici�n indicada
	 * @param posicion La posici�n cuyo elemento va a ser eliminado
	 */
	Cancion sacar(int posicion) throws PosicionNoValidaException{
		try{
		return lista.remove(posicion);
		} catch(IndexOutOfBoundsException e){
			throw new PosicionNoValidaException("Error. La posici�n no es v�lida.");
		}
	}
	
	/**
	 * Sube un puesto un elemento de la lista
	 * @param posicion La posici�n del elemento que va a retroceder un puesto
	 */
	void subir(int posicion) throws PosicionNoValidaException{
		try{
			int posicion1 = lista.indexOf(lista.get(posicion)); // posici�n del elemento que va a retroceder un puesto
			int posicion2 = posicion1 - 1;	// posici�n del elemento anterior al elemento que avanza un puesto
			Collections.swap(lista, posicion1, posicion2);	// cambia dos elementos de posici�n entre s�	
		} catch(IndexOutOfBoundsException e){
			throw new PosicionNoValidaException("Error. La posici�n no es v�lida.");
		}
	}
	
	/**
	 * Baja un puesto un elemento de la lista
	 * @param posicion La posici�n del elemento que va a avanzar un puesto
	 * @throws PosicionNoValidaException 
	 */
	void bajar(int posicion) throws PosicionNoValidaException{
		try{
			int posicion1 = lista.indexOf(lista.get(posicion));
			int posicion2 = posicion1 + 1;
			Collections.swap(lista, posicion1, posicion2);		
		} catch(IndexOutOfBoundsException e){
			throw new PosicionNoValidaException("Error. La posici�n no es v�lida.");
		}
	}
	
	/**
	 * Obtiene el primer elemento de la lista
	 * @return El primer elemento de la lista
	 */
	Cancion mostrarTop(){
		return lista.get(0);		
	}
	
	/**
	 * toString, modificar en cada aplicaci�n particular de lista
	 */
	@Override
	public String toString() {
		if(lista.get(0)==null)
			return "Lista vac�a\n";
		return "TopMusic\n" + lista + "\n ";
	}	
}
