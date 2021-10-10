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

    @Override
    public String toString() {
        return String.valueOf(dato);
    }
    
    /**
     * Este método verifica si un nodo es completo, osea si tiene hijo izquierdo y derecho.
     * De manera recursiva tambien recorre el arbol verificando si los hijos del nodo que llamo el método son completos.
     * @return un número entero que indica cuantos nodos son completos.
     */        
    public int nodoCompletos(){
        if(this == null){
            return 0;
        }
        else{
            if(this.retornaLI() != null && this.retornaLD() != null){
                return this.retornaLI().nodoCompletos() + this.retornaLD().nodoCompletos() + 1;
            }
            if(this.retornaLI() == null){
                return 0;
            }
            else if(this.retornaLD() == null){
                return 0;
            }
            else{
                return this.retornaLI().nodoCompletos() + this.retornaLD().nodoCompletos();
            }            
        }
    }
    
    /**
     * Calcula el grado del nodo que llame el método.
     * @return el grado del nodo en un entero.
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
