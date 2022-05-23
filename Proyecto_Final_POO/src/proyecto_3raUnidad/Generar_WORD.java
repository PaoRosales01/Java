/** 
 * Programa para generar un archivo word que mostrar� todos los datos de todos los
 * jugadores que previamente fueron registrados; el nombre del archivo generado
 * ser� el que el usuario escriba en el text field que se muestra en
 * la ventana y el bot�n generar archivo realizar� el documento en word.
 * 
 * @author Paola Elizabeth Rosales Verd�n - 2�B TI
 * @author Pablo Cesar C�rdova Tapia - 2�B TI
 * @author Diana Mar�a Arellano G�ereca - 2�B TI
 * @version 2019-12 (4.14.0) Creado el: 20/04/2020
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

public class Generar_WORD extends JFrame implements ActionListener {
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
	private JLabel lbl_nombrearchivo, lbl_mensajearchivo, lbl_null;
	private JTextField tf_nombrearchivo;
	private JButton btn_generar;
	
	/** M�todo constructor sirve para hacer la inicializaci�n de 
    las variables o los atributos de la clase. */
	public Generar_WORD(Jugador[] jugador, Indice indice, I_buscar i_buscar) {
		//Llamar m�todo constructor de clase padre:
		super();
		//T�tulo de la ventana:
		setTitle("Generar Archivo Word");
		//Tama�o de la ventana:
		setSize (350,300);
		/*Forma en la cual se acomodar�n los elementos en
		  la ventana:*/
		setLayout(new FlowLayout());
		//Al hacer clic en "cerrar" se terminar� la ejecuci�n
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Color JFRAME
		this.getContentPane().setBackground(Color.decode("#072487"));
		//Centrar Ventana
        setLocationRelativeTo(null);
		     
        /*Crear objetos de etiquetas (Jlabel) y asignar color 
		  blanco a las letras de las labels:*/
		lbl_nombrearchivo = new JLabel ("Ingrese el nombre que desea colocar al archivo: ");
		lbl_nombrearchivo.setForeground(Color.white);
		lbl_mensajearchivo = new JLabel ("");
		lbl_mensajearchivo.setForeground(Color.white);
		//Etiqueta que ayuda a centrar el bot�n de generar
		lbl_null = new JLabel ("00000000000000000000000000000000000");
		lbl_null.setForeground(Color.decode("#072487"));

		//Crear objetos de campos de texto (JTextField):
		tf_nombrearchivo = new JTextField(20);
		
		//Crear objetos de botones (JButton):
		//Bot�n generar
		btn_generar = new JButton("Generar archivo");
		//Texto en el centro y debajo del icono
		btn_generar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_generar.setVerticalTextPosition(SwingConstants.BOTTOM);
		//Color de texto
		btn_generar.setForeground(Color.white);
		//Tama�o de bot�n
		btn_generar.setBounds(0,0,120,120);
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
		add (lbl_nombrearchivo);
		add (tf_nombrearchivo);
		add (lbl_null);
		add (btn_generar);
		add (lbl_mensajearchivo);
		
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
		//Colocar t�tulo de documento
		String t_documento = "Jugadores registrados";
		
		//Contenido de p�rrafos
		String p_documento1 = 
				//Imprime los datos introducidos en los TextField
				"ID_Jugador: " + jugador[0].getID_Jugador().toString();
		String p_documento2 = 
				//Imprime los datos introducidos en los TextField
				"Nombre: " + jugador[0].getNombre().toString();
		String p_documento3 = 
				//Imprime los datos introducidos en los TextField
				"Puntaje: " + jugador[0].getPuntaje().toString();
		String p_documento4 = 
				//Imprime los datos introducidos en los TextField
				"Fecha: " + jugador[0].getFecha().toString();
		String p_documento5 = 
				//Imprime los datos introducidos en los TextField
				"R�cord: " + jugador[0].getRecord().toString();
		String p_documento6 = 
				//Imprime los datos introducidos en los TextField
				"ID_Jugador: " + jugador[1].getID_Jugador().toString();
		String p_documento7 = 
				//Imprime los datos introducidos en los TextField
				"Nombre: " + jugador[1].getNombre().toString();
		String p_documento8 = 
				//Imprime los datos introducidos en los TextField
				"Puntaje: " + jugador[1].getPuntaje().toString();
		String p_documento9 = 
				//Imprime los datos introducidos en los TextField
				"Fecha: " + jugador[1].getFecha().toString();
		String p_documento10 = 
				//Imprime los datos introducidos en los TextField
				"R�cord: " + jugador[1].getRecord().toString();
		String p_documento11 = 
				//Imprime los datos introducidos en los TextField
				"ID_Jugador " + jugador[2].getID_Jugador().toString();
		String p_documento12 = 
				//Imprime los datos introducidos en los TextField
				"Nombre: " + jugador[2].getNombre().toString();
		String p_documento13 = 
				//Imprime los datos introducidos en los TextField
				"Puntaje: " + jugador[2].getPuntaje().toString();
		String p_documento14 = 
				//Imprime los datos introducidos en los TextField
				"Fecha: " + jugador[2].getFecha().toString();
		String p_documento15 = 
				//Imprime los datos introducidos en los TextField
				"R�cord: " + jugador[2].getRecord().toString();
		String p_documento16 = 
				//Imprime los datos introducidos en los TextField
				"ID_Jugador: " + jugador[3].getID_Jugador().toString();
		String p_documento17 = 
				//Imprime los datos introducidos en los TextField
				"Nombre: " + jugador[3].getNombre().toString();
		String p_documento18 = 
				//Imprime los datos introducidos en los TextField
				"Puntaje: " + jugador[3].getPuntaje().toString();
		String p_documento19 = 
				//Imprime los datos introducidos en los TextField
				"Fecha: " + jugador[3].getFecha().toString();
		String p_documento20 = 
				//Imprime los datos introducidos en los TextField
				"R�cord: " + jugador[3].getRecord().toString();
		String p_documento21 = 
				//Imprime los datos introducidos en los TextField
				"ID_Jugador: " + jugador[4].getID_Jugador().toString();
		String p_documento22 = 
				//Imprime los datos introducidos en los TextField
				"Nombre: " + jugador[4].getNombre().toString();
		String p_documento23 = 
				//Imprime los datos introducidos en los TextField
				"Puntaje: " + jugador[4].getPuntaje().toString();
		String p_documento24 = 
				//Imprime los datos introducidos en los TextField
				"Fecha: " + jugador[4].getFecha().toString();
		String p_documento25 = 
				//Imprime los datos introducidos en los TextField
				"R�cord: " + jugador[4].getRecord().toString();
		
				
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
		r_parrafo.setText(p_documento6);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento7);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento8);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento9);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento10);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento11);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento12);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento13);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento14);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento15);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento16);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento17);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento18);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento19);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento20);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento21);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento22);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento23);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento24);
		//Ingresar salto de l�nea
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento25);
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
			word = new FileOutputStream(tf_nombrearchivo.getText()+".docx");
			documento.write(word);
			//Cerrar word y documento
			word.close();
			documento.close();
			//Indicar� que si se puedo generar archivo
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
	
	/*Si el bot�n que realiz� el evento fue generar,
	  entonces: */
	public void actionPerformed(ActionEvent e) {
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

