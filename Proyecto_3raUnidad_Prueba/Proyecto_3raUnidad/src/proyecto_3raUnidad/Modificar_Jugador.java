/** 
 * Programa para modificar los datos del jugador. Al hacer clic en el botón de borrar
 * se eliminará el texto que se encuentre en los campos/cuadros de texto, el 
 * botón de imprimir mostrará en consola los datos previamente registrados, el 
 * botón de buscar hará una búsqueda en los datos que se tienen y según la
 * información ingresada se completarán los campos de texto correspondientes y el
 * botón modificar hará cambios en el campo que sufrió modificaciones.
 * 
 * @author Paola Elizabeth Rosales Verdín - 2°B TI
 * @author Pablo Cesar Córdova Tapia - 2°B TI
 * @author Diana María Arellano Güereca - 2°B TI
 * @version 2019-12 (4.14.0) Creado el: 16/04/2020
 * 
 */

//Paquete del proyecto creado
package proyecto_3raUnidad;

//Librerías
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
public class Modificar_Jugador extends JFrame implements ActionListener { 	
																	
	//Etiquetas que tendrán descripción.
	private JLabel lbl_jugador, lbl_nombre, lbl_puntaje, lbl_fecha, lbl_record, 
					lbl_mensaje, lbl_tex1;
	//Campos que sirven para introducir datos.
	private JTextField tf_jugador, tf_nombre, tf_puntaje, tf_fecha, tf_record;
	//Botones de aceptar, imprimir, borrar, eliminar, buscar y modificar.
	private JButton btn_buscar, btn_modificar, btn_borrar, btn_imprimir;
	//Array de tipo alumno
	private Jugador[] jugador;
	//Estancia de clase indice
	private Indice indice;
	//Estancia de clase I_buscar
	private I_buscar i_buscar;
	//Imagenes
	ImageIcon imagen;
	//Icono
	Icon icono;
	
	/** Método constructor sirve para hacer la inicialización de 
	    las variables o los atributos de la clase. */
	public Modificar_Jugador(Jugador[] jugador, Indice indice, I_buscar i_buscar) {
		//Llamar método constructor de clase padre:
		super();
		//Título de la ventana:
		setTitle("Modificar Jugador");
		//Tamaño de la ventana:
		setSize(280,420);
		/*Forma en la cual se acomodaran los elementos en
		  la ventana:*/
		setLayout(new FlowLayout());
		/*Al hacer clic en "cerrar" se terminará la ejecución y se
		  mostrará de nuevo la ventana principal*/
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Color JFRAME
		this.getContentPane().setBackground(Color.decode("#072487"));
		//Centrar Ventana
        setLocationRelativeTo(null);
		
		/*Crear objetos de etiquetas (Jlabel) y asignar color 
		  blanco a las letras de las labels:*/
		lbl_jugador = new JLabel ("ID_Jugador: ");
		lbl_jugador.setForeground(Color.white);
		lbl_nombre = new JLabel ("Nombre del Jugador: ");
		lbl_nombre.setForeground(Color.white);
		lbl_puntaje = new JLabel ("Puntaje: ");
		lbl_puntaje.setForeground(Color.white);
		lbl_fecha = new JLabel ("Fecha de registro:");
		lbl_fecha.setForeground(Color.white);
		lbl_record = new JLabel ("Récord: ");
		lbl_record.setForeground(Color.white);
		lbl_tex1 = new JLabel ("Modificar              Limpiar              Imprimir");
		lbl_tex1.setForeground(Color.white);
		lbl_mensaje = new JLabel ("");
		lbl_mensaje.setForeground(Color.white);
		
		//Crear objetos de campos de texto (JTextField):
		tf_jugador = new JTextField(5);
		tf_nombre = new JTextField (20);
		tf_puntaje = new JTextField (20);
		tf_fecha = new JTextField (20);
		tf_record = new JTextField (20);
		
		//Crear objetos de botones (JButton):
		
		//Botón buscar
		btn_buscar = new JButton();
		//Tamaño de botón
		btn_buscar.setBounds(0,0,40,40);
		//Imagen para botón
		imagen = new ImageIcon ("buscar.png");
		//Imagen que se adaptará al tamaño del botón
		icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_buscar.getWidth(), btn_buscar.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen al botón buscar
		btn_buscar.setIcon(icono);
		//Botón transparente
		btn_buscar.setOpaque(true);
		//Eliminar bordes del botón
		btn_buscar.setBorder(null);
		//Color de fondo de botón
		btn_buscar.setBackground(Color.decode("#072487"));
		//Evento de botón
		btn_buscar.addActionListener(this);
		
		//Botón modificar
		btn_modificar = new JButton();
		//Tamaño de botón
		btn_modificar.setBounds(0,0,80,80);
		//Imagen para botón
		imagen = new ImageIcon ("modificar.png");
		//Imagen que se adaptará al tamaño del botón
		icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_modificar.getWidth(), btn_modificar.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen al botón modificar
		btn_modificar.setIcon(icono);
		//Botón transparente
		btn_modificar.setOpaque(true);
		//Eliminar bordes del botón
		btn_modificar.setBorder(null);
		//Color de fondo de botón
		btn_modificar.setBackground(Color.decode("#072487"));
		//Evento de botón
		btn_modificar.addActionListener(this);
		
		//Botón borrar
		btn_borrar = new JButton();
		//Tamaño de botón
		btn_borrar.setBounds(0,0,80,80);
		//Imagen para botón
		imagen = new ImageIcon ("clear.png");
		//Imagen que se adaptará al tamaño del botón
		icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_borrar.getWidth(), btn_borrar.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen al botón borrar
		btn_borrar.setIcon(icono);
		//Botón transparente
		btn_borrar.setOpaque(true);
		//Eliminar bordes del botón
		btn_borrar.setBorder(null);
		//Color de fondo de botón
		btn_borrar.setBackground(Color.decode("#072487"));
		//Evento de botón
		btn_borrar.addActionListener(this);
		
		//Botón imprimir
		btn_imprimir = new JButton();
		//Tamaño de botón
		btn_imprimir.setBounds(0,0,80,80);
		//Imagen para botón
		imagen = new ImageIcon ("imprimir.png");
		//Imagen que se adaptará al tamaño del botón
		icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_imprimir.getWidth(), btn_imprimir.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen al botón imprimir
		btn_imprimir.setIcon(icono);
		//Botón transparente
		btn_imprimir.setOpaque(true);
		//Eliminar bordes del botón
		btn_imprimir.setBorder(null);
		//Color de fondo de botón
		btn_imprimir.setBackground(Color.decode("#072487"));
		//Evento de botón
		btn_imprimir.addActionListener(this);
		
		//Agregar objetos a la ventana
		add (lbl_jugador);//Jugador
		add (tf_jugador);
		add (btn_buscar);

		add (lbl_nombre);//Nombre del jugador
		add (tf_nombre);
		
		add (lbl_puntaje);//Puntaje
		add (tf_puntaje);
		
		add (lbl_fecha);//Fecha
		add (tf_fecha);

		add (lbl_record);//Record
		add (tf_record);
		
		//Botones
		add (btn_modificar);
		add (btn_borrar);
		add (btn_imprimir);
		
		add (lbl_tex1);//Etiqueta1
		
		add(lbl_mensaje);//Etiqueta2
		
		//Inicializar jugador, indice y el indice a buscar
		this.jugador = jugador;
		this.indice = indice;
		this.i_buscar = i_buscar;
		
		 /*JButton imprimir estará inactivo antes de mostrar
		  * el jugador a modificar
		  */
	    btn_modificar.setEnabled(false);
		
	}
	
	/** Cualquier evento que suceda en mi ventana se ejecutará
	en este método que esta sobreescrito de action listener. */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*Si el botón que realizó el evento buscar, 
		  entonces: */
		if (e.getSource()==btn_buscar)
		{
			/*Buscará al jugador según el ID proporcionado y 
			  mostrará los datos del mismo */
			i_buscar.setI_buscar(-1);
			String a_buscar = "";
			a_buscar = tf_jugador.getText().toString();
			for (int i=0;i<5;i++)
			{
				if (jugador[i].getID_Jugador().equals(a_buscar))
						{
							i_buscar.setI_buscar(i);
						}
			}
			if (i_buscar.getI_buscar()==-1)
			{
				lbl_mensaje.setText("No se encontró el jugador");

			}
			else
			{
				tf_jugador.setText(jugador[i_buscar.getI_buscar()].getID_Jugador());
				tf_nombre.setText(jugador[i_buscar.getI_buscar()].getNombre());
				tf_puntaje.setText(jugador[i_buscar.getI_buscar()].getPuntaje());
				tf_fecha.setText(jugador[i_buscar.getI_buscar()].getFecha());
				tf_record.setText(jugador[i_buscar.getI_buscar()].getRecord());
				//Se activa botón modificar para hacer cambios
				 btn_modificar.setEnabled(true);
			}
		}
	
		/*Si el botón que realizó el evento fue modificar, 
		  entonces: */
		if(e.getSource()==btn_modificar)
		{
			//Actualizará los registros nuevos en los ya existentes
			jugador[i_buscar.getI_buscar()].setID_Jugador(tf_jugador.getText().toString());
			jugador[i_buscar.getI_buscar()].setNombre(tf_nombre.getText().toString());
			jugador[i_buscar.getI_buscar()].setPuntaje(tf_puntaje.getText().toString());
			jugador[i_buscar.getI_buscar()].setFecha(tf_fecha.getText().toString());
			jugador[i_buscar.getI_buscar()].setRecord(tf_record.getText().toString());
			lbl_mensaje.setText("Jugador modificado");
		}
		
		
		/*Si el botón que realizó el evento fue imprimir,
		  entonces: */
		if (e.getSource() == btn_imprimir)
		{
			//Imprime los datos introducidos en los TextField
			for (int i=0;i<5;i++) {
			System.out.println(jugador[i].toString());
			}
		}
		
		/*Si el botón que realizó el evento fue borrar, 
		  entonces: */
		if (e.getSource( ) == btn_borrar)
		{
			//Cadena vacía para eliminar datos
			tf_jugador.setText("");
			tf_nombre.setText("");
			tf_puntaje.setText("");
			tf_fecha.setText("");
			tf_record.setText("");
			lbl_mensaje.setText("");
		}
	}
}