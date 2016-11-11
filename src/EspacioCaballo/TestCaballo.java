package EspacioCaballo;

import java.util.List;

/**
 * Write a description of class TestCaballo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaballo
{
   public static final int tam = 5;
   
   public static final int fini = 2;
   public static final int cfin = 2;
   
   public static int [][] tablero = new int [tam][tam];

   public static void main(String[] args) {
	   tablero[fini][cfin]=1;
	   Caballo c = new Caballo(tablero, fini, cfin);
	   
	   PCaballo pC = new PCaballo(c);
	   
	   List<Caballo> lc = pC.amplitud();
	   if(lc !=null) {
		   for(Caballo cb: lc) {
			   cb.ver();
		   }
	   }
	   else {
		   System.out.println("No se ha encontrado solucion");
	   }
   }
   
}
