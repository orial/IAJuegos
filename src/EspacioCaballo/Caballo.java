package EspacioCaballo;

import EspacioDeEstados.*;
import java.util.*;

/**
 * Write a description of class Caballo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Caballo extends Estado {
	// instance variables - replace the example below with your own
	private int[][] tab;
	private int fil;
	private int col;

	/**
	 * Constructor for objects of class Caballo
	 */
	public Caballo(int[][] tablero) {
		this.tab = new int[tablero.length][tablero[0].length];
		this.copiarTablero(tablero);
	}

	public Caballo(int[][] tablero, int filaCab, int columCab) {
		this.tab = new int[tablero.length][tablero[0].length];
		this.copiarTablero(tablero);
		this.fil = filaCab;
		this.col = columCab;
	}

	public int[][] getTab() {
		return tab;
	}

	private void copiarTablero(int[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				this.tab[i][j] = tablero[i][j];
			}
		}
	}

	protected boolean posicionValida(int f, int c) {
		return (f < tab.length) && (0 <= f) && (c < tab[0].length) && (0 <= c);
	}

	protected boolean visitada(int f, int c) {
		return tab[f][c] == 1;
	}

	@Override
	public List<Caballo> hijos() {

		List<Caballo> h = new ArrayList<Caballo>();


		int f = fil;
		int c = col;
		
		System.out.println(this.toString());
		
		comprobarPosicion(h, f + 2, c + 1);
		comprobarPosicion(h, f + 2, c - 1);
		comprobarPosicion(h, f - 2, c + 1);
		comprobarPosicion(h, f - 2, c - 1);
		comprobarPosicion(h, f + 1, c + 2);
		comprobarPosicion(h, f + 1, c - 2);
		comprobarPosicion(h, f - 1, c + 2);
		comprobarPosicion(h, f - 1, c - 2);

		return h;
	}

	private void comprobarPosicion(List<Caballo> h, int f, int c) {
		if (this.posicionValida(f, c) && !visitada(f, c)) {
			Caballo cb = new Caballo(tab, f, c);
			cb.visitar(f, c);
			h.add(cb);
		}
	}

	public void visitar(int f, int c) {
		tab[f][c] = 1;
	}

	@Override
	public String toString() {
		// return "Posicion=" + "[" + fil + ", "+ col + "]";
		StringBuilder b = new StringBuilder();

		b.append("\n");

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				b.append(tab[i][j]);
				b.append(" ");
			}
			b.append("\n");
		}
		b.append("\n");
		b.append("Caballo: [" + this.fil + " , " + this.col + "]");
		return b.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + col;
		result = prime * result + fil;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caballo other = (Caballo) obj;
		if (col != other.col)
			return false;
		if (fil != other.fil)
			return false;
		return true;
	}

}
