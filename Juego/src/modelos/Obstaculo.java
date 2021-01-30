package modelos;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;

public class Obstaculo {
	Juego jueguito;
	//variables que delimitan el area del obstaculo
	Area cabeza,cuerpo,vaca;
	// variables del tama�o del obstaculo
	int anchoObstaculo = 70;
	int altoObstaculo = 70;
	//coordenadas iniciales donde se ubica el objeto
	public static int x_inicial = 1300;
	static int y_inicial = 270;
	//coordenadas para manipular el objeto
	public static int x_auxiliar = -4;
	
	public Obstaculo(Juego jueguito) {
		this.jueguito = jueguito;
	}
	
	public void mover() {
		if(x_inicial <= -100) {
			jueguito.puntos++;
			x_inicial = 1300;
			if(jueguito.puntos ==3 | jueguito.puntos ==6 | jueguito.puntos ==9 | jueguito.puntos ==12 ) {
				x_auxiliar +=-2;
				jueguito.nivel++;
			}
			
		}else {
			if(colision()) {
				if(jueguito.vidas == 0) {
					jueguito.finJuego();
					
				}else {
					jueguito.pierdeVida();
				}
			}else {
				
				x_inicial += x_auxiliar;
			}
		}
	}
	
	public Area getBounds() {
		Ellipse2D forma1 = new Ellipse2D.Double(x_inicial,y_inicial,40,40);
		
		Rectangle forma2= new Rectangle(x_inicial+12,y_inicial+16,50,43);
		
		cabeza = new Area(forma1);
		cuerpo = new Area(forma2);
		
		vaca= cabeza;
		vaca.add(cabeza);
		vaca.add(cuerpo);
		return vaca;
	}
	
	public boolean colision() {
		Area areaA = new Area(jueguito.auto.getBounds());
		areaA.intersect(getBounds());
		
		return !areaA.isEmpty();
	}
	
	
	
	
	
	
	
	
	public void paint(Graphics2D g) {
		ImageIcon animal = new ImageIcon(getClass().getResource("/multimedia/vaquita.png"));
		g.drawImage(animal.getImage(), x_inicial, y_inicial, anchoObstaculo, altoObstaculo, null);
	}
	
	
	
}
