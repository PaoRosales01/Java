/**
 * Programa que guarda la posición del arreglo tipo índice por medio de los Setters & Getters 
 * como métodos de acceso lo que quiere decir que son declarados privados y sirven para dos cosas: 
 * Setters, nos sirve para asignar un valor inicial al atributo de forma explícita, 
 * permitiendo acceso público a ciertos atributos que deseemos el usuario pueda modificar.
 * Getters, nos sirve para obtener el valor ya asignado a un atributo y utilizarlo
 * para cierto método.
 * Por otro lado se creó esta clase que tiene Setters & Getters para que pueda ser utilizada/llamada 
 * en todas las otras clases que se vaya a emplear.
 * 
 * @author Paola Elizabeth Rosales Verdín - 2°B TI
 * @author Pablo Cesar Córdova Tapia - 2°B TI
 * @author Diana María Arellano Güereca - 2°B TI
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

	/*El método toString nos permite mostrar la información 
	completa de un objeto, es decir, el valor de sus atributos.*/
	
	@Override
	public String toString() {
		return "Indice [indice=" + indice + "]";
	}
}
