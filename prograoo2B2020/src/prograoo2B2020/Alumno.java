/** 
 * Clase alumno donde se crearon getters y setters de las variables
 * para registrar a los alumnos y proceder a la impresi�n de la 
 * informaci�n ingresada
 * 
 * @author Paola Elizabeth Rosales Verd�n - 2�B TI
 * @version 2019-12 (4.14.0) Creado el: 27/03/2020
 * 
 */

//Paquete del proyecto creado
package prograoo2B2020;

/** Clase hija de la clase padre, es decir que esta clase es heredada por
 *  VGenerales ya que es ah� donde se implementar� */
public class Alumno {
	/** Creaci�n de variables de tipo String. */
		private String matricula, nombre, direccion;
		
		//Getters y setters de atributos de la clase (encapsulaci�n)
		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		//Imprimir cada objeto:
		@Override
		public String toString() {
			return "Alumno [matricula=" + matricula + ", nombre=" + nombre + ", direccion=" + 
					direccion + "]";
		}

}



















