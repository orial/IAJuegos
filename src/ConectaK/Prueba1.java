package ConectaK;

import EspacioJuego.*;
import Jugadores.*;


/**
 * Prueba del juego del Conecta k con dos jugadores aleatorios y aleatorio y humano
 * 
 * @author Lorenzo Mandow
 * @version 21-10-2013
 */
public class Prueba1
{
    public static void main()
    {
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorAleatorio();
        Jugador j2 = new JugadorAleatorio();
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);
        
        Jugador j3 = new JugadorHumanoCK();
        Juego juego2 = new Juego(j1, j3, e);
        
        verPartida(juego2);
    }
    
    public static void pruebaTablero() {
        TableroCK tab = new TableroCK(3,3);
        
        tab.ver();
        
        tab.soltarFicha(0, new Ficha('x'));
        tab.ver();
        tab.soltarFicha(0, new Ficha('o'));
        tab.ver();
        tab.soltarFicha(1, new Ficha('x'));
        tab.ver();
        System.out.println(tab.conectadas(2, 0, 0, -1));
        
        System.out.println(tab.conectadas(2, 0, 0, 1));
        
        System.out.println(tab.conectadas(2, 0, 1, 0));
    }
    
    
    public static void pruebaPosibilidades(int fi, int co, int k) {
        
        MatrizPosibilidades matriz = new MatrizPosibilidades(fi,co,k);
        
        for (int f = 0; f < fi; f++) {
            for (int c = 0; c < co; c++) {
                System.out.print("(");
                for (Integer i : matriz.posibilidades(f, c)) {
                    System.out.print(i + " ");
                }
                System.out.print(")"   );
            }
            System.out.println();
        }
        System.out.println("num pos: " + matriz.numPosibilidades());
    }   
    
    public static void aleatorio(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorAleatorio();
        Jugador j2 = new JugadorAleatorio();
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);
    }
    
    public static void aleatorioHumano(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorAleatorio();
        Jugador j2 = new JugadorHumanoCK();
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);       
    }
    
    public static void aleatorioEvaluar(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorAleatorio();
        
        Jugador j2 = new JugadorEvaluar(new EvaluadorCK(3,3,3));
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);       
    }
    
    public static void evaluarHumano(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorEvaluar(new EvaluadorCK(3,3,3));
        Jugador j2 = new JugadorHumanoCK();
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);       
    }
    
    public static void humanoMinimax3(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorHumanoCK();
        
        Jugador j2 = new JugadorMinimax(new EvaluadorCK(3,3,3), 3);
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);       
    }
    
    public static void humanoMinimax9(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorHumanoCK();
        
        Jugador j2 = new JugadorMinimax(new EvaluadorCK(3,3,3), 9);
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);       
    }
    
    
    public static void pruebaMinimax(){
        ConectaK e = new ConectaK(3,3,3);
        JugadorMinimax j1 = new JugadorMinimax(new EvaluadorCK(3,3,3), 1);
   
        System.out.println("Valoraciones de la posicion inicial");
        for (int prof = 0; prof < 11; prof++){
        
            System.out.printf("\nProf: %d , Valor: %f", prof, 
            (j1.negamax((EstadoJuego)e, prof, e.fichaActual(), e.fichaOtro(), 1)).v());
        
        }
        
    }
  
public static void verPartida (Juego juego){
        int i =  juego.jugarPartida(true);
        
        if (i == 0){
            System.out.println("Empate.");
        } else if (i == 1) {
            System.out.println("Gana el primer jugador.");
        } else {
            System.out.println("Gana el segundo jugador.");
        }
    }
}