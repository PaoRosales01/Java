/** 
 * Programa para hacer el registro de 3 alumnos, la información que 
 * se solicita es: matrícula, nombre y dirección. Al hacer clic en el botón
 * de aceptar cada alumno será registrado, al hacer clic en el botón de borrar
 * se eliminará el texto que se encuentre en los campos/cuadros de texto, el 
 * botón de imprimir mostrará en consola los datos previamente registrados, el botón
 * de eliminar eliminará un alumno según una matrícula previamente ingresada, el 
 * botón de buscar hará una búsqueda en los datos que se tienen y según la
 * información ingresada se completaran los campos de texto correspondientes y el
 * botón modificar hará cambios en el campo que sufrió modificaciones.
 * 
 * @author Paola Elizabeth Rosales Verdín - 2°B TI
 * @version 2019-12 (4.14.0) Creado el: 01/04/2020
 * 
 */

//Paquete del proyecto creado
package prograoo2B2020;

//Librerías
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* La línea @SuppressWarnings("serial") le dice a Java que no recuerde 
 * que se ha omitido algo llamado campo serialVersionUID. En otras palabras, 
 * la anotación SuppressWarnings le dice a Java que no muestre una advertencia. 
 * Sin una anotación de SuppressWarnings, Java le advierte sobre la falta de 
 * un campo serialVersionUID.
 */

@SuppressWarnings("serial")

/** Utilizar palabra reservada extends y heredar características y
 * métodos de JFrame.
 * Action Listener sirve para creación de eventos en botones 
 * que se colocarán, de igual manera en la clase se declaran las 
 * variables que se utilizarán a lo largo del proyecto.
 */
public class VGenerales extends JFrame implements ActionListener { 	
																	
	//Etiquetas que tendrán descripción.
	private JLabel lbl_matricula, lbl_nombre, lbl_direccion, lbl_mensaje;
	//Campos que sirven para introducir datos.
	private JTextField tf_matricula, tf_nombre, tf_direccion;
	//Botones de aceptar, imprimir, borrar, eliminar, buscar y modificar.
	private JButton btn_aceptar, btn_borrar, btn_imprimir, btn_eliminar, btn_buscar, btn_modificar;
	//Array de tipo alumno.
	private Alumno[] alumno;
	//Manejo de indice de datos y posición a buscar.
	private int indice, i_buscar;
	
	/** Método constructor sirve para hacer la inicialización de 
	    las variables o los atributos de la clase. */
	public VGenerales() {
		//Llamar metodo constructor de clase padre:
		super();
		//Título de la ventana:
		setTitle("Datos generales");
		//Tamaño de la ventana:
		setSize(500,200);
		//Forma en la cual se acomodaran los elementos en
		//la ventana:
		setLayout(new FlowLayout());
		//Al hacer clic en "cerrar" se terminará la ejecución
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Crear objetos de etiquetas (Jlabel):
		lbl_matricula = new JLabel ("Matricula");
		lbl_nombre = new JLabel ("Nombre");
		lbl_direccion = new JLabel ("Dirección");
		lbl_mensaje = new JLabel ("");
		
		//Crear objetos de campos de texto (JTextField):
		tf_matricula = new JTextField(10);
		tf_nombre = new JTextField (20);
		tf_direccion = new JTextField (20);
		
		//Crear objetos de botones (JButton):
		btn_aceptar = new JButton("Aceptar");
		//Evento de botón
		btn_aceptar.addActionListener(this);
		btn_borrar = new JButton("Borrar");
		//Evento de botón
		btn_borrar.addActionListener(this);
		btn_imprimir = new JButton("Imprimir");
		//Evento de botón
		btn_imprimir.addActionListener(this);
		btn_eliminar = new JButton("Eliminar");
		//Evento de botón
		btn_eliminar.addActionListener(this);
		btn_buscar = new JButton("Buscar");
		//Evento de botón
		btn_buscar.addActionListener(this);
		btn_modificar = new JButton("Modificar");
		//Evento del botón
		btn_modificar.addActionListener(this);
		/*Botón modificar inactivo para evitar errores
		o ingreso de datos incorrectos. */
		btn_modificar.setEnabled(false);
		
		//Agregar objetos a la ventana
		add (lbl_matricula);
		add (tf_matricula);
		
		add (lbl_nombre);
		add (tf_nombre);
		
		add (lbl_direccion);
		add (tf_direccion);
		
		add (btn_aceptar);
		add (btn_buscar);
		add (btn_eliminar);
		add (btn_modificar);
		add (btn_borrar);
		add (btn_imprimir);
		
		add(lbl_mensaje);
		
		indice = 0;
		i_buscar = -1;
		alumno = new Alumno[3];
		
		//Establecer que la ventana sea visible.
		setVisible(true);
	}
	
	//Método estático "main"
	public static void main(String[] args) {
		//Objetos:
		VGenerales ventana = new VGenerales();

	}
	
	/** Cualquier evento que suceda en mi ventana se ejecutará
	en este metodo que esta sobreescrito de action listener. */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*Si el botón que realizó el evento fue aceptar,
		entonces:*/
		if(e.getSource() == btn_aceptar) {
			//Obtener texto que esta en el TextField "Matricula, Nombre y dirección"
			alumno[indice] = new Alumno();
			alumno[indice].setMatricula(tf_matricula.getText().toString());
			alumno[indice].setNombre(tf_nombre.getText().toString());
			alumno[indice].setDireccion( tf_direccion.getText().toString());
			indice++;
			lbl_mensaje.setText("Alumno agregado");
		}
		
		/*Si el botón que realizó el evento fue imprimir,
		  entonces: */
		if (e.getSource() == btn_imprimir)
		{
			//Imprime los datos introducidos en los TextField
			for (int i=0;i<3;i++) {
			System.out.println(alumno[i].toString());
			}
		}
		
		/*Si el boton que realizó el evento fue borrar, 
		  entonces: */
		if (e.getSource( ) == btn_borrar)
		{
			//Cadena vacía para eliminar datos
			tf_matricula.setText("");
			tf_nombre.setText("");
			tf_direccion.setText("");
			lbl_mensaje.setText("");
			btn_modificar.setEnabled(false);
		}
		
		/*Si el boton que realizó el evento fue eliminar, 
		  entonces: */
		if (e.getSource() == btn_eliminar)
		{
			/** Hacer búsqueda del elemento/alumno que eliminare
			para saber en que índice esta*/
			int i_borrar= -1;
			//Alumno a borrar
			String a_borrar = "";
			//Obtener el alumno a borrar
			a_borrar = tf_matricula.getText().toString();
			//
			for (int i=0;i<3;i++)
			{
				if(alumno[i].getMatricula().equals(a_borrar))
				{
					i_borrar = i;
				}		
			}
			if (i_borrar == -1)
			{
				lbl_mensaje.setText("No se encontró la matrícula");
			}
			else
			{
				for (int i=i_borrar; i<2; i++)
				{
					alumno[i] = alumno[i+1];
				}
				indice--;
				lbl_mensaje.setText("Alumno eliminado");
			}
		}
		
		/*Si el boton que realizó el evento buscar, 
		  entonces: */
		if (e.getSource()==btn_buscar)
		{
			i_buscar = -1;
			String a_buscar = "";
			a_buscar = tf_matricula.getText().toString();
			for (int i=0;i<3;i++)
			{
				if (alumno[i].getMatricula().equals(a_buscar))
						{
							i_buscar = i;
						}
			}
			if (i_buscar == -1)
			{
				lbl_mensaje.setText("No se encontró la matrícula");

			}
			else
			{
				tf_matricula.setText(alumno[i_buscar].getMatricula());
				tf_nombre.setText(alumno[i_buscar].getNombre());
				tf_direccion.setText(alumno[i_buscar].getDireccion());
				btn_modificar.setEnabled(true);
			}
		}
		
		/* En el botón modificar se utilizará lo que esté en la variable
		 * i_buscar para posicionarme en el array y modificar lo 
		 * que esta dentro de los TextField.
		 */
		
		/*Si el boton que realizó el evento fue modificar, 
		  entonces: */
		
		if(e.getSource()==btn_modificar)
		{
			alumno[i_buscar].setMatricula(tf_matricula.getText().toString());
			alumno[i_buscar].setNombre(tf_nombre.getText().toString());
			alumno[i_buscar].setDireccion(tf_direccion.getText().toString());
			lbl_mensaje.setText("Alumno modificado");

		}
	}
	}

















