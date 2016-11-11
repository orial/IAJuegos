package EspacioJarras;
import java.util.*;


/**
 * Write a description of class TestJarras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestJarras
{
    public static void main (String[] args) {
        Jarras s = new Jarras(5,0);
        PJarras problema = new PJarras(s);
        
        List<Jarras> solucion = problema.amplitud();
        
        for(Jarras j:solucion) {
            j.ver();
        }
    }
}
