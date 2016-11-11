package EspacioCaballo;

import EspacioDeEstados.*;


/**
 * Write a description of class PCaballo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PCaballo extends Problema<Caballo>
{
    /**
     * Constructor for objects of class PCaballo
     */
    public PCaballo(Caballo c)
    {
        this.ini = c;
    }

    
	@Override
	public boolean esFinal(Caballo e) {
		for (int i=0; i < e.getTab().length; i++) {
			for (int j=0; j < e.getTab()[i].length; j++) {
				if(e.getTab()[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
