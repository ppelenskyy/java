package tetris;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Tetris extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6555555069535524597L;
	private Scanner sc = new Scanner(System.in);
	private JTextArea text;
	private int opcion;

	private String[][] tabla = 		
		{ {"0"," 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9"," 1"," 0"},
		  {"1","██","░░","░░","░░","░░","░░","░░","░░","░░","░░"," 1"},
		  {"2","██","██","██","░░","░░","░░","░░","░░","░░","░░"," 2"},
		  {"3","░░","░░","░░","░░","░░","░░","░░","░░","░░","░░"," 3"},
		  {"4","░░","░░","░░","░░","░░","░░","░░","░░","░░","░░"," 4"},
		  {"5","░░","░░","░░","░░","░░","░░","░░","░░","░░","░░"," 5"},
		  {"6","░░","░░","░░","░░","░░","░░","░░","░░","░░","░░"," 6"},
		  {"7","░░","░░","░░","░░","░░","░░","░░","░░","░░","░░"," 7"},
		  {"8","░░","░░","░░","░░","░░","░░","░░","░░","░░","░░"," 8"},
		  {"9","░░","░░","░░","░░","░░","░░","░░","░░","░░","░░"," 9"},
		  {"1","░░","░░","░░","░░","░░","░░","░░","░░","░░","░░"," 1"},
		};
	
	Tetris() {
		setTitle("TETRIS");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		text = new JTextArea();
		add(text);
		
		addKeyListener(this);
		setFocusable(true);
		
		setVisible(true);
		
		dibujarTabla();
		switchTetris();

	}
	
	//38 up, 40 down, 37 left, 39 right, 27 esc
	private void switchTetris() {
		do {
			switch(opcion) {
			case 38:
				moveUp();
				break;
			
			case 40:
				moveDown();
				break;
			
			case 37:
				moveLeft();
				break;
			
			case 39:
				moveRight();
				break;
			
			case 27:
			}	
		} while(opcion != 27);	
	}
	
	// Método para dibujar la tabla en consola.
	private void dibujarTabla() {
		String texto = "";
		
		for(int i = 0; i < tabla.length; i++) {
			for(int k = 0; k < tabla[i].length; k++) {
				texto += tabla[i][k];
			}
			texto += "\n";
			text.setText(texto);
		}
	}
	
	// Método para mover figura hacia abajo.
	private void moveUp() {	
		int[][] pos = new int[100][2];
		int indx = 0;
		int count = 0;
		
		for(int i = 0; i < tabla.length; i++) {
			for(int k = 0; k < tabla[i].length; k++) {
				if (tabla[i][k].equals("██") && tabla[10][k].equals("██")){
					break;
				}
				if (tabla[i][k].equals("██") && i != 10) {
					tabla[i][k] = "░░";
					pos[count][0] = i;	
					pos[count][1] = k;	
					count++;
				}
			}
		}
		System.out.println(count);
		while (count > 0) {
				tabla[(pos[indx][0])+1][pos[indx][1]] = "██";
				indx++;
				count--;	
		}
		dibujarTabla();	
	}
	
	// Método para mover figura hacia abajo.
	private void moveDown() {	
		int[][] pos = new int[100][2];
		int indx = 0;
		int count = 0;
		
		for(int i = 0; i < tabla.length; i++) {
			for(int k = 0; k < tabla[i].length; k++) {
				if (tabla[i][k].equals("██") && tabla[10][k].equals("██")){
					break;
				}
				if (tabla[i][k].equals("██") && i != 10) {
					tabla[i][k] = "░░";
					pos[count][0] = i;	
					pos[count][1] = k;	
					count++;
				}
			}
		}
		System.out.println(count);
		while (count > 0) {
				tabla[(pos[indx][0])+1][pos[indx][1]] = "██";
				indx++;
				count--;	
		}
		dibujarTabla();	
	}

	// Método para mover figura hacia la izquierda.
	private void moveLeft() {	
		int[][] pos = new int[100][2];
		int indx = 0;
		int count = 0;
		
		for(int i = 0; i < tabla.length; i++) {
			for(int k = 0; k < tabla[i].length; k++) {
				if (tabla[i][k].equals("██") && tabla[i][10].equals("██")){
					break;
				}
				if (tabla[i][k].equals("██") && k != 10) {
					tabla[i][k] = "░░";
					pos[count][0] = i;	
					pos[count][1] = k;	
					count++;
				}
			}
		}
		System.out.println(count);
		while (count > 0) {
				tabla[pos[indx][0]][pos[indx][1]+1] = "██";
				indx++;
				count--;	
		}
		dibujarTabla();	
	}
	
	// Método para mover figura hacia la derecha.
	private void moveRight() {	
		int[][] pos = new int[100][2];
		int indx = 0;
		int count = 0;
		
		for(int i = 0; i < tabla.length; i++) {
			for(int k = 0; k < tabla[i].length; k++) {
				if (tabla[i][k].equals("██") && tabla[i][10].equals("██")){
					break;
				}
				if (tabla[i][k].equals("██") && k != 10) {
					tabla[i][k] = "░░";
					pos[count][0] = i;	
					pos[count][1] = k;	
					count++;
				}
			}
		}
		System.out.println(count);
		while (count > 0) {
				tabla[pos[indx][0]][pos[indx][1]+1] = "██";
				indx++;
				count--;	
		}
		dibujarTabla();	
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		opcion = e.getKeyCode();
	}

}


