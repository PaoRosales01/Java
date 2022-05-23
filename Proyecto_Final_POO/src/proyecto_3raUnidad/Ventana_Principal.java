/** 
 * Ventana principal en la cual se encuentran los diferentes JMenus, JMenuBar
 * y JMenuItem. Cada JMenuItem tiene una funcionalidad seg�n lo que el usuario
 * desee hacer y al hacer clic en cualquier opci�n se le mostrar� una nueva
 * ventana ya que este es un entorno desarrollado en multiventanas.
 * Este programa esta orientado en el registro de un juego y se adapt� para el 
 * mismo para que de esta manera las personas que interactuen con el programa
 * sepan en que consiste y puedan utilizarlo sin problemas.
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
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* La l�nea @SuppressWarnings("serial") le dice a Java que no recuerde 
 * que se ha omitido algo llamado campo serialVersionUID. En otras palabras, 
 * la anotaci�n SuppressWarnings le dice a Java que no muestre una advertencia. 
 * Sin una anotaci�n de SuppressWarnings, Java le advierte sobre la falta de 
 * un campo serialVersionUID.
 */

@SuppressWarnings("serial")

/** Utilizar palabra reservada extends y heredar caracter�sticas y
 * m�todos de JFrame.
 * Action Listener sirve para creaci�n de eventos en JMenuItems
 * que se colocar�n, de igual manera en la clase se declaran las 
 * variables que se utilizar�n a lo largo del proyecto.
 */

public class Ventana_Principal extends JFrame implements ActionListener{
	
	/*Variables para dar de alta JMenuBar, JMenu, JMenuItem */
	private JMenuBar jMenuBar;
	private JMenu jMenuArchivo, jMenuEditar, jMenuJugar, jMenuSalir;
	private JMenuItem jMenuItemAgregar, jMenuItemEliminar, jMenuItemModificar, 
	        jMenuItemBuscar,jMenuItemImprimir, jMenuItemBin, jMenuItemHexa, jMenuItemSalir;
	private JLabel nombre, lbl_hexa, lbl_bin, lbl_mente;
	//Array de tipo jugador
	private Jugador[] jugador;
	//Estancia de clase indice
	private Indice indice;
	//Manejo de indice de datos y posici�n a buscar.
    private I_buscar i_buscar;
    //Estancia de JPanel
    private JPanel panel;
    //Im�genes
  	ImageIcon imagen;
  	//Icono
  	Icon icono;
  	
	/** M�todo constructor sirve para hacer la inicializaci�n de 
    las variables o los atributos de la clase que estar�n en la ventana. */
	public Ventana_Principal () {
		/*Constructor de clase padre "JFrame" */
		super();
		/* T�tulo de ventana*/
		setTitle ("HEXABIN Game");
		/*Tama�o de 600x400 */
		setSize (600,400);
		/*Cerrar aplicaci�n una vez que se da clic en cerrar */
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		/*Manera de acomodar elementos dentro de la ventana */
		setLayout (new FlowLayout());
		//Color JFrame
        this.getContentPane().setBackground(Color.decode("#072487"));
        
        /*Mensaje de advertencia a jugadores*/
        JOptionPane.showMessageDialog(null, "�No olvides agregar a 5 jugadores!", 
        		"HexaBin Game", JOptionPane.WARNING_MESSAGE);
        //Centrar Ventana
        setLocationRelativeTo(null);
		
		/*Objetos de cada una de las variables */
		
		//Objetos de JMenuBar
		jMenuBar = new JMenuBar();
		
		//Objetos de JMenu
		jMenuArchivo = new JMenu ("Archivo");
		jMenuEditar = new JMenu ("Editar");
		jMenuJugar = new JMenu ("Jugar");
		jMenuSalir = new JMenu ("Salir");
		
		//Objetos de JMenuItem
		jMenuItemAgregar = new JMenuItem ("Agregar jugador");
		
		/*Enlazar cada opci�n del men� con el action listener, indic�ndole 
		 * que el action listener est� dentro de la ventana */
		
		//Evento del elemento del men�
		jMenuItemAgregar.addActionListener(this);
		
		jMenuItemEliminar = new JMenuItem ("Eliminar jugador");
		//Evento del elemento del men�
		jMenuItemEliminar.addActionListener(this);
		
		jMenuItemModificar = new JMenuItem ("Modificar jugador");
		//Evento del elemento del men�
		jMenuItemModificar.addActionListener(this);
		
		jMenuItemBuscar = new JMenuItem ("Buscar jugador");
		//Evento del elemento del men�
		jMenuItemBuscar.addActionListener(this);
		
		jMenuItemBin = new JMenuItem ("Jugar Binario");
		//Evento del elemento del men�
		jMenuItemBin.addActionListener(this);
		
		jMenuItemHexa = new JMenuItem ("Jugar Hexadecimal");
		//Evento del elemento del men�
		jMenuItemHexa.addActionListener(this);
		
		jMenuItemImprimir = new JMenuItem ("Imprimir datos");
		//Evento del elemento del men�
		jMenuItemImprimir.addActionListener(this);
		
		jMenuItemSalir = new JMenuItem ("Salir");
		//Evento del elemento del men�
		jMenuItemSalir.addActionListener(this);
		
		/*Opciones del men� (JMenuItem)son dados de alta en el JMenuArchivo */
		jMenuArchivo.add(jMenuItemAgregar);
		jMenuArchivo.add(jMenuItemEliminar);
		jMenuArchivo.add(jMenuItemModificar);
		jMenuArchivo.add(jMenuItemBuscar);
		jMenuArchivo.add(jMenuItemImprimir);
		
		/*Opci�n del men� salir */
		jMenuSalir.add(jMenuItemSalir);

		/*Opci�n del men� Jugar*/
		jMenuJugar.add(jMenuItemBin);
		jMenuJugar.add(jMenuItemHexa);
		
		/*JMenu son dados de alta dentro del JMenuBar */
		jMenuBar.add(jMenuArchivo);
		jMenuBar.add(jMenuJugar);
		jMenuBar.add(jMenuEditar);
		jMenuBar.add(jMenuSalir);
		
		/*Crear objetos de labels*/
		nombre = new JLabel ("HEXABIN GAME ");
		nombre.setForeground(Color.white);
		Font font = new Font("Verdana", Font.CENTER_BASELINE, 60);
		nombre.setFont(font);
		
		//label hexadecimal
		lbl_hexa = new JLabel();
		//Tama�o de bot�n
		lbl_hexa.setBounds(0,0,150,150);
		//Imagen para bot�n
		imagen = new ImageIcon ("hexa.png");
		//Imagen que se adaptar� al tama�o del bot�n
		icono = new ImageIcon (imagen.getImage().getScaledInstance(lbl_hexa.getWidth(), lbl_hexa.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen a la etiqueta
		lbl_hexa.setIcon(icono);
		//Bot�n transparente
		lbl_hexa.setOpaque(true);
		//Eliminar bordes del bot�n
		lbl_hexa.setBorder(null);
		//Color de fondo de bot�n
		lbl_hexa.setBackground(Color.decode("#072487"));

		//label binario
		lbl_bin = new JLabel();
		//Tama�o de bot�n
		lbl_bin.setBounds(0,0,150,150);
		//Imagen para bot�n
		imagen = new ImageIcon ("bin.png");
		//Imagen que se adaptar� al tama�o del bot�n
		icono = new ImageIcon (imagen.getImage().getScaledInstance(lbl_bin.getWidth(), lbl_bin.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen a la etiqueta
		lbl_bin.setIcon(icono);
		//Bot�n transparente
		lbl_bin.setOpaque(true);
		//Eliminar bordes del bot�n
		lbl_bin.setBorder(null);
		//Color de fondo de bot�n
		lbl_bin.setBackground(Color.decode("#072487"));
		
		//label mente
		lbl_mente = new JLabel();
		//Tama�o de bot�n
		lbl_mente.setBounds(0,0,150,150);
		//Imagen para bot�n
		imagen = new ImageIcon ("mente.png");
		//Imagen que se adaptar� al tama�o del bot�n
		icono = new ImageIcon (imagen.getImage().getScaledInstance(lbl_mente.getWidth(), lbl_mente.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen a la etiqueta
		lbl_mente.setIcon(icono);
		//Bot�n transparente
		lbl_mente.setOpaque(true);
		//Eliminar bordes del bot�n
		lbl_mente.setBorder(null);
		//Color de fondo de bot�n
		lbl_mente.setBackground(Color.decode("#072487"));
		
		/*Establecer el JMenuBar en la ventana */
		setJMenuBar(jMenuBar);
		
		//Panel
		 panel = new JPanel();
		 
		 //Agregar objetos al panel
		 add (nombre);
		 add (lbl_hexa);
		 add (lbl_mente);
		 add (lbl_bin);
		
		/*Propiedad visible para que la ventana aparezca cuando se
		 * haga el objeto */ 
		setVisible (true);
		
		jugador = new Jugador[5];
		indice = new Indice();
		indice.setIndice(0);
		i_buscar = new I_buscar();
	    i_buscar.setI_buscar(-1);
		
	}

	//M�todo est�tico "main"
	public static void main(String[] args) {
		/* Crear objeto (ventana) */
		Ventana_Principal p = new Ventana_Principal();

	}
	
	/** Cualquier evento que suceda en mi ventana se ejecutar�
	en este m�todo que esta sobreescrito de action listener. */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jMenuItemAgregar) {
			//Objeto de la ventana
			Agregar_Jugador vaj = new Agregar_Jugador(jugador, indice, i_buscar);
			vaj.setVisible(true);
		}
		
		if (e.getSource() == jMenuItemEliminar) {
			//Objeto de la ventana
			Eliminar_Jugador vej = new Eliminar_Jugador(jugador, indice, i_buscar);
			vej.setVisible(true);
		}
	
		if (e.getSource() == jMenuItemModificar) {
			//Objeto de la ventana
			Modificar_Jugador vmj = new Modificar_Jugador(jugador, indice, i_buscar);
			vmj.setVisible(true);
		}
		
		if (e.getSource() == jMenuItemBuscar) {
			//Objeto de la ventana
			Buscar_Jugador vbj = new Buscar_Jugador(jugador, indice, i_buscar);
			vbj.setVisible(true);
		}
		
		if (e.getSource() == jMenuItemBin) {
			//Objeto de la ventana
			Juego_Binario jb = new Juego_Binario();
			jb.setVisible(true);
		}
		
		if (e.getSource() == jMenuItemHexa) {
			//Objeto de la ventana
			Juego_Hexadecimal jh = new Juego_Hexadecimal();
			jh.setVisible(true);
		}
		
		if (e.getSource() == jMenuItemImprimir) {
			//Objeto de la ventana
			Generar_WORD gw = new Generar_WORD(jugador, indice, i_buscar);
			gw.setVisible(true);
		}
		
		if (e.getSource() == jMenuItemSalir) {
			/* Se muestra al jugador un mensaje de confirmar acci�n de salida */
			int resp = JOptionPane.showConfirmDialog(null, "�Est� seguro de salir de HEXABIN?",
					"Salida HEXABIN", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
			/*Si la respuesta es que no esta seguro, se le mostrar� de nuevo
			  la ventana principal, de lo contrario el proceso finalizar� */
			if(resp != JOptionPane.NO_OPTION)
			{
				System.exit(0);
			}
		}
	}
 
}
