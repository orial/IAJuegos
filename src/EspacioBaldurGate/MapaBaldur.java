package EspacioBaldurGate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import EspacioDeEstados.Estado;

public class MapaBaldur extends Estado
{
	
	protected static boolean[][] mapa;
	public static String[][] mostrar;
	// Guardamos en solucion: fila, columna y 1 si es valido y 0 si es obstáculo
	private int [] solucion;
	
	public MapaBaldur(String map) {
		mapa = new boolean[512][512];
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(map));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("El fichero no se ha encontrado");
		}
		int i = 0;
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			if (linea.charAt(0) == '@' || linea.charAt(0) == '.'){
				for(int j = 0; j < linea.length(); j++){
					if (linea.charAt(j) == '@'){
						mapa[i][j] = false;
						
					}
					else {
						mapa[i][j] = true;
					}
				}
				i++;
			}
		}
	}
	
	public MapaBaldur(String map, int [] sol){
		this(map);
		this.solucion = new int [sol.length];
		this.copiarSolucion(sol);
		generarMostrar();
	}
	
	private void generarMostrar() {
		mostrar = new String[512][512];
		for (int i = 0; i < mostrar.length; i++)
		{
			for (int j = 0; j < mostrar[i].length; j++)
			{
				if(!mapa[i][j]){
					mostrar[i][j] = "X";
				}
				else{
					mostrar[i][j] = " ";
				}
			}
		}
		
	}

	public MapaBaldur(int [] sol){
		this.solucion = new int [sol.length];
		this.copiarSolucion(sol);
	}
	
	protected void copiarSolucion(int [] sol) {
		for (int i = 0; i < sol.length; i++) {
			this.solucion[i] = sol[i];
		}
	}
	
	public int[] getSolucion() {
		return solucion;
	}

	@Override
	public List<MapaBaldur> hijos() {
		List<MapaBaldur> h = new ArrayList<MapaBaldur>();
		int f = this.solucion[0];
		int c = this.solucion[1];
		
		//System.out.println(this.toString());
		comprobarPosicion(h, f + 1, c);
		comprobarPosicion(h, f + 1, c + 1);
		comprobarPosicion(h, f + 1, c - 1);
		comprobarPosicion(h, f - 1, c);
		comprobarPosicion(h, f - 1, c + 1);
		comprobarPosicion(h, f - 1, c - 1);
		comprobarPosicion(h, f, c + 1);
		comprobarPosicion(h, f, c - 1);
		
		return h;
	}
	
	protected void comprobarPosicion(List<MapaBaldur> h, int f, int c) {
		if (this.posicionValida(f, c)) {
			int [] aux = new int [2];
			aux[0] = f;
			aux[1] = c;
			
			MapaBaldur mb = new MapaBaldur(aux);
			h.add(mb);
		}
	}
	
	protected boolean posicionValida(int f, int c) {
		return (f < mapa.length) && (f >= 0) && (c < mapa[f].length) && (c >= 0) && mapa[f][c];
	}
	
	public void setSolucion(int [] sol)
	{
		this.solucion = sol;
	}

	

	@Override
	public String toString() {
		return  Arrays.toString(solucion);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(solucion);
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
		MapaBaldur other = (MapaBaldur) obj;
		if (!Arrays.equals(solucion, other.solucion))
			return false;
		return true;
	}
	
	public int coste (Estado m){
		MapaBaldur mb = (MapaBaldur)m;
		if(Math.abs(this.getSolucion()[0] - mb.getSolucion()[0]) + Math.abs(this.getSolucion()[1] - mb.getSolucion()[1])==2){
			return 1414;
		}
		else{
			return 1000;
		}
	}
}
