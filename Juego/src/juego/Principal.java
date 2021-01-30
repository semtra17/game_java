package juego;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelos.Auto;
import modelos.Juego;
import modelos.Obstaculo;
public class Principal {
	public static int reiniciaJuego=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		JOptionPane.showMessageDialog(null, "¿Estas listo?");
		JFrame ven = new JFrame();
		Juego jueguito = new Juego();
		ven.add(jueguito);
		ven.setSize(1300,400);
		ven.setLocation(70,200);
		ven.setVisible(true);
		ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			
			if(jueguito.juegoFinalizado) {
				reiniciaJuego =JOptionPane.showConfirmDialog(null, "Haz Perdido ¿ Quieres jugar de nuevo?","Haz Perdido",JOptionPane.YES_NO_OPTION);
				if(reiniciaJuego == 0) {
					reiniciaValores();
				}else if(reiniciaJuego ==1) {
					System.exit(0);
				}
			}else {
				jueguito.repaint();
				try {
					Thread.sleep(10);
					//QUE ES THREAD SLEEP
				}catch(InterruptedException ex) {
					//QUE ES ESTE TIPO DE INTERRUPCION?
					Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
					//Y ESTO QUE VERGA ES?
				}
				if(Juego.pierdeVida == true) {
					JOptionPane.showMessageDialog(null, "Cuidado!!!");
					Juego.pierdeVida = false;
					Juego.vidas--;
					Auto.y_inicial = 270;
					Auto.saltando = false;
					Obstaculo.x_inicial=1300;
				}
			}
			
			
			
			
			
			
			
			jueguito.repaint();
			try {
				Thread.sleep(10);
				//QUE ES THREAD SLEEP
			}catch(InterruptedException ex) {
				//QUE ES ESTE TIPO DE INTERRUPCION?
				Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
				//Y ESTO QUE VERGA ES?
			}
			
			
		}
	}
	public static void reiniciaValores() {
		Juego.juegoFinalizado = false;
		Obstaculo.x_auxiliar =-4;
		Juego.puntos = 0;
		Juego.nivel = 1;
		Juego.vidas = 3;
		reiniciaJuego = -1;
		Obstaculo.x_inicial = 1300;
		
	}

}
