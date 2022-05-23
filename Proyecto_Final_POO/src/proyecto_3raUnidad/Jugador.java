/**
 * Programa que guarda los datos del jugador registrado por medio de los Setters & Getters 
 * como m�todos de acceso lo que quiere decir que son declarados p�blicos y sirven para dos cosas: 
 * Setters, nos sirve para asignar un valor inicial al atributo de forma expl�cita, 
 * permitiendo acceso p�blico a ciertos atributos que deseemos el usuario puedo modificar.
 * Getters, nos sirve para obtener el valor ya asignado a un atributo y utilizarlo
 * para cierto m�todo.
 * Por otro lado se creo esta clase que tiene Setters & Getters para que pueda ser utilizada/llamada 
 * en todas las otras clases que se vaya a emplear.
 * 
 * @author Paola Elizabeth Rosales Verd�n - 2�B TI
 * @author Pablo Cesar C�rdova Tapia - 2�B TI
 * @author Diana Mar�a Arellano G�ereca - 2�B TI
 * @version 2019-12 (4.14.0) Creado el: 16/04/2020
 */
package proyecto_3raUnidad;

/** Clase hija de la clase padre, es decir que esta clase es heredada por
*   Agregar_Jugador ya que es ah� donde se implementar� */
public class Jugador {
	/** Creaci�n de variables de tipo String. */
		private String ID_Jugador, Nombre, Puntaje, Fecha, Record;
		
		//Getters y setters de atributos de la clase (encapsulaci�n)
		
		public String getID_Jugador() {
		return ID_Jugador;
		}

		public void setID_Jugador(String iD_Jugador) {
			ID_Jugador = iD_Jugador;
		}
	
		public String getNombre() {
			return Nombre;
		}
	
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
	
		public String getPuntaje() {
			return Puntaje;
		}
	
		public void setPuntaje(String puntaje) {
			Puntaje = puntaje;
		}
	
		public String getFecha() {
			return Fecha;
		}
	
		public void setFecha(String fecha) {
			Fecha = fecha;
		}
	
		public String getRecord() {
			return Record;
		}
		
	public void setRecord(String record) {
		Record = record;
	}

	/*El m�todo toString nos permite mostrar la informaci�n 
	completa de un objeto, es decir, el valor de sus atributos.*/
	
	@Override
	public String toString() {
		return "Jugador ID_Jugador: " + ID_Jugador + ", Nombre: " + Nombre + ", Puntaje: " + Puntaje + ", Fecha: " + Fecha
				+ ", R�cord: " + Record + "";
	}

}