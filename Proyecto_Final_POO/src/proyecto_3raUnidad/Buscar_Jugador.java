/** 
 * Programa para buscar a los jugadores, la b�squeda se realiza a trav�s del ID del jugador. 
 * Al hacer clic en el bot�n de aceptar el jugador ser� buscado, al hacer clic en el bot�n de borrar
 * se eliminar� el texto que se encuentre en los campos/cuadros de texto, el 
 * bot�n de imprimir mostrar� en consola los datos previamente registrados, el 
 * bot�n de buscar har� una b�squeda en los datos que se tienen y seg�n la
 * informaci�n ingresada se completar�n los campos de texto correspondientes, el
 * bot�n modificar har� cambios en el campo que sufri� modificaciones y el bot�n
 * generar archivo realizara un documento en word con la informaci�n registrada del
 * jugador previamente buscado.
 * 
 * @author Paola Elizabeth Rosales Verd�n - 2�B TI
 * @author Pablo Cesar C�rdova Tapia - 2�B TI
 * @author Diana Mar�a Arellano G�ereca - 2�B TI
 * @version 2019-12 (4.14.0) Creado el: 16/04/2020
 * 
 */

//Paquete del proyecto creado
package proyecto_3raUnidad;

//Librer�as
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/* La l�nea @SuppressWarnings("serial") le dice a Java que no recuerde 
 * que se ha omitido algo llamado campo serialVersionUID. En otras palabras, 
 * la anotaci�n SuppressWarnings le dice a Java que no muestre una advertencia. 
 * Sin una anotaci�n de SuppressWarnings, Java le advierte sobre la falta de 
 * un campo serialVersionUID.
 */

@SuppressWarnings("serial")

/** Utilizar palabra reservada extends y heredar caracter�sticas y
 * m�todos de JFrame.
 * Action Listener sirve para creaci�n de eventos en botones 
 * que se colocar�n, de igual manera en la clase se declaran las 
 * variables que se utilizar�n a lo largo del proyecto.
 */
public class Buscar_Jugador extends JFrame implements ActionListener { 	
																	
	//Etiquetas que tendr�n descripci�n.
	private JLabel lbl_jugador, lbl_nombre, lbl_puntaje, lbl_fecha, lbl_record, 
			lbl_mensaje;
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
	//Im�genes
	ImageIcon imagen;
	//Icono
	Icon icono;
	//Variables para generar archivo
	private JLabel  lbl_mensajearchivo;
	private JButton btn_generar;
	
	/** M�todo constructor sirve para hacer la inicializaci�n de 
	    las variables o los atributos de la clase. */
	public Buscar_Jugador(Jugador[] jugador, Indice indice, I_buscar i_buscar) {
		//Llamar m�todo constructor de clase padre:
		super();
		//T�tulo de la ventana:
		setTitle("Consultar Jugador");
		//Tama�o de la ventana:
		setSize(280,550);
		/*Forma en la cual se acomodar�n los elementos en
		la ventana:*/
		setLayout(new FlowLayout());
		/*Al hacer clic en "cerrar" se terminar� la ejecuci�n de esta ventana
		  y retornar� a la ventana principal */
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
		lbl_record = new JLabel ("R�cord: ");
		lbl_record.setForeground(Color.white);
		lbl_mensaje = new JLabel ("");
		lbl_mensaje.setForeground(Color.white);
		lbl_mensajearchivo = new JLabel ("");
		lbl_mensajearchivo.setForeground(Color.white);
		
		//Crear objetos de campos de texto (JTextField):
		tf_jugador = new JTextField(5);
		tf_nombre = new JTextField (20);
		tf_puntaje = new JTextField (20);
		tf_fecha = new JTextField (20);
		tf_record = new JTextField (20);
		
		//Crear objetos de botones (JButton):
		
		//Bot�n Buscar
		btn_buscar = new JButton();
		//Tama�o de bot�n
		btn_buscar.setBounds(0,0,40,40);
		//Imagen para bot�n
		imagen = new ImageIcon ("buscar.png");
		//Imagen que se adaptar� al tama�o del bot�n
		icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_buscar.getWidth(), btn_buscar.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen al bot�n buscar
		btn_buscar.setIcon(icono);
		//Bot�n transparente
		btn_buscar.setOpaque(true);
		//Eliminar bordes del bot�n
		btn_buscar.setBorder(null);
		//Color de fondo de bot�n
		btn_buscar.setBackground(Color.decode("#072487"));
		//Evento de bot�n
		btn_buscar.addActionListener(this);
		
		//Bot�n Borrar
		btn_borrar = new JButton("Limpiar");
		//Texto en el centro y debajo del icono
		btn_borrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_borrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		//Color de texto
		btn_borrar.setForeground(Color.white);
		//Tama�o de bot�n
		btn_borrar.setBounds(0,0,80,80);
		//Imagen para bot�n
		imagen = new ImageIcon ("clear.png");
		//Imagen que se adaptar� al tama�o del bot�n
		icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_borrar.getWidth(), btn_borrar.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen al bot�n borrar
		btn_borrar.setIcon(icono);
		//Bot�n transparente
		btn_borrar.setOpaque(true);
		//Eliminar bordes del bot�n
		btn_borrar.setBorder(null);
		//Color de fondo de bot�n
		btn_borrar.setBackground(Color.decode("#072487"));
		//Evento de bot�n
		btn_borrar.addActionListener(this);
		
		//Bot�n imprimir
		btn_imprimir = new JButton("Imprimir");
		//Texto en el centro y debajo del icono
		btn_imprimir.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_imprimir.setVerticalTextPosition(SwingConstants.BOTTOM);
		//Color de texto
		btn_imprimir.setForeground(Color.white);
		//Tama�o de bot�n
		btn_imprimir.setBounds(0,0,80,80);
		//Imagen para bot�n
		imagen = new ImageIcon ("imprimir.png");
		//Imagen que se adaptar� al tama�o del bot�n
		icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_imprimir.getWidth(), btn_imprimir.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen al bot�n imprimir
		btn_imprimir.setIcon(icono);
		//Bot�n transparente
		btn_imprimir.setOpaque(true);
		//Eliminar bordes del bot�n
		btn_imprimir.setBorder(null);
		//Color de fondo de bot�n
		btn_imprimir.setBackground(Color.decode("#072487"));
		//Evento de bot�n
		btn_imprimir.addActionListener(this);
		
		//Bot�n generar
		btn_generar = new JButton("Generar archivo");
		//Texto en el centro y debajo del icono
		btn_generar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_generar.setVerticalTextPosition(SwingConstants.BOTTOM);
		//Color de texto
		btn_generar.setForeground(Color.white);
		//Tama�o de bot�n
		btn_generar.setBounds(0,0,80,80);
		//Imagen para bot�n
		imagen = new ImageIcon ("word.png");
		//Imagen que se adaptar� al tama�o del bot�n
		icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_generar.getWidth(), btn_generar.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen al bot�n eliminar
		btn_generar.setIcon(icono);
		//Bot�n transparente
		btn_generar.setOpaque(true);
		//Eliminar bordes del bot�n
		btn_generar.setBorder(null);
		//Color de fondo de bot�n
		btn_generar.setBackground(Color.decode("#072487"));
		//Evento de bot�n
		btn_generar.addActionListener(this);
		
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

		add (lbl_record);//R�cord
		add (tf_record);
	
		//Botones
		add (btn_generar);
		add(lbl_mensajearchivo);//Etiqueta2
		add (btn_borrar);
		add (btn_imprimir);
		
		add(lbl_mensaje);//Etiqueta1
		
	
		
		//Inicializar jugador, indice y el indice a buscar
		this.jugador = jugador;
		this.indice = indice;
		this.i_buscar = i_buscar;
		
	}
	
	/*M�todo generar que regresar� un valor booleano que
	 * indicar� si se pudo crear el archivo WORD o no*/
	
	public boolean generar() {
		/*Variables de librerias importadas*/
		
		//Variable en la que se crear� el documento word;
		XWPFDocument documento;
		//Variable para el t�tulo del documento
		XWPFParagraph titulo_doc;
		//Variable para guardar informaci�n en p�rrafo
		XWPFParagraph parrafo;
		//Variables para configuraci�n y contenido a cada p�rrafo
		XWPFRun r_titulo, r_parrafo;
		//Variable para crear un flujo de datos hacia un archivo
		FileOutputStream word;
		
		//Objeto de documento
		documento = new XWPFDocument();
		//Colocar t�tulo al documento
		String t_documento = "Jugador consultado";
		
		//Contenido de p�rrafos
		String p_documento1 = 
				//Imprime los datos introducidos en los TextField
				"ID_Jugador: " + tf_jugador.getText().toString();
		String p_documento2 = 
				//Imprime los datos introducidos en los TextField
				"Nombre: " + tf_nombre.getText().toString();
		String p_documento3 = 
				//Imprime los datos introducidos en los TextField
				"Puntaje: " + tf_puntaje.getText().toString();
		String p_documento4 = 
				//Imprime los datos introducidos en los TextField
				"Fecha: " + tf_fecha.getText().toString();
		String p_documento5 = 
				//Imprime los datos introducidos en los TextField
				"R�cord: " + tf_record.getText().toString();
		
		//Variable con la que se crear� la respuesta
		boolean respuesta = false;
		
		//Enlazar t�tulo a documento y que esto sea el primer p�rrafo 
		titulo_doc = documento.createParagraph();
		
		/*Formato al p�rrafo*/
		//Establecer alineaci�n del p�rrafo
		titulo_doc.setAlignment(ParagraphAlignment.CENTER);
		//Alineaci�n vertical en la parte de arriba
		titulo_doc.setVerticalAlignment(TextAlignment.TOP);
		
		/*P�rrafo de contenido principal*/
		//Enlazar texto a documento 
		parrafo = documento.createParagraph();
		//Justificar el texto del p�rrafo
		parrafo.setAlignment(ParagraphAlignment.BOTH);
		
		/*P�rrafo de t�tulo*/
		//Enlazar r_titulo al p�rrafo del t�tulo
		r_titulo = titulo_doc.createRun();
		//T�tulo contenga la letra en negrita
		r_titulo.setBold(true);
		//Establecer texto
		r_titulo.setText(t_documento);
		//Tipo de letra
		r_titulo.setFontFamily("Arial");
		//Tama�o de letra
		r_titulo.setFontSize(16);
		//Agregar espacio entre p�rrafos
		r_titulo.setTextPosition(10);
		
		
		/*P�rrafo de contenido principal*/
		//Enlazar p�rrafo con p�rrafo
		r_parrafo = parrafo.createRun();
		//Ingresar contenido
		r_parrafo.setText(p_documento1);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento2);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento3);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento4);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento5);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		//Tama�o de la letra
		r_parrafo.setFontSize(14);
		//Salto de l�nea
		r_parrafo.addCarriageReturn();
				
		
		//Crear archivo en la unidad del disco duro
		try {
			word = new FileOutputStream("Jugador_"+tf_nombre.getText().toString()+".docx");
			documento.write(word);
			//Cerrar word y documento
			word.close();
			documento.close();
			//Indicar� que si se pudo generar archivo
			respuesta = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		
		return respuesta;
	}
	
	/** Cualquier evento que suceda en mi ventana se ejecutar�
	en este m�todo que esta sobreescrito de action listener. */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*Si el bot�n que realiz� el evento fue buscar, 
		  entonces: */
		if (e.getSource()==btn_buscar)
			/*Buscar� al jugador seg�n el ID proporcionado y 
			  mostrar� los datos del mismo */
		{
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
				JOptionPane.showMessageDialog(null, "No se encontr� el jugador", 
						  "ERROR", JOptionPane.WARNING_MESSAGE);

			}
			else
			{
				tf_jugador.setText(jugador[i_buscar.getI_buscar()].getID_Jugador());
				tf_nombre.setText(jugador[i_buscar.getI_buscar()].getNombre());
				tf_puntaje.setText(jugador[i_buscar.getI_buscar()].getPuntaje());
				tf_fecha.setText(jugador[i_buscar.getI_buscar()].getFecha());
				tf_record.setText(jugador[i_buscar.getI_buscar()].getRecord());
			}
		}
	
		
		/*Si el bot�n que realiz� el evento fue imprimir,
		  entonces: */
		if (e.getSource() == btn_imprimir)
		{
			//Imprime los datos introducidos en los TextField
			for (int i=0;i<5;i++) {
			System.out.println(jugador[i].toString());
			}
		}
		
		/*Si el bot�n que realiz� el evento fue borrar, 
		  entonces: */
		if (e.getSource( ) == btn_borrar)
		{
			//Cadena vac�a para eliminar datos
			tf_jugador.setText("");
			tf_nombre.setText("");
			tf_puntaje.setText("");
			tf_fecha.setText("");
			tf_record.setText("");
			lbl_mensaje.setText("");
		}
		
		/*Si el bot�n que realiz� el evento fue generar,
		  entonces: */
		if (e.getSource() == btn_generar) {
			  if(generar()) {
				  //Mensaje de que el archivo logr� generarse
				 JOptionPane.showMessageDialog(null, "Archivo generado exitosamente");
			  }
			  else {
				  //Mensaje de que hubo un error al generar el archivo
				  JOptionPane.showMessageDialog(null, "El archivo no se gener�", 
						  "ERROR", JOptionPane.WARNING_MESSAGE);
			  }
			}
	}
	}