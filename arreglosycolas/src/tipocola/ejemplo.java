package tipocola;

import javax.swing.JOptionPane;

public class ejemplo{
	public static void main (String[] args){
		Object opcion[] = {"Insertar","Eliminar","Visualizar", "Salir"};
		int res=0;
		int[]arreglo = new int [5];
		int i=0;
		
		for(int j=0; j<5; j--) {
			res = JOptionPane.showOptionDialog(null, "Introduzca el valor en la posición", "Colas con arreglos",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, "Insertar");
		
			if(res==0) {
				if(i<5) {
					arreglo[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca " + "el valor en posición "+(i+1), "Entrada de datos...", JOptionPane.INFORMATION_MESSAGE));
					i++;
				}
				if(i>=5) {
					JOptionPane.showMessageDialog(null, "La cola ya está llena");
				}
			}
			
			if(res==1) {
				if(i==0) {
					JOptionPane.showMessageDialog(null, "La cola está vacía");
				}
				else {
					if(i!=0) {
						if(i!=5) {
							for(int k=0; k<i;k++) {
								arreglo[k]=arreglo[k+1];
							}
							JOptionPane.showMessageDialog(null, "El valor ha sido eliminado");
							i--;
							
						}
						if(i==5) {
							arreglo[0]=arreglo[1];
							arreglo[1]=arreglo[2];
							arreglo[2]=arreglo[3];
							arreglo[3]=arreglo[4];
							i--;
						}
					}
				}
			}
			
			if(res==2) {
				if(i==0) {
					JOptionPane.showMessageDialog(null, "La cola se encuentra vacía");
				}
				else {
					String cadena = "Los elementos introducidos fueron: ";
					for (int k=0;k<i;k++) {
						cadena+="\n" + arreglo[k];
					}
					JOptionPane.showMessageDialog(null, cadena);
				}
				
			}
			
			if(res==3) {
				System.exit(0);
			}
		}
	
	
	}
	
}