package EspacioJuego;

import java.text.DecimalFormat;

import Jugadores.Jugador;

/**
 * 
 * Un juego está definido por un estado inicial y 2 jugadores. Cada vez que se juegue una partida,
 * del juego, el resultado dependerá de las acciones realizadas por cada uno de los jugadores.
 * 
 * @author José Miguel Horcas Aguilera, Lorenzo Mandow
 * 
 * @version 21-10-2013
 *
 */
public class Juego {
    public Jugador jug1;
    public Jugador jug2;
    EstadoJuego eIni;
    
    /**
     * Constructor. Una partida consta de dos jugadores y un estado inicial.
     * 
     * @param jug1  Jugador 1.
     * @param jug2  Jugador 2.
     * @param eIni     Estado inicial de un juego.
     * 
     */
    
    public Juego (Jugador j1, Jugador j2, EstadoJuego eIni){
        this.jug1 = j1;
        this.jug2 = j2;
        this.eIni = eIni;
    }
     
    
    /**
     * Controla el desarrollo de la partida hasta que haya terminado.
     * 
     * @param eco   Permite opcionalmente mostrar por pantalla el desarrollo del juego.
     * @return      1, 0, -1, según gane el primer jugador, haya empate, o gane el segundo jugador, respectivamente.
     */
    public int jugarPartida (boolean eco) {
        return jugarPartida(eIni, eco);
    }
    
    public int jugarPartida(EstadoJuego e, boolean eco){
        int resultado;
        Jugador jug;
        
        if (eco) {
            //System.out.println(e.toString());
            e.ver();
        }
        if (e.ganador()!=null) {
            resultado = e.turno1() ? -1 : 1;
        } else if (e.agotado()) {
            resultado = 0;
        } else {
            jug = e.turno1() ? jug1 : jug2;     // Le toca a jug.
            resultado = jugarPartida(jug.mueve(e), eco);
        }
        return resultado;
    }
    
    public void jugar(int n){
    	double gan=0,perd=0, emp=0;
    	int res;
    	for (int i=0; i<n ;i++){
    		res = jugarPartida(false);
    		switch(res){
    		case 1:
    			gan++;
    			break;
    		case 0:
    			emp++;
    			break;
    		case -1:
    			perd++;
    		}
    	}
    	DecimalFormat twoDForm = new DecimalFormat("#.00");
    	
    	System.out.println("Primer jugador: "+ twoDForm.format((gan)/n*100) + " %");
    	System.out.println("Segundo jugador: "+ twoDForm.format((perd/n)*100) + " %");
    	System.out.println("Empates: "+ twoDForm.format((emp/n)*100) + " %");
    }

}
