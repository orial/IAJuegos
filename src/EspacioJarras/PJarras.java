package EspacioJarras;
import EspacioDeEstados.*;

/**
 * Write a description of class PJarras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PJarras extends Problema<Jarras>
{
    
    /**
     * Constructor for objects of class PJarras
     */
    public PJarras(Jarras e)
    {
        this.ini = e;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean esFinal(Jarras e)
    {
        return e.getJp() == 1;
    }
}
