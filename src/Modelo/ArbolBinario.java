/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;

/**
 *
 * @author Sofito-Chan
 * @author JohnDRD
 */
public class ArbolBinario {

    private NodoDoble raiz;
    private List<NodoDoble> hojas;
    String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    /**
     * Constructor del objeto Arbol vacio.
     */
    public ArbolBinario() {
        raiz = null;
        hojas = new ArrayList();
    }

    public ArbolBinario(NodoDoble x) {
        raiz = x;
        hojas = new ArrayList();
    }

    public NodoDoble getRaiz() {
        return raiz;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * Construye un arbol binario aleatorio un numero de nodos, puede usar
     * numeros aleatorios o letras para construirse marcando el parametro letras
     * false para numeros, true para usar letras.
     *
     * @param cantidadNodos
     * @param letras
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
                int nodo = r.nextInt(25);
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
     *
     * @param x
     *
     */
    public void ConstruyeArbolBinario2(String x) {
        Queue<String> cola = new LinkedList();
        cola.addAll(Arrays.asList(x.split(",")));
        while (cola.isEmpty() != true) {
            this.agregar(cola.poll());
        }
    }

    /**
     * añade a un arbol binario un elemento d, que no esté presente en el arbol
     *
     * @param d
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
     * Permite mostrar el arbol en los tres diferentes recorridos,
     * inorden,preorden y posorden. toma como parametro un entero que permite
     * selecionar la forma de recorido 1=Inorden 2=preorden 3=posorden
     *
     * @param opcion
     * @param n
     */
    public void mostrar(int opcion, NodoDoble n) {
        System.out.println();
        if (opcion == 0) {
            //INORDEN
            mostrarInorden(n);
        }
        if (opcion == 1) {
            //PREORDEN
            mostrarPreorden(n);
        }
        if (opcion == 2) {
            //POSORDEN
            mostrarPosorden(n);
        }
    }

    /**
     * Metodo auxiliar de mostrar, realiza el recorrido inorden del arbol
     *
     * @param x
     */
    private void mostrarInorden(NodoDoble x) {
        if (x != null) {
            mostrarInorden(x.retornaLI());
            System.out.println(x.retornaDato());
            mostrarInorden(x.retornaLD());
        }
    }

    /**
     * Metodo auxiliar de mostrar, realiza el recorrido preorden del arbol
     *
     * @param x
     */
    private void mostrarPreorden(NodoDoble x) {
        if (x == null) {
            return;
        }
        System.out.println(x.retornaDato());
        mostrarPreorden(x.retornaLI());
        mostrarPreorden(x.retornaLD());
    }

    /**
     * Metodo auxiliar de mostrar, realiza el recorrido posorden del arbol
     *
     * @param x
     */
    private void mostrarPosorden(NodoDoble x) {
        if (x == null) {
            return;
        }
        mostrarPosorden(x.retornaLI());
        mostrarPosorden(x.retornaLD());
        System.out.println(x.retornaDato());
    }

    /**
     * Permite obtener el numero de hojas del arbol por medio del metodo
     * HojasporNodo
     *
     * @return cantidad de hojas del arbol
     */
    public int hojas() {
        if (esVacio()) {
            return 0;
        }
        return (hojasPorNodo(raiz));
    }

    /**
     * metodo auxiliar de hojas, realiuza una serie de llamdas recursivas a modo
     * de exploracion para contar cuales nodos son hojas dentro del arbol
     *
     * @param x
     * @retutn cantida de hojas del arbol
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
     * invoca el metodo gradoConRaiz, retorna el grado del arbol
     *
     * @return int grado del arbol
     */
    public int grado() {
        if (esVacio()) {
            return 0;
        }
        return (gradoConRaiz(raiz));
    }

    /**
     * Metodo auxiliar de grado, realiza la exploracion del arbol para
     * determinar su grado por medio de recursion
     *
     * @param x
     * @return grado del arbol
     */
    private int gradoConRaiz(NodoDoble x) {
        if (x == null) {
            return 0;
        }
        int g = x.grado();
        int gmax = g;
        g = gradoConRaiz(x.retornaLD());
        if (g > gmax) {
            gmax = g;
        }
        g = gradoConRaiz(x.retornaLI());
        if (g > gmax) {
            gmax = g;
        }
        if (gmax == 2) {
            return 2;
        }
        return gmax;
    }

    /**
     * Invoca al metodo alturaPorNodo para determinar la altura del arbol
     *
     * @return int altura del arbol
     */
    public int altura() {
        return alturaPorNodo(raiz);
    }

    /**
     * metodo auxliar de altura, realiza un recorrido por el arbol para encontar
     * la cadena de nodos mas larga de forma decendente retorna dicho valor a
     * modo de altura.
     *
     * @param x nodo doble
     * @return int altura del arbol
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
     * Invoca el metodo nhr para obtener una lista con todos los nodos hoja del
     * arbol.
     *
     * @return List con todos los nodos hojas del arbol
     */
    public List<NodoDoble> nodoshoja() {
        List c = nhr(raiz);
        return c;
    }

    /**
     * metodo auxiliar de nodosHoja, realiza una exploracion en el arbol para
     * obtener los nodos que cumplen con la condicion de ser hojas este metodo
     * recursivo retorna un objeto de tipo List<NodoDoble>, recive como
     * parametro el nodo a comprobar
     *
     * @param x nodoDoble indice
     * @return List nodos hoja
     */
    public List<NodoDoble> nhr(NodoDoble x) {
        if (x == null) {
            return null;
        }
        List<NodoDoble> aux = new ArrayList();
        if (x.retornaLD() == null && x.retornaLI() == null) {
            aux.add(x);
        } else {
            if (x.retornaLD() != null) {
                aux.addAll(nhr(x.retornaLD()));
            }
            if (x.retornaLI() != null) {
                aux.addAll(nhr(x.retornaLI()));
            }
        }
        hojas = aux;
        return aux;
    }

    /**
     * realiza una exploracion en el arbol buscando el nodo que contenga el
     * parametro name de tipo String en el campo de dato, retorna dicho nodo
     *
     * @param name string del dato en el campo de dato del nodo
     * @return Nodo DOble que contiene el nombre dado
     */
    public NodoDoble buscarNodo(String name) {
        Stack x = new Stack();
        x.add(raiz);
        NodoDoble current = this.raiz;
        String aux;
        while (!x.isEmpty()) {
            current = (NodoDoble) x.pop();
            aux = (String) current.retornaDato();
            if (aux.equals(name)) {
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
     * Invoca el metodo pdr el cual se encarga de buscar el padre de un nodo x
     *
     * @param x nodoDoble hijo
     * @return nodo doble padre de x
     */
    public NodoDoble padre(NodoDoble x) {
        if (x == raiz) {
            return raiz;
        }
        return pdr(x, raiz);
    }

    /**
     * metodo auxiliar que busca de forma recursiva el padre de un nodo dado,
     * toma como parametros el ultimo nodo explorado u origen y el nodo el cual
     * se esta buscando, retorna nulo en caso de no estar presente en el arbol
     *
     * @param x
     * @param origen
     * @retun nodoDoble padre del nodo x
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
                    aux1 = pdr(x, origen.retornaLI());
                    if (aux1 != null) {
                        return aux1;
                    }
                }
            }
        }
        return null;
    }

    /**
     * mediante el metodo padre, realiza una lista con todos los nodos que se
     * recorren hasta llegar a parametro x desde la raiz retorna un objeto de
     * tipo List<NodoDoble>
     *
     * @param x nodo doble a buscar sus ancestros
     * @return List con los ancestros de x
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
        return aux;
    }

    /**
     * mediante el metodo Padre busca el nodo del cual procede el parametro x,
     * retorna el valor del nodo en el campo de liga opuesto a x. retorna nulo
     * en caso de no haber ningun nodo enj el campo o no encontrarse dicho nodo
     * en el arbol
     *
     * @param x NOdo doble a buscar el hermano
     * @return hemano del nodo x
     */
    public NodoDoble hermano(NodoDoble x) {
        if (x == null) {
            return null;
        }
        NodoDoble aux = padre(x);
        if (aux == null) {
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
     * mediante el metodo padre encuentra el nodo de procendencia del parametro
     * x, seguido de esto retorna si es se encuentra en la liga izquierda o
     * derecha de este nodo. -1: si el nodo no esta en el arbol 1: si esta en la
     * derecha 0: si esta en la izquierda
     *
     * @param x nodoDoble a consultar
     * @return int valor si es izquiero, derecho o no esta en el arbol
     *
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
     * Busca el nodo hermano del nodo de procedencia del parametro x retorna
     * null si no esta en el arbol o si el nodo de procendecia no tiene hermano
     *
     * @param x NOdo doble a buscarle su tio
     * @return NodoDoble tio del nodo x
     */
    public NodoDoble tio(NodoDoble x) {
        if (x == null) {
            return null;
        }
        return hermano(padre(x));
    }

    /**
     * retorna el padre, del nodo padre del parametro x
     *
     * @param x Nodo Doble a buscarle su abuelo
     * @return NodoDOble abuelo de x
     */
    public NodoDoble abuelo(NodoDoble x) {
        if (x == null) {
            return null;
        }
        return padre(padre(x));
    }

    /**
     * Recibe dos String delimitados con comas correspondientes a los recorridos
     * in y preoden, cada elemento de lso String es el dato de un nodo de una
     * rbol con estos recoridos que sera construido por medio del metodo inpre
     *
     * @param inorden String delimitado por comas con el recorrido in orden del
     * arbol a reconstruir
     * @param preorden String delimitado por comas con el recorrido preorden del
     * arbol a reconstruir
     */
    public void construyeInPre(String inorden, String preorden) {
        List in = Arrays.asList(inorden.split(","));
        List pre = Arrays.asList(preorden.split(","));
        raiz = inpre(in, pre);
    }

    /**
     * Metodo auxiliar de construyeinPre este metodo toma dos listas de igual
     * longitud en principio para obtener el orden de los nodos de un arbol por
     * medio de llamdas recursivas pa conectando los nodos del arbol hasta
     * lograr su construccion. retorna un elemeto NodoDoble con cada recursion.
     *
     * @param in Lista con el contenido indorden del arbol
     * @param pre Lista con el recorrido preorden del arbol
     * @return NodoDoble que contiene la raiz del arbol formado por in y pre
     */
    private NodoDoble inpre(List in, List pre) {
        NodoDoble x;
        int i, j, k;
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
     * arbol con estos recoridos que sera construido por medio del metodo inpos
     *
     * @param inorden String delimitado por comas que contiene el recorrido in
     * orden del arbol a reconstruir
     * @param posorden String delimitado por comas que contiene el recorrido pos
     * orden del arbol a reconstruir
     *
     */
    public void construyeInPos(String inorden, String posorden) {
        List in = Arrays.asList(inorden.split(","));
        List pos = Arrays.asList(posorden.split(","));
        raiz = inpos(in, pos);
    }

    /**
     * Metodo auxiliar de construyeInPos este metodo toma dos listas de igual
     * longitud en principio para obtener el orden de los nodos de un arbol por
     * medio de llamdas recursivas pa conectando los nodos del arbol hasta
     * lograr su construccion. retorna un elemeto NodoDoble con cada recursion.
     *
     * @param in List que contiene el recorrido in orden del arbol
     * @param pos List que contiene el recorrido pos orden del arbol
     * @return nodoDoble raiz del arbol formado por in y pos
     */
    private NodoDoble inpos(List in, List pos) {
        NodoDoble x;
        int i, j, k;
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
