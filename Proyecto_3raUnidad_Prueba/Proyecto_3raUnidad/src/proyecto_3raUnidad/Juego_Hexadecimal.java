/**
 * Programa que inicializa la ventana y el juego, dándole al jugador los números
 * de manera aleatoria por medio del método Math.random(), con este método nos es posible generar números aleatorios
 * para generar hexadecimales y decimales por medio de la función Math.pow() y el método valueof() para devolver el 
 * objeto primitivo del String para lograr la parte de azar en nuestro juego, 
 * evitando que el jugador memorice todos los resultados y así sea más entretenido para el jugador.
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

/** Utilizar palabra reservada extends y heredar características y
 * métodos de JFrame.
 * Action Listener sirve para creación de eventos en botones 
 * que se colocarán, de igual manera en la clase se declaran las 
 * variables que se utilizarán a lo largo del proyecto.
 */
public class Juego_Hexadecimal extends JFrame implements ActionListener {
	//Arreglos de valores enteros
	private static int [] numhexa,valorHexa;
	//Variables
	private static int numDecimal=0;
	private static String [] numhexaS;
	private static String numS="";
	//Variables de etiquetas y botones
	private JLabel Des1, Des2, lbl_des1, lbl_des2;
	private JButton btn_mostrar;
    //Imágenes
  	ImageIcon imagen;
  	//Icono
  	Icon icono;
    
    /** Método constructor sirve para hacer la inicialización de 
    las variables o los atributos de la clase. */
	public Juego_Hexadecimal() {
	//Llamar método constructor de clase padre:
	super();
	//Título de la ventana:
	setTitle("Juego Hexadecimal");
	//Tamaño de la ventana:
	setSize(520,300);
	/*Forma en la cual se acomodarán los elementos en
	  la ventana:*/
	setLayout(new FlowLayout());
	/*Al hacer clic en "cerrar" se terminará la ejecución y se
	  mostrará de nuevo la ventana principal*/
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//Color JFRAME
	this.getContentPane().setBackground(Color.decode("#072487"));
	//Centrar Ventana
    setLocationRelativeTo(null);
    
	/*Crear objetos de labels*/
	Des1 = new JLabel ("Hexadecimal: ");//Etiqueta de la opción Hexadecimal
	Des1.setForeground(Color.white); //Color de letras de etiqueta blanco
	Font font = new Font("Verdana", Font.CENTER_BASELINE, 25); //Tipo de letra y tamaño
	Des1.setFont(font);
	
	Des2 = new JLabel ("Decimal: ");//Etiqueta de la opción Decimal
	Des2.setForeground(Color.white); //Color de letras de etiqueta blanco
	Font font2 = new Font("Verdana", Font.CENTER_BASELINE, 25); //Tipo de letra y tamaño
	Des2.setFont(font2);
	
	lbl_des1 = new JLabel ("");//Etiqueta1
	lbl_des1.setForeground(Color.decode("#F2F2F2")); //Color de letras de etiqueta gris tenue
	Font font3 = new Font("Verdana", Font.CENTER_BASELINE, 20); //Tipo de letra y tamaño
	lbl_des1.setFont(font3);
	
	lbl_des2 = new JLabel ("");//Etiqueta2
	lbl_des2 .setForeground(Color.decode("#F2F2F2")); //Color de letras de etiqueta gris tenue
	Font font4 = new Font("Verdana", Font.CENTER_BASELINE, 20); //Tipo de letra y tamaño
	lbl_des2 .setFont(font4);
	
	//Botón mostrar
	btn_mostrar = new JButton();
	//Tamaño de botón
	btn_mostrar.setBounds(0,0,160,160);
	//Imagen para botón
	imagen = new ImageIcon ("dados.png");
	//Imagen que se adaptará al tamaño del botón
	icono = new ImageIcon (imagen.getImage().getScaledInstance(btn_mostrar.getWidth(), btn_mostrar.getHeight(),Image.SCALE_DEFAULT));
	//Asignar la imagen al botón mostrar
	btn_mostrar.setIcon(icono);
	//Botón transparente
	btn_mostrar.setOpaque(true);
	//Eliminar bordes del botón
	btn_mostrar.setBorder(null);
	//Color de fondo de botón
	btn_mostrar.setBackground(Color.decode("#072487"));
	//Evento de botón
	btn_mostrar.addActionListener(this);
	 
	//Objetos que se agregarán a la ventana
	 add (Des1);
	 add (lbl_des1);
	 add (Des2);
	 add (lbl_des2);
	 add (btn_mostrar);
	
	}
	
	/** Cualquier evento que suceda en mi ventana se ejecutará
	en este método que esta sobreescrito de action listener. */

	@Override//Inicializa el juego
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_mostrar){
			//Comienza a generar los números aleatorios 
			numS="";
			numDecimal=0;
			numhexa = new int[4];
			valorHexa = new int[4];
			numhexaS= new String[4];
			for(int i=0;i<=3;i++) {
				valorHexa[i] = (int) Math.pow(16, i);
			}
			for(int i=0;i<=3;i++) {
				numhexa[i] = (int) ((Math.random() * 15)+1);
			} 
			for(int i=0;i<=3;i++) {
				if(!(numhexa[i]>=10)) {
					numhexaS[i] = String.valueOf(numhexa[i]);
				}else {
					switch (numhexa[i]) {
						case 10:
							numhexaS[i]="A";
							break;
						case 11:
							numhexaS[i]="B";
							break;
						case 12:
							numhexaS[i]="C";
							break;
						case 13:
							numhexaS[i]="D";
							break;
						case 14:
							numhexaS[i]="E";
							break;
						case 15:
							numhexaS[i]="F";
							break;
						default:
							break;
					}
				}
			}
			for(int i=0;i<=3;i++) {
				numDecimal = numDecimal+(numhexa[i]*valorHexa[i]);
			}
			for(int i=3;i>=0;i--) {
				numS=numS+numhexaS[i];
			}
			//Se vacían las variables para evitar sobreescribir los valores
			lbl_des1.setText(numS);
			lbl_des2.setText(numDecimal+"");
		}
		
	}
	
}
