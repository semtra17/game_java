package modelos;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Fondo {
//objeto de la clase juego
	Juego jueguito;
	//variables dle tamaño del fondo
	int anchoFondo = 1300;
	int alto_Fondo = 400;
	//coordenadas inciiales para mover el fondo
	int x1 = 1300;
	int y1 = 0;
	//coordewnadas auxiliares que mueven otro fondo
	int x2= 0;
	int y2= 0;
	
	
	
	
	public Fondo(Juego jueguito) {

	this.jueguito = jueguito;	
	}
	
	public void mover() {
		x1 -=2;
		x2 -=2;
		if(x1==0 && x2 ==-1300) {
			x1=1300;
			x2 = 0;
			
		}
	}
	public void paint(Graphics2D g) {
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/multimedia/fondo.jpg"));
		g.drawImage(imagenFondo.getImage(), x1, y1,anchoFondo,alto_Fondo,null);
		g.drawImage(imagenFondo.getImage(), x2, y2,anchoFondo,alto_Fondo,null);
	}
}
