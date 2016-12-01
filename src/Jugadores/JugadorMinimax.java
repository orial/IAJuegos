package Jugadores;

import java.util.List;

import EspacioJuego.EstadoJuego;
import EspacioJuego.Ficha;


/**
 * Jugador que elige el siguiente movimiento evaluando los sucesores
 * de la posicion actual a una profundidad dada, y propagando los
 * valores mediante la estrategia MiniMax.
 * 
 * @author Jose Miguel Horcas Aguilera, Lorenzo Mandow
 * 
 * @versión: 2013-10-22
 *
 */
public class JugadorMinimax extends JugadorEvaluar {

    private int profMax;            // Profundidad maxima de búsqueda.
    
    /**
     * Constructor.
     * 
     * @param ev                Evaluador.
     * @param profundidadMaxima Profundidad maxima de busqueda.
     */
    public JugadorMinimax(Evaluador ev, int profundidadMaxima) {
        super(ev);
        this.profMax = profundidadMaxima;
    }
    
    @Override
    public EstadoJuego mueve(EstadoJuego e) {
        VE resultado = negamax(e, this.profMax, e.fichaActual(), e.fichaOtro(), 1);
        
        System.out.println("Evaluacion del movimiento: " + resultado.v());
        
        return resultado.e();
    }
    
  
    /**
     * Realiza una evaluacion MINIMAX de un estado dado a una profundidad dada.
     * El calculo se realiza mediante una funcion recursiva por la cola que implementa
     * el metodo de calculo conocido como NEGAMAX: en cada nivel se calcula siempre el
     * maximo de los sucesores cambiado de signo, pero las evaluaciones se van cambiando
     * de signo segun la profundidad, de modo que en los niveles MIN, calcular el maximo 
     * cambiado de signo de las evaluaciones cambiadas de signo equivale a calcular el ma�nimo.
     * 
     * @param e     Estado del juego.
     * @param prof  Profundiad de la busqueda.
     * @param fmax  Ficha del jugador MAX.
     * @param fmin  Ficha del jugador MIN.
     * @param signo Tomara inicialmente el valor 1, e ira alternando de signo con la profundidad.
     * @return      Objeto VE con el mejor estado sucesor y su valoracion minimax.
     */
    
    public VE negamax (EstadoJuego e, int prof, Ficha fmax, Ficha fmin, int signo) {
        EstadoJuego mejorE = null;
        double mejorV = Double.NEGATIVE_INFINITY;
        double v2;
        
        if (prof == 0 || e.ganador()!=null || e.agotado()) {
            mejorV = signo*evalua(e, fmax, fmin);
        } else {
            for (EstadoJuego e2 : ordenar(e.hijos())) {
                v2 = -(negamax(e2, prof-1, fmax, fmin, -signo).v());
                if ((v2 > mejorV) || (mejorE == null)) {
                    mejorV = v2;
                    mejorE = e2;
                }
            }
        }
        return new VE(mejorV, mejorE);
    }
    
    List<EstadoJuego> ordenar (List<EstadoJuego> l) {
        return super.barajar(l);    
    }
}
