package EspacioBaldurGate;

import EspacioDeEstados.Problema;

public class PMapaBaldur extends Problema <MapaBaldur>{

	int ffin;
	int cfin;
	
	public PMapaBaldur(MapaBaldur m, int f, int c)
    {
        this.ini = m;
        ffin = f;
        cfin = c;
    }
	
	@Override
	public boolean esFinal(MapaBaldur e) {
		if(e.getSolucion()[0] != ffin || e.getSolucion()[1] != cfin) {
			return false;
		}
		return true;
	}
	
	@Override
    public int h(MapaBaldur m)
    {
        int filas = Math.abs(ffin - m.getSolucion()[0]);
        int columnas = Math.abs(cfin - m.getSolucion()[1]);
        int diagonal = Math.min(filas, columnas) * 1414;
        int normal = (Math.max(filas, columnas)- Math.min(filas, columnas)) * 1000; 
        return diagonal + normal;
    }
	
	
}
