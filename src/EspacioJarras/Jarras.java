package EspacioJarras;
import EspacioDeEstados.*;
import java.util.*;

/**
 * Write a description of class Jarras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jarras extends Estado
{
    // instance variables - replace the example below with your own
    private int jg;
    private int jp;
    
    public final static int MAXG = 5;
    public final static int MAXP = 2;

    /**
     * Constructor for objects of class Jarras
     */
    public Jarras(int jg, int jp)
    {
        // initialise instance variables
        this.jg = jg;
        this.jp = jp;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public List<Jarras> hijos()
    {
        // put your code here
        List<Jarras> listaHijos = new ArrayList<Jarras>();
        
        if (this.jg > 0) {
            listaHijos.add(new Jarras(0, this.jp));
        }
        if ( this.jp > 0) {
            listaHijos.add(new Jarras(this.jg, 0));
        }
        if (( this.jg > 0) && (this.jg + this.jp) <= MAXG && this.jp < MAXP){
            listaHijos.add(new Jarras(0, this.jp + this.jg)); 
        }
        if (( this.jp > 0) && (this.jg + this.jp) <= MAXG && this.jg < MAXG) {
            listaHijos.add(new Jarras(this.jp + this.jg, 0)); 
        }
        if (( this.jg > 0) && (this.jg + this.jp) > MAXP && this.jp < MAXP) {
            listaHijos.add(new Jarras(this.jp + this.jg - MAXP, MAXP)); 
        }
        if (( this.jp > 0) && (this.jg + this.jp) > MAXG && this.jg < MAXG) {
            listaHijos.add(new Jarras(MAXG, this.jp + this.jg - MAXG)); 
        }
        return listaHijos;
    }
    
    public String toString() {
        return Integer.toString(this.jg) + " " + Integer.toString(this.jp);
    }
    
    public int getJg(){
        return this.jg;
    }
    
    public int getJp(){
        return this.jp;
    }
    
    public void setJg(int jg){
         this.jg = jg;
    }
    
    public void setJp(int jp){
         this.jp = jp;
    }
}
