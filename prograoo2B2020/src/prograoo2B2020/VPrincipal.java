/** 
 * Programa base para la elaboración de una ventana con JMenu, JMenuBar y 
 * JMenuItem los cuales en este código fueron declarados con sus respectivas
 * variables y objetos. En el JMenuBar se colocaron las los JMenu de "Archivo",
 * "Editar" y "Salir". Por otro lado, se tienen los JMenuItem, en "Archivo" son:
 * Agregar, Eliminar, Modificar, Consultar e Imprimir y en "Salir" se tiene:
 * Salir.
 * 
 * @author Paola Elizabeth Rosales Verdín - 2°B TI
 * @version 2019-12 (4.14.0) Creado el: 06/04/2020
 * 
 */

//Paquete del proyecto creado
package prograoo2B2020;

//Librerías empleadas
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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

public class VPrincipal extends JFrame implements ActionListener{
	
	/*Variables para dar de alta JMenuBar, JMenu, JMenuItem */
	private JMenuBar jMenuBar;
	private JMenu jMenuArchivo, jMenuEditar, jMenuSalir;
	private JMenuItem jMenuItemAgregar, jMenuItemEliminar, jMenuItemModificar, 
	        jMenuItemConsultar,jMenuItemImprimir, jMenuItemSalir;
	
	/** Método constructor sirve para hacer la inicialización de 
    las variables o los atributos de la clase que estarán en la ventana. */
	public VPrincipal () {
		/*Constructor de clase padre "JFrame" */
		super();
		/* Titulo de ventana*/
		setTitle ("Sistema control escolar");
		/*Tamaño de 600x400 */
		setSize (600,400);
		/*Cerrar aplicacion una vez que se da clic en cerrar */
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		/*Manera de acomodar elementos dentro de la ventana */
		setLayout (new FlowLayout());
		
		/*Objetos de cada una de las variables */
		
		//Objetos de JMenuBar
		jMenuBar = new JMenuBar();
		
		//Objetos de JMenu
		jMenuArchivo = new JMenu ("Archivo");
		jMenuEditar = new JMenu ("Editar");
		jMenuSalir = new JMenu ("Salir");
		
		//Objetos de JMenuItem
		
		jMenuItemAgregar = new JMenuItem ("Agregar");
		
		/*Enlazar cada opción del menú con el action listener, indicándole 
		 * que el action listener esta dentro de la ventana */
		
		//Evento del elemento del menú
		jMenuItemAgregar.addActionListener(this);
		
		jMenuItemEliminar = new JMenuItem ("Eliminar");
		//Evento del elemento del menú
		jMenuItemEliminar.addActionListener(this);
		
		jMenuItemModificar = new JMenuItem ("Modificar");
		//Evento del elemento del menú
		jMenuItemModificar.addActionListener(this);
		
		jMenuItemConsultar = new JMenuItem ("Consultar");
		//Evento del elemento del menú
		jMenuItemConsultar.addActionListener(this);
		
		jMenuItemImprimir = new JMenuItem ("Imprimir");
		//Evento del elemento del menú
		jMenuItemImprimir.addActionListener(this);
		
		jMenuItemSalir = new JMenuItem ("Salir");
		//Evento del elemento del menú
		jMenuItemSalir.addActionListener(this);
		
		/*Opciones del menú (JMenuItem)son dados de alta en el JMenuArchivo */
		jMenuArchivo.add(jMenuItemAgregar);
		jMenuArchivo.add(jMenuItemEliminar);
		jMenuArchivo.add(jMenuItemModificar);
		jMenuArchivo.add(jMenuItemConsultar);
		jMenuArchivo.add(jMenuItemImprimir);
		
		/*Opción del menú salir */
		jMenuSalir.add(jMenuItemSalir);
		
		/*JMenu son dados de alta dentro del JMenuBar */
		jMenuBar.add(jMenuArchivo);
		jMenuBar.add(jMenuEditar);
		jMenuBar.add(jMenuSalir);
		
		/*Establecer el JMenuBar en la ventana */
		setJMenuBar(jMenuBar);
		
		/*Propiedad visible para que la ventana aparezca cuando se
		 * haga el objeto */ 
		setVisible (true);
	}

	//Método estático "main"
	public static void main(String[] args) {
		/* Crear objeto (ventana) */
		VPrincipal p = new VPrincipal();

	}
	
	/** Cualquier evento que suceda en mi ventana se ejecutará
	en este método que esta sobreescrito de action listener. */

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
