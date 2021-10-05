package Modelo;

/**
 *
 * @author Sofito-Chan
 */
public class NodoDoble {

    NodoDoble ligaIzquierda, ligaDerecha;
    Object dato;
    
    public NodoDoble(Object d){
        ligaIzquierda = ligaDerecha = null;
        dato = d;
    }
    /**
     * 
     * @param n
     * @return 
     */
    public int nodoCompletos(NodoDoble n){
        if(n == null){
            return 0;
        }
        else{
            if(n.retornaLI() != null && n.retornaLD() != null){
                return nodoCompletos(n.retornaLI()) + nodoCompletos(n.retornaLD()) + 1;
            }
            return nodoCompletos(n.retornaLI()) + nodoCompletos(n.retornaLD());
        }
    }
    /**
     * 
     * @return 
     */
    public int grado() {
        int g = 0;
        if (ligaDerecha != null) {
            g = g + 1;
        }
        if (ligaIzquierda != null) {
            g = g + 1;
        }
        return g;
    }
    
    public void asignaLI(NodoDoble x){
        ligaIzquierda = x;
    }
    
    public void asignaLD(NodoDoble x){
        ligaDerecha = x;
    }
    
    public void asignaDato(Object d){
        dato = d;
    }
    
    public Object retornaDato(){
        return dato;
    }
    
    public NodoDoble retornaLD(){
        return ligaDerecha;
    }
    
    public NodoDoble retornaLI(){
        return ligaIzquierda;
    }
}
