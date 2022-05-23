/**
 * Programa que muestra la funcionalidad de la clase buscar anteriormente inicializada
 * en la clase Buscar_Jugador para llevar acabo la b�squeda del jugador.
 * 
 * @author Paola Elizabeth Rosales Verd�n - 2�B TI
 * @author Pablo Cesar C�rdova Tapia - 2�B TI
 * @author Diana Mar�a Arellano G�ereca - 2�B TI
 * @version 2019-12 (4.14.0) Creado el: 16/04/2020
 * 
 */

//Paquete del proyecto creado
package proyecto_3raUnidad;

public class I_buscar {
	private int i_buscar;
	
	//Getters y setters de la variable entera i_buscar

	public int getI_buscar() {
		return i_buscar;
	}

	public void setI_buscar(int i_buscar) {
		this.i_buscar = i_buscar;
	}

	
	/*El m�todo toString nos permite mostrar la informaci�n 
	completa de un objeto, es decir, el valor de sus atributos.*/
	
	@Override
	public String toString() {
		return "I_buscar [i_buscar=" + i_buscar + "]";
	}
	}

