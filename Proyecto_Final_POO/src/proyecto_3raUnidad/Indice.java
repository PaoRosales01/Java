/**
 * Programa que guarda la posici�n del arreglo tipo �ndice por medio de los Setters & Getters 
 * como m�todos de acceso lo que quiere decir que son declarados privados y sirven para dos cosas: 
 * Setters, nos sirve para asignar un valor inicial al atributo de forma expl�cita, 
 * permitiendo acceso p�blico a ciertos atributos que deseemos el usuario pueda modificar.
 * Getters, nos sirve para obtener el valor ya asignado a un atributo y utilizarlo
 * para cierto m�todo.
 * Por otro lado se cre� esta clase que tiene Setters & Getters para que pueda ser utilizada/llamada 
 * en todas las otras clases que se vaya a emplear.
 * 
 * @author Paola Elizabeth Rosales Verd�n - 2�B TI
 * @author Pablo Cesar C�rdova Tapia - 2�B TI
 * @author Diana Mar�a Arellano G�ereca - 2�B TI
 * @version 2019-12 (4.14.0) Creado el: 16/04/2020
 * 
 */

//Paquete del proyecto creado
package proyecto_3raUnidad;

public class Indice {
	private int indice;
	
	//Getters y setters de la variable entera indice

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	/*El m�todo toString nos permite mostrar la informaci�n 
	completa de un objeto, es decir, el valor de sus atributos.*/
	
	@Override
	public String toString() {
		return "Indice [indice=" + indice + "]";
	}
}
