/**
 * Programa que inicializa la ventana y el juego binario, d?ndole al jugador los n?meros
 * de manera aleatoria por medio del m?todo Math.random, con este m?todo nos es posible generar n?meros aleatorios
 * con un rango del 0 al 1 por medio de la funci?n Math.pow para lograr la parte de azar en nuestro juego, 
 * evitando que el jugador memorice todos los resultados 
 * y sea m?s entretenido para el jugador.
 * 
 * @author Paola Elizabeth Rosales Verd?n - 2?B TI
 * @author Pablo Cesar C?rdova Tapia - 2?B TI
 * @author Diana Mar?a Arellano G?ereca - 2?B TI
 * @version 2019-12 (4.14.0) Creado el: 16/04/2020
 * 
 */
//Paquete del proyecto creado
package proyecto_3raUnidad;

//Librer?as
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

/* La l?nea @SuppressWarnings("serial") le dice a Java que no recuerde 
 * que se ha omitido algo llamado campo serialVersionUID. En otras palabras, 
 * la anotaci?n SuppressWarnings le dice a Java que no muestre una advertencia. 
 * Sin una anotaci?n de SuppressWarnings, Java le advierte sobre la falta de 
 * un campo serialVersionUID.
 */
@SuppressWarnings("serial")

/** Utilizar palabra reservada extends y heredar caracter?sticas y
 * m?todos de JFrame.
 * Action Listener sirve para creaci?n de eventos en botones 
 * que se colocar?n, de igual manera en la clase se declaran las 
 * variables que se utilizar?n a lo largo del proyecto.
 */

/** Utilizar palabra reservada extends y heredar caracter?sticas y
 * m?todos de JFrame.
 * Action Listener sirve para creaci?n de eventos en botones 
 * que se colocar?n, de igual manera en la clase se declaran las 
 * variables que se utilizar?n a lo largo del proyecto.
 */
public class Juego_Binario extends JFrame implements ActionListener{
	//Arreglos de valores enteros
	private static int [] numBinario,valorBinario;
	//Variables
	private static int numDecimal=0;
	private static String binario="";
	//Variables de etiquetas y botones
	private JLabel Des1, Des2, lbl_des1, lbl_des2;
	private JButton btn_mostrar;
    //Im?genes
  	ImageIcon imagen;
  	//Icono
  	Icon icono;
	
	/** M?todo constructor sirve para hacer la inicializaci?n de 
    las variables o los atributos de la clase. */
	public Juego_Binario() {
	//Llamar m?todo constructor de clase padre:
	super();
	//T?tulo de la ventana:
	setTitle("Juego Binario");
	//Tama?o de la ventana:
	setSize(520,300);
	/*Forma en la cual se acomodar?n los elementos en
	  la ventana:*/
	setLayout(new FlowLayout());
	/*Al hacer clic en "cerrar" se terminar? la ejecuci?n y se
	  mostrar? de nuevo la ventana principal*/
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//Color JFRAME
	this.getContentPane().setBackground(Color.decode("#072487"));
	//Centrar Ventana
    setLocationRelativeTo(null);
	
	/*Crear objetos de labels*/
	
	Des1 = new JLabel ("Binario: ");//Etiqueta de la opci?n Binario
	Des1.setForeground(Color.white); //Color de letras de etiqueta blanco
	Font font = new Font("Verdana", Font.CENTER_BASELINE, 35); //Tipo de letra y tama?o
	Des1.setFont(font);
	
	Des2 = new JLabel ("Decimal: ");//Etiqueta de la opci?n Decimal
	Des2.setForeground(Color.white);//Color de letras de etiqueta blanco
	Font font2 = new Font("Verdana", Font.CENTER_BASELINE, 35); //Tipo de letra y tama?o
	Des2.setFont(font2);
	
	lbl_des1 = new JLabel ("");//Etiqueta1
	lbl_des1.setForeground(Color.decode("#F2F2F2")); //Color de letras de etiqueta gris tenue
	Font font3 = new Font("Verdana", Font.CENTER_BASELINE, 25); //Tipo de letra y tama?o
	lbl_des1.setFont(font3);
	
	lbl_des2 = new JLabel ("");//Etiqueta2
	lbl_des2 .setForeground(Color.decode("#F2F2F2")); //Color de letras de etiqueta gris tenue
	Font font4 = new Font("Verdana", Font.CENTER_BASELINE, 25); //Tipo de letra y tama?o
	lbl_des2 .setFont(font4);
	
	//Bot?n mostrar
	btn_mostrar = new JButton();
	//Tama?o de bot?n
	btn_mostrar.setBounds(0,0,160,160);
	//Imagen para bot?n
	imagen = new ImageIcon ("dados.png");
	//Imagen que se adaptar? al tama?o del bot?n
	icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_mostrar.getWidth(), btn_mostrar.getHeight(),Image.SCALE_DEFAULT));
	//Asignar la imagen al bot?n mostrar
	btn_mostrar.setIcon(icono);
	//Bot?n transparente
	btn_mostrar.setOpaque(true);
	//Eliminar bordes del bot?n
	btn_mostrar.setBorder(null);
	//Color de fondo de bot?n
	btn_mostrar.setBackground(Color.decode("#072487"));
	//Evento de bot?n
	btn_mostrar.addActionListener(this);
	 
	//Objetos que se agregar?n a la ventana
	 add (Des1);
	 add (lbl_des1);
	 add (Des2);
	 add (lbl_des2);
	 add (btn_mostrar);
	
	}
	
	/** Cualquier evento que suceda en mi ventana se ejecutar?
	en este m?todo que esta sobreescrito de action listener. */
	
	@Override //Inicializa el juego
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn_mostrar){
				//Comienza a generar los n?meros aleatorios 
				binario="";
				numDecimal=0;
				numBinario = new int[4];
				valorBinario = new int[4];
				for(int i=0;i<=3;i++) {
					valorBinario[i] = (int) Math.pow(2, i);
				}
				for(int i=0;i<=3;i++) {
					numBinario[i] = (int) (Math.random() * 2);
				}
				for(int i=0;i<=3;i++) {
					numDecimal = numDecimal+(valorBinario[i]*numBinario[i]);
				}
				for(int i=3;i>=0;i--) {
					binario=binario+numBinario[i];
				}
				//Se vac?an las variables para evitar sobreescribir los valores
				lbl_des1.setText(binario);
				lbl_des2.setText(numDecimal+"");
		}
	}
		
	}

