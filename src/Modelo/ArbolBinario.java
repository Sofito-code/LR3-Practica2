/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;

/**
 * Esta clase crea la estructura de un árbol binario.
 * 
 * @author Sofito-Chan
 * @author JohnDRD
 */
public class ArbolBinario {

    private NodoDoble raiz;
    List<String> in = new LinkedList<>();
    List<String> pre = new LinkedList<>();
    List<String> pos = new LinkedList<>();
    String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public ArbolBinario() {
        raiz = null;
    }

    public ArbolBinario(NodoDoble x) {
        raiz = x;
    }
    
    public NodoDoble getRaiz() {
        return raiz;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * Construye un árbol binario aleatorio con letras o números. 
     *
     * @param cantidadNodos es el número de nodos que tendrá el árbol binario.
     * @param letras false para usar números, true para usar letras.
     */
    public void ConstruyeArbolBinario1(int cantidadNodos, boolean letras) {
        Random r = new Random();
        List<Object> nodos = new ArrayList<>();
        if (letras == true) {
            for (int i = 0; i < cantidadNodos; i++) {
                String nodo = abc[r.nextInt(25)].toUpperCase();
                if (!nodos.contains(nodo)) {
                    this.agregar(nodo);
                    nodos.add(nodo);
                } else {
                    i--;
                }
            }
        } else {
            for (int i = 0; i < cantidadNodos; i++) {
                String nodo = String.valueOf(r.nextInt(25));
                if (!nodos.contains(nodo)) {
                    this.agregar(nodo);
                    nodos.add(nodo);
                } else {
                    i--;
                }
            }
        }
    }

    /**
     * Construye un árbol binario a partir de un string.
     * 
     * @param x es un string de nodos separados por comas.
     */
    public void ConstruyeArbolBinario2(String x) {
        x = x.toUpperCase();
        Queue<String> cola = new LinkedList();
        cola.addAll(Arrays.asList(x.split(",")));
        while (cola.isEmpty() != true) {
            this.agregar(cola.poll());
        }
    }

    /**
     * Añade un elemento d a un arbol binario que no esté presente en el arbol.
     *
     * @param d es el nombre del nodo.
     */
    public void agregar(Object d) {
        NodoDoble n = new NodoDoble(d);
        /*
         * Si es vacía se puede proceder a hacer el nodo como su único miembro,
         * la raíz.
         * 
         */
        if (esVacio()) {
            raiz = n;
            return;
        }
        NodoDoble p = raiz;
        NodoDoble q = null;
        /*
         * Aquí se buscará el lugar donde se ubicará en nuevo nodo y la
         * dirección de su padre (q).
         */
        while (p != null) {
            if ((Object) p.retornaDato() == d) {
                return;
            }
            q = p;
            if (d.hashCode() < p.retornaDato().hashCode()) {
                p = p.retornaLI();
            } else {
                p = p.retornaLD();
            }
        }
        /*
         * Se determina si el lugar donde se insertará es a la izquierda o a la
         * derecha del nodo p y se procede con la inserción.
         * 
         */
        if (d.hashCode() > q.retornaDato().hashCode()) {
            q.asignaLD(n);
        } else {
            q.asignaLI(n);
        }
    }
    
    /**
     * Construye una lista con el recorrido inorden desde un nodo que pertenezca al árbol.
     * 
     * @param x nodo "raiz" del recorrido.
     * @return una lista de strings con el recorrido inorden.
     */
    public List<String> recorridoIn(NodoDoble x) {
        if (x != null) {
            recorridoIn(x.retornaLI());
            in.add(x.retornaDato().toString());
            recorridoIn(x.retornaLD());
        }
        return in;
    }
    
    /**
     * Construye una lista con el recorrido preorden desde un nodo que pertenezca al árbol.
     * 
     * @param x nodo "raiz" del recorrido.
     * @return una lista de strings con el recorrido preorden.
     */
    public List<String> recorridoPre(NodoDoble x) {
        if (x != null) {
            pre.add(x.retornaDato().toString());
            recorridoPre(x.retornaLI());
            recorridoPre(x.retornaLD());
        }
        return pre;
    }
    
    /**
     * Construye una lista con el recorrido posorden desde un nodo que pertenezca al árbol.
     * 
     * @param x nodo "raiz" del recorrido.
     * @return una lista de strings con el recorrido posorden. 
     */
    public List<String> recorridoPos(NodoDoble x) {
        if (x != null) {
            recorridoPos(x.retornaLI());
            recorridoPos(x.retornaLD());
            pos.add(x.retornaDato().toString());
        }
        return pos;
    }
    /**
     * Vacía las listas de los recorridos.
     */
    public void limpiarRecorridos() {
        in.clear();;
        pre.clear();
        pos.clear();
    }

    /**
     * Permite obtener el numero de hojas del árbol por medio del método hojasporNodo.
     *
     * @return un número entero con la cantidad de hojas del arbol
     */
    public int hojas() {
        if (esVacio()) {
            return 0;
        }
        return (hojasPorNodo(raiz));
    }

    /**
     * Método auxiliar de hojas, realiza una serie de llamadas recursivas a modo
     * de exploración para contar cuáles nodos son hojas dentro del árbol.
     *
     * @param x nodo desde donde se van a contar las hojas.
     * @retutn un número entero con la cantidad de hojas del árbol.
     */
    private int hojasPorNodo(NodoDoble x) {
        if (x == null) {
            return 0;
        }
        if (x.retornaLI() == null && x.retornaLD() == null) {
            return 1;
        }
        int izquierda = hojasPorNodo(x.retornaLI());
        int derecha = hojasPorNodo(x.retornaLD());
        return (izquierda + derecha);
    }

    /**
     * Permite obtener el grado del árbol por medio del método gradoConRaiz.
     *
     * @return un número entero con el grado del árbol binario.
     */
    public int grado() {
        if (esVacio()) {
            return 0;
        }
        return (gradoPorNodo(raiz));
    }

    /**
     * Método auxiliar de grado, realiza la exploración del árbol para
     * determinar su grado por medio de recursión.
     *
     * @param x  nodo desde donde se van a contar el grado del árbol. 
     * @return un número entero con el grado del árbol.
     */
    private int gradoPorNodo(NodoDoble x) {
        if (x == null) {
            return 0;
        }
        int g = x.grado();
        int gmax = g;
        g = gradoPorNodo(x.retornaLD());
        if (g > gmax) {
            gmax = g;
        }
        g = gradoPorNodo(x.retornaLI());
        if (g > gmax) {
            gmax = g;
        }
        if (gmax == 2) {
            return 2;
        }
        return gmax;
    }

    /**
     * Permite obtener la altura del árbol por medio del método alturaPorNodo.
     * 
     * @return un número entero con la altura del árbol.
     */
    public int altura() {
        return alturaPorNodo(raiz);
    }

    /**
     * Método auxiliar de altura, realiza un recorrido por el árbol para encontrar
     * la cadena de nodos más larga de forma descendente retorna dicho valor a
     * modo de altura.
     *
     * @param x nodo desde donde se van a contar la altura del árbol. 
     * @return un número entero con la altura del arbol
     */
    private int alturaPorNodo(NodoDoble x) {
        if (x == null) {
            return 0;
        }
        int izquierda = alturaPorNodo(x.retornaLI());
        int derecha = alturaPorNodo(x.retornaLD());
        if (izquierda > derecha) {
            return (izquierda + 1);
        }
        return (derecha + 1);
    }
    
    /**
     * Convierte una lista de nodoDoble en una lista de String.
     * 
     * @param n es la lista a convertir.
     * @return una lista de Strings.
     */
    public List<String> listaNodoToString(List<NodoDoble> n) {
        List<String> c = new LinkedList<>();
        n.forEach((t) -> {
            c.add(t.retornaDato().toString());
        });
        return c;
    }
   
    /**
     * Permite obtener los nodos hoja del árbol por medio del método hojasPorNodoLista.
     *
     * @return la altura del árbol.
     */
    public List<NodoDoble> nodosHoja() {
        List c = hojasPorNodoLista(raiz);
        return c;
    }
    
    /**
     * Método auxiliar de nodosHoja, realiza una exploración en el árbol para
     * obtener los nodos que cumplen con la condición de ser hojas este método
     * recursivo retorna un objeto de tipo List, recibe como parámetro el nodo a
     * comprobar.
     *
     * @param x nodo desde donde se van a incluir los nodos hoja del árbol. 
     * @return una lista con los nodos hoja del árbol.
     */
    public List<NodoDoble> hojasPorNodoLista(NodoDoble x) {
        if (x == null) {
            return null;
        }
        List<NodoDoble> aux = new ArrayList();
        if (x.retornaLD() == null && x.retornaLI() == null) {
            aux.add(x);
        } else {
            if (x.retornaLD() != null) {
                aux.addAll(hojasPorNodoLista(x.retornaLD()));
            }
            if (x.retornaLI() != null) {
                aux.addAll(hojasPorNodoLista(x.retornaLI()));
            }
        }
        return aux;
    }

    /**
     * Realiza una exploración en el árbol buscando el nodo que contenga el
     * parámetro name de tipo String en el campo de dato, retorna dicho nodo.
     *
     * @param nombre es el campo de dato del nodo a buscar en el árbol.
     * @return un Nodo Doble que contiene el nombre dado.
     */
    public NodoDoble buscarNodo(String nombre) {
        Stack x = new Stack();
        x.add(raiz);
        NodoDoble current;
        String aux;
        while (!x.isEmpty()) {
            current = (NodoDoble) x.pop();
            aux = (String) current.retornaDato();
            if (aux.equals(nombre.toUpperCase())) {
                return current;
            } else {
                if (current.retornaLD() != null) {
                    x.remove(current);
                    x.add(current.retornaLD());
                }
                if (current.retornaLI() != null) {
                    x.remove(current);
                    x.add(current.retornaLI());
                }
            }
        }
        return null;
    }
    
    /**
     * Permite obtener los hijos de un nodo del árbol.
     * 
     * @param x es un nodo del árbol al que se le van obtener los hijos.
     * @return los hijos del nodo dado.
     */
    
    public String hijos(NodoDoble x) {
        List<String> hijos = new LinkedList<>();
        if (x != null) {
            if (x.retornaLI() != null) {
                hijos.add(x.retornaLI().retornaDato().toString());
            }
            if (x.retornaLD() != null) {
                hijos.add(x.retornaLD().retornaDato().toString());
            }
            return hijos.toString();
        } else {
            return null;
        }
    }

    /**
     * Permite obtener el padre de un nodo dado por medio del método pdr.
     *
     * @param x es un nodo al que se le va buscar el padre.
     * @return el nodo padre del nodo dado.
     */
    public NodoDoble padre(NodoDoble x) {
        if (x == raiz) {
            return raiz;
        }
        return pdr(x, raiz);
    }

    /**
     * Método auxiliar que busca de forma recursiva el padre de un nodo dado,
     * toma como parámetros origen del arbol y el nodo el cual se está buscando.
     *
     * @param x es un nodo al que se le va buscar el padre.
     * @param origen es la raiz del arbol.
     * @retun el nodo padre del nodo dado o retorna nulo en caso de no estar presente en el árbol.
     */
    private NodoDoble pdr(NodoDoble x, NodoDoble origen) {
        if (origen.retornaLD() == null && origen.retornaLI() == null) {
            return null;
        } else {
            NodoDoble aux1;
            NodoDoble aux2;
            if (origen.retornaLD() == x || origen.retornaLI() == x) {
                return origen;
            } else {
                if (origen.retornaLD() != null) {
                    aux1 = pdr(x, origen.retornaLD());
                    if (aux1 != null) {
                        return aux1;
                    }
                }
                if (origen.retornaLI() != null) {
                    aux2 = pdr(x, origen.retornaLI());
                    if (aux2 != null) {
                        return aux2;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Permite obtener los ancestros de un nodo dado por medio del método padre, 
     * realiza una lista con todos los nodos que se recorren hasta llegar a la raíz.
     *
     * @param x es un nodo al que se le van buscar los ancestros.
     * @return una lista con los ancestros del nodo dado.
     */
    public List<NodoDoble> ancestros(NodoDoble x) {
        List aux = new ArrayList();
        NodoDoble pc;
        if (x == null) {
            return null;
        }
        pc = padre(x);
        do {
            aux.add(pc);
            pc = padre(pc);
        } while (pc != raiz);
        if (!aux.contains(raiz)) {

            aux.add(raiz);
        }
        return aux;
    }

    /**
     * Permite obtener el hermano de un nodo dado por medio del método padre 
     * que busca el nodo del cual precede el parámetro x. 
     *
     * @param x es un nodo al que se le va buscar el hermano.
     * @return el nodo en el campo de liga opuesto a x. Retorna nulo
     * en caso de no haber ningún nodo en el campo o no encontrarse dicho nodo
     * en el árbol.
     */
    public NodoDoble hermano(NodoDoble x) {
        if (x == null) {
            return null;
        }
        NodoDoble aux = padre(x);
        if (aux == null) {
            return null;
        }
        if (aux == x) {
            return null;
        }
        if (aux.retornaLD() != null && aux.retornaLD() != x) {
            return aux.retornaLD();
            //es derecho
        }
        if (aux.retornaLI() != null && aux.retornaLI() != x) {
            return aux.retornaLI();
            // es izquierdo
        }
        return null;
    }

    /**
     * Permite obtener el lado (derecho o izquierdo) del hermano de un nodo dado por
     * medio del método padre que encuentra el nodo del cual precede el parámetro x. 
     *
     * @param x es un nodo al que se le va consultar el lado del hermano.
     * @return un número entero que puede ser -1 si el nodo no está en el
     * árbol, 1 si está en la derecha, 0 si está en la izquierda.
     */
    public int esIzorDe(NodoDoble x) {
        if (x == null) {
            return -1;
        }
        NodoDoble aux = padre(x);
        if (aux.retornaLD() == x) {
            return 1;
        }
        if (aux.retornaLI() == x) {
            return 0;
        }
        return -1;
    }

    /**
     * Permite obtener el tio de un nodo dado por medio de los métodos hermano y padre.
     * que busca el nodo del cual precede el parámetro x y el hermano de dicho parámetro.
     * 
     *
     * @param x es un nodo al que se le va consultar el tio.
     * @return retorna null si el nodo no está en el árbol o retorna el tio del nodo dado.
     */
    public NodoDoble tio(NodoDoble x) {
        if (x == null) {
            return null;
        }
        return hermano(padre(x));
    }


    /**
     * Permite obtener el abuelo (el padre del padre) de un nodo dado por medio del método padre.
     * que busca el nodo del cual precede el parámetro x.
     *
     * @param x es un nodo al que se le va consultar el abuelo.
     * @return retorna el nodo abuelo del nodo dado.
     */
    public NodoDoble abuelo(NodoDoble x) {
        if (x == null) {
            return null;
        }
        return padre(padre(x));
    }

    /**
     * Recibe dos String delimitados con comas correspondientes a los recorridos
     * in y preoden, cada elemento del String es el dato de un nodo de un
     * árbol con estos recorridos que será construido por medio del método inpre.
     *
     * @param inorden es un String delimitado por comas con el recorrido in orden del
     * árbol a reconstruir.
     * @param preorden es un String delimitado por comas con el recorrido preorden del
     * árbol a reconstruir.
     */
    public void construyeInPre(String inorden, String preorden) {
        List inC = Arrays.asList(inorden.split(","));
        List preC = Arrays.asList(preorden.split(","));
        raiz = inpre(inC, preC);
    }

    /**
     * Método auxiliar de construyeinPre este método toma dos listas de igual
     * longitud en principio para obtener el orden de los nodos de un árbol por
     * medio de llamadas recursivas pa conectando los nodos del árbol hasta
     * lograr su construcción.
     *
     * @param in es una lista con el contenido indorden del árbol.
     * @param pre es una lista con el recorrido preorden del árbol.
     * @return un nodo que contiene la raíz del árbol formado por in y pre, con cada recurción.
     */
    private NodoDoble inpre(List in, List pre) {
        NodoDoble x;
        int k;
        String aux1, aux2;
        List apre, ain;
        if (in.isEmpty()) {
            return null;
        }
        x = new NodoDoble(pre.get(0));
        k = 0;
        aux1 = (String) in.get(0);
        aux2 = (String) pre.get(0);
        while (!aux1.equals(aux2)) {
            k += 1;
            aux1 = (String) in.get(k);
        }
        ain = in.subList(0, k);
        apre = pre.subList(1, k + 1);
        x.asignaLI(inpre(ain, apre));
        apre = pre.subList(k + 1, in.size());
        ain = in.subList(k + 1, in.size());
        x.asignaLD(inpre(ain, apre));
        return x;
    }

    /**
     * Recibe dos String delimitados con comas correspondientes a los recorridos
     * in y posoden, cada elemento de los String es un dato de un nodo de una
     * arbol con estos recorridos que será construido por medio del método inpos
     *
     * @param inorden es un String delimitado por comas que contiene el recorrido in
     * orden del árbol a reconstruir.
     * @param posorden es un String delimitado por comas que contiene el recorrido pos
     * orden del árbol a reconstruir.
     *
     */
    public void construyeInPos(String inorden, String posorden) {
        List inC = Arrays.asList(inorden.split(","));
        List posC = Arrays.asList(posorden.split(","));
        raiz = inpos(inC, posC);
    }

    /**
     * Método auxiliar de construyeInPos, este método toma dos listas de igual
     * longitud en principio para obtener el orden de los nodos de un árbol por
     * medio de llamadas recursivas pa conectando los nodos del árbol hasta
     * lograr su construcción. retorna un elemento nodo con cada recursión.
     *
     * @param in es una lista que contiene el recorrido in orden del árbol.
     * @param pos es una lista que contiene el recorrido pos orden del árbol.
     * @return el nodo raíz del árbol formado por in y pos.
     */
    private NodoDoble inpos(List in, List pos) {
        NodoDoble x;
        int k;
        String aux1, aux2;
        List ain, apos;
        if (in.isEmpty()) {
            return null;
        }
        x = new NodoDoble(pos.get(pos.size() - 1));
        k = 0;
        aux1 = (String) in.get(in.size() - 1);
        aux2 = (String) pos.get(pos.size() - 1);
        while (!aux1.equals(aux2)) {
            k += 1;
            aux1 = (String) in.get(in.size() - k);
        }
        if (k != 0) {
            apos = pos.subList(pos.size() - k, pos.size() - 1);
            ain = in.subList(in.size() - k + 1, in.size());
            x.asignaLD(inpos(ain, apos));
        }
        if (in.size() != 1 && pos.size() != 1) {
            if (k == 0) {
                k += 1;
            }
            apos = pos.subList(0, pos.size() - k);
            ain = in.subList(0, in.size() - k);
            x.asignaLI(inpos(ain, apos));
        }
        return x;
    }
}
