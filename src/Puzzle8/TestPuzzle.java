package Puzzle8;

import java.util.List;
/**
 * Pruebas para el puzzle 2D de piezas deslizantes.
 * 
 * @Jose Miguel Horcas Aguilera, Lorenzo Mandow
 *
 */
public class TestPuzzle {
    
    public static void main(String[] args) {
    
    	//testH0();
    	//testDPB();
    	int[][] p1 = {{3,2,5},{6,0,4},{7,8,1}};
        Puzzle puzzle1 = new Puzzle(p1);
        int[][] p2 = {{8,1,7},{4,5,6},{2,0,3}};
        Puzzle puzzle2 = new Puzzle(p2);
        System.out.println("Resultados para puzzle:");
        puzzle1.ver();
        testH0(puzzle1);
        testDesc(puzzle1);
        testMan(puzzle1);
        testBDP5(puzzle1);
        testBDP4(puzzle1);
        System.out.println("Resultados para puzzle:");
        puzzle2.ver();
        testH0(puzzle2);
        testDesc(puzzle2);
        testMan(puzzle2);
        testBDP5(puzzle2);
        testBDP4(puzzle2);
    }
    
    public static void testH0(Puzzle s){
    	//Puzzle s = new Puzzle(3,3);
    	//int[][] ttt = {{1,2,0},{3,4,5},{6,7,8}};
        //Puzzle s = new Puzzle(ttt);
		ProbPuzzleH0 problema = new ProbPuzzleH0(s);
		
		List<Puzzle> l =  problema.aMono();
		
		if (l != null) {
            System.out.println("Iteraciones Busqueda ciega: " + problema.getIteraciones());
        } else {
            System.out.println("No se ha podido encontrar la Solución");
        }    
	}
	
	public static void testDPB() {
        Puzzle s = new Puzzle(3,3);
		ProbPuzzleBDP problema = new ProbPuzzleBDP(s, 5);
		
		List<Puzzle> l = problema.aMono();
		
		if (l != null) {
			System.out.println("Profundidad de la solucion: " + (l.size()-1));
            System.out.println("Camino Solucion:");
            for (Puzzle e : l) {
               e.ver();
            }
        } else {
            System.out.println("No se ha podido encontrar la Solucion");
        }        
	}
	
	public static void testMan(Puzzle p){
		
		ProbPuzzleManhattan problema = new ProbPuzzleManhattan(p);
		
		List<Puzzle> l =  problema.aMono();
		l = problema.aMono();
        
        if (l != null) {
            System.out.println("Iteraciones con heuristico distancia Manhattan: " + problema.getIteraciones());
        } else {
            System.out.println("No se ha podido encontrar la Solución");
        }
	}
	
public static void testDesc(Puzzle p){
		
		ProbPuzzleDes problema = new ProbPuzzleDes(p);
		
		List<Puzzle> l =  problema.aMono();
		l = problema.aMono();
        
        if (l != null) {
            System.out.println("Iteraciones con heuristico piezas descolocadas: " + problema.getIteraciones());
        } else {
            System.out.println("No se ha podido encontrar la Solución");
        }
	}

public static void testBDP4(Puzzle p){
	
	ProbPuzzleBDP problema = new ProbPuzzleBDP(p,4);
	
	List<Puzzle> l =  problema.aMono();
	l = problema.aMono();
    
    if (l != null) {
        System.out.println("Iteraciones con heuristico BDP 4 comodines: " + problema.getIteraciones());
    } else {
        System.out.println("No se ha podido encontrar la Solución");
    }
}

public static void testBDP5(Puzzle p){
	
	ProbPuzzleBDP problema = new ProbPuzzleBDP(p,5);
	
	List<Puzzle> l =  problema.aMono();
	l = problema.aMono();
    
    if (l != null) {
        System.out.println("Iteraciones con heuristico BDP 5 comodines: " + problema.getIteraciones());
    } else {
        System.out.println("No se ha podido encontrar la Solución");
    }
}
	
	

	
}
