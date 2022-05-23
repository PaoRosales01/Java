/** 
 * Ventana principal en la cual se encuentran los diferentes JMenus, JMenuBar
 * y JMenuItem. Cada JMenuItem tiene una funcionalidad según lo que el usuario
 * desee hacer y al hacer clic en cualquier opción se le mostrará una nueva
 * ventana ya que este es un entorno desarrollado en multiventanas.
 * Este programa esta orientado en el registro de un juego y se adaptó para el 
 * mismo para que de esta manera las personas que interactuen con el programa
 * sepan en que consiste y puedan utilizarlo sin problemas.
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

/* La línea @SuppressWarnings("serial") le dice a Java que no recuerde 
 * que se ha omitido algo llamado campo serialVersionUID. En otras palabras, 
 * la anotación SuppressWarnings le dice a Java que no muestre una advertencia. 
 * Sin una anotación de SuppressWarnings, Java le advierte sobre la falta de 
 * un campo serialVersionUID.
 */

@SuppressWarnings("serial")

/** Utilizar palabra reservada extends y heredar características y
 * métodos de JFrame.
 * Action Listener sirve para creación de eventos en JMenuItems
 * que se colocarán, de igual manera en la clase se declaran las 
 * variables que se utilizarán a lo largo del proyecto.
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
	//Manejo de indice de datos y posición a buscar.
    private I_buscar i_buscar;
    //Estancia de JPanel
    private JPanel panel;
    //Imágenes
  	ImageIcon imagen;
  	//Icono
  	Icon icono;
  	
	/** Método constructor sirve para hacer la inicialización de 
    las variables o los atributos de la clase que estarán en la ventana. */
	public Ventana_Principal () {
		/*Constructor de clase padre "JFrame" */
		super();
		/* Título de ventana*/
		setTitle ("HEXABIN Game");
		/*Tamaño de 600x400 */
		setSize (600,400);
		/*Cerrar aplicación una vez que se da clic en cerrar */
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		/*Manera de acomodar elementos dentro de la ventana */
		setLayout (new FlowLayout());
		//Color JFrame
        this.getContentPane().setBackground(Color.decode("#072487"));
        
        /*Mensaje de advertencia a jugadores*/
        JOptionPane.showMessageDialog(null, "¡No olvides agregar a 5 jugadores!", 
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
		
		/*Enlazar cada opción del menú con el action listener, indicándole 
		 * que el action listener está dentro de la ventana */
		
		//Evento del elemento del menú
		jMenuItemAgregar.addActionListener(this);
		
		jMenuItemEliminar = new JMenuItem ("Eliminar jugador");
		//Evento del elemento del menú
		jMenuItemEliminar.addActionListener(this);
		
		jMenuItemModificar = new JMenuItem ("Modificar jugador");
		//Evento del elemento del menú
		jMenuItemModificar.addActionListener(this);
		
		jMenuItemBuscar = new JMenuItem ("Buscar jugador");
		//Evento del elemento del menú
		jMenuItemBuscar.addActionListener(this);
		
		jMenuItemBin = new JMenuItem ("Jugar Binario");
		//Evento del elemento del menú
		jMenuItemBin.addActionListener(this);
		
		jMenuItemHexa = new JMenuItem ("Jugar Hexadecimal");
		//Evento del elemento del menú
		jMenuItemHexa.addActionListener(this);
		
		jMenuItemImprimir = new JMenuItem ("Imprimir datos");
		//Evento del elemento del menú
		jMenuItemImprimir.addActionListener(this);
		
		jMenuItemSalir = new JMenuItem ("Salir");
		//Evento del elemento del menú
		jMenuItemSalir.addActionListener(this);
		
		/*Opciones del menú (JMenuItem)son dados de alta en el JMenuArchivo */
		jMenuArchivo.add(jMenuItemAgregar);
		jMenuArchivo.add(jMenuItemEliminar);
		jMenuArchivo.add(jMenuItemModificar);
		jMenuArchivo.add(jMenuItemBuscar);
		jMenuArchivo.add(jMenuItemImprimir);
		
		/*Opción del menú salir */
		jMenuSalir.add(jMenuItemSalir);

		/*Opción del menú Jugar*/
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
		//Tamaño de botón
		lbl_hexa.setBounds(0,0,150,150);
		//Imagen para botón
		imagen = new ImageIcon ("hexa.png");
		//Imagen que se adaptará al tamaño del botón
		icono = new ImageIcon (imagen.getImage().getScaledInstance(lbl_hexa.getWidth(), lbl_hexa.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen a la etiqueta
		lbl_hexa.setIcon(icono);
		//Botón transparente
		lbl_hexa.setOpaque(true);
		//Eliminar bordes del botón
		lbl_hexa.setBorder(null);
		//Color de fondo de botón
		lbl_hexa.setBackground(Color.decode("#072487"));

		//label binario
		lbl_bin = new JLabel();
		//Tamaño de botón
		lbl_bin.setBounds(0,0,150,150);
		//Imagen para botón
		imagen = new ImageIcon ("bin.png");
		//Imagen que se adaptará al tamaño del botón
		icono = new ImageIcon (imagen.getImage().getScaledInstance(lbl_bin.getWidth(), lbl_bin.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen a la etiqueta
		lbl_bin.setIcon(icono);
		//Botón transparente
		lbl_bin.setOpaque(true);
		//Eliminar bordes del botón
		lbl_bin.setBorder(null);
		//Color de fondo de botón
		lbl_bin.setBackground(Color.decode("#072487"));
		
		//label mente
		lbl_mente = new JLabel();
		//Tamaño de botón
		lbl_mente.setBounds(0,0,150,150);
		//Imagen para botón
		imagen = new ImageIcon ("mente.png");
		//Imagen que se adaptará al tamaño del botón
		icono = new ImageIcon (imagen.getImage().getScaledInstance(lbl_mente.getWidth(), lbl_mente.getHeight(),Image.SCALE_DEFAULT));
		//Asignar la imagen a la etiqueta
		lbl_mente.setIcon(icono);
		//Botón transparente
		lbl_mente.setOpaque(true);
		//Eliminar bordes del botón
		lbl_mente.setBorder(null);
		//Color de fondo de botón
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

	//Método estático "main"
	public static void main(String[] args) {
		/* Crear objeto (ventana) */
		Ventana_Principal p = new Ventana_Principal();

	}
	
	/** Cualquier evento que suceda en mi ventana se ejecutará
	en este método que esta sobreescrito de action listener. */

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
			/* Se muestra al jugador un mensaje de confirmar acción de salida */
			int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro de salir de HEXABIN?",
					"Salida HEXABIN", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
			/*Si la respuesta es que no esta seguro, se le mostrará de nuevo
			  la ventana principal, de lo contrario el proceso finalizará */
			if(resp != JOptionPane.NO_OPTION)
			{
				System.exit(0);
			}
		}
	}
 
}
