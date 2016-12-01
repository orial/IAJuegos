package Jugadores;

import java.util.List;

import EspacioJuego.EstadoJuego;
import EspacioJuego.Ficha;


/**
 * Jugador que elige el siguiente movimiento evaluando los sucesores
 * de la posicion actual a una profundidad dada, y propagando los
 * valores mediante la estrategia Alfa-Beta.
 * 
 * @author Lorenzo Mandow
 * 
 * @version: 2013-11-18
 *
 */
public class JugadorAlfaBeta extends JugadorEvaluar {

    private int profMax;            // Profundidad maxima de busqueda.
    
    /**
     * Constructor.
     * 
     * @param ev                Evaluador.
     * @param profundidadMaxima Profundidad maxima de busqueda.
     */
    public JugadorAlfaBeta(Evaluador ev, int profundidadMaxima) {
        super(ev);
        this.profMax = profundidadMaxima;
    }
    
    @Override
    public EstadoJuego mueve(EstadoJuego e) {
        VE resultado = negamaxAB(e, this.profMax, e.fichaActual(), e.fichaOtro(), 1, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);     
        System.out.println("Evaluacion del movimiento: " + resultado.v());
        
        return resultado.e();
    }
    
    /**
     *  NEGAMAX Alfa-beta
     */
    
    public VE negamaxAB (EstadoJuego e, int prof, Ficha fmax, Ficha fmin, int signo, double alfa, double beta) {
        EstadoJuego mejorE = null;
        double mejorV = Double.NEGATIVE_INFINITY;
        double v2;
        
        if (prof == 0 || e.ganador()!=null || e.agotado()) {
            mejorV = signo*evalua(e, fmax, fmin);
        } else {
            for (EstadoJuego e2 : ordenar(e.hijos())) {
                v2 = -(negamaxAB (e2, prof-1, fmax, fmin, -signo, -beta, -alfa).v());
                if ((v2 > mejorV) || (mejorE == null)) {
                    mejorV = v2;
                    mejorE = e2;
                     if (v2 >= beta){
                         return new VE(mejorV, mejorE);
                    }
                    if (v2 >  alfa){
                        alfa = v2;
                    }
                }
            }
        }
        return new VE(mejorV, mejorE);
    }
    
    List<EstadoJuego> ordenar (List<EstadoJuego> l) {
        return super.barajar(l);    
    }
}
