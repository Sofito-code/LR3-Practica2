/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;
import java.lang.Math;

/**
 *
 * @author Sofito-Chan
 */
public class ArbolBinario {

    public NodoDoble raiz;
    private List<NodoDoble> hojas;
    String[] abc = {"A", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public ArbolBinario() {
        raiz = null;
        hojas = new ArrayList();
    }

    public ArbolBinario(NodoDoble x) {
        raiz = x;
        hojas = new ArrayList();
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    public void ConstruyeArbolBinario(int cantidadNodos, boolean letras) {
        Random r = new Random();
        List<Object> nodos = new ArrayList<>();
        if (letras == true) {
            for (int i = 0; i < cantidadNodos; i++) {
                String nodo = abc[r.nextInt(25)].toLowerCase();
                if(!nodos.contains(nodo)){
                    this.agregar(nodo);
                    nodos.add(nodo);
                }
                else{
                    i--;
                }
                
            }
        } else {
            for (int i = 0; i < cantidadNodos; i++) {
                int nodo = r.nextInt(25);
                if(!nodos.contains(nodo)){
                    this.agregar(nodo);
                    nodos.add(nodo);
                }
                else{
                    i--;
                }
                
            }
        }
    }

    public void CArbolBinario(String x, int nivel) {
        List aux = new ArrayList();
        aux.addAll(Arrays.asList(x.split(",")));
        if (aux.size() < nivel) {
            System.out.print("No puede formarse un arbol");
            return;
        }

        int maxN = maxNumNodos(nivel);
        Random r = new Random();
        int aux2;
        NodoDoble aux3;
        List NodosArbol = new ArrayList();

        for (int i = 0; i < maxN && !aux.isEmpty(); i++) {
            aux2 = r.nextInt(aux.size());
            aux3 = new NodoDoble(aux.get(aux2));
            NodosArbol.add(aux3);
            aux.remove(aux2);
        }

        if (NodosArbol.size() < maxN) {
            int oSize = NodosArbol.size();
            int sizecontrol = 0;
            for (int i = 0; i < maxN - oSize; i++) {
                NodosArbol.add(null);
            }

            for (int i = nivel - 1; i > 0; i--) {
                sizecontrol = (int) Math.pow(2, i) - 1;
                if (NodosArbol.get(sizecontrol) == null) {

                    aux3 = (NodoDoble) NodosArbol.get(oSize - 1);
                    NodosArbol.remove(oSize - 1);
                    NodosArbol.add(sizecontrol, aux3);
                    oSize -= 1;
                }
            }
        }

        int count = 1;
        int index = 1;
        int iHD;
        int iHI;
        int i;
        NodoDoble current;
        while (count < nivel) {
            i = 1;
            while (i <= Math.pow(2, count - 1)) {
                current = (NodoDoble) NodosArbol.get(index - 1);
                if (current == null) {
                    while (current == null && index - 1 < NodosArbol.size()) {
                        index += 1;
                        current = (NodoDoble) NodosArbol.get(index - 1);
                    }
                    count += 1;
                    if (count >= nivel) {
                        return;
                    }
                }

                iHD = ((2 * index) + 1) - 1;
                iHI = (2 * index) - 1;
                if (iHD < NodosArbol.size()) {
                    aux3 = (NodoDoble) NodosArbol.get(iHD);
                    current.asignaLD(aux3);
                }
                if (iHI < NodosArbol.size()) {
                    aux3 = (NodoDoble) NodosArbol.get(iHI);
                    current.asignaLI(aux3);
                }
                if (count == 1) {
                    this.raiz = current;
                }
                index += 1;
                i += 1;
            }
            count += 1;

        }

    }

    private int maxNumNodos(int nivel) {
        int aux = 0;
        if (nivel <= 0) {
            return 0;
        }
        for (int i = 0; i < nivel; i++) {
            int aux2 = (int) Math.pow(2, i);
            aux = aux + aux2;
        }
        return aux;
    }

  

    public void agregar(Object d) {
        NodoDoble n = new NodoDoble(d);

        /*
         * Si es vacía se puede proceder a hacer el nodo como su único miembro,
         * la raíz.
         * 
         */
        if (esVacio()) {
            System.out.println("No existían más nodos.");
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
                System.out.println("Dato ya existe");
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
            System.out.println(n.retornaDato() + " Agregado a la derecha de " + q.retornaDato());
        } else {
            q.asignaLI(n);
            System.out.println(n.retornaDato() + " Agregado a la izquierda de " + q.retornaDato());
        }

    }

    public void mostrar(int opcion) {
        System.out.println();
        if (opcion == 0) {
            System.out.println("INORDEN:");
            mostrarInorden(raiz);
        }
        if (opcion == 1) {
            System.out.println("PREORDEN:");
            mostrarPreorden(raiz);
        }
        if (opcion == 2) {
            System.out.println("POSORDEN:");
            mostrarPosorden(raiz);
        }
    }

    private void mostrarInorden(NodoDoble x) {
        if (x != null) {
            mostrarInorden(x.retornaLI());
            System.out.println(x.retornaDato());
            mostrarInorden(x.retornaLD());
        }
    }

    private void mostrarPreorden(NodoDoble x) {
        if (x == null) {
            return;
        }
        System.out.println(x.retornaDato());
        mostrarPreorden(x.retornaLI());
        mostrarPreorden(x.retornaLD());
    }

    private void mostrarPosorden(NodoDoble x) {
        if (x == null) {
            return;
        }
        mostrarPosorden(x.retornaLI());
        mostrarPosorden(x.retornaLD());
        System.out.println(x.retornaDato());
    }

    public int hojas() {
        if (esVacio()) {
            return 0;
        }
        return (hojasPorNodo(raiz));
    }

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

    public int grado() {
        if (esVacio()) {
            return 0;
        }
        return (gradoConRaiz(raiz));
    }

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

    public int altura() {
        return alturaPorNodo(raiz);
    }

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

    public List<NodoDoble> nodoshoja() {
        List c=nhr(raiz);
        return c;
    }

    public List<NodoDoble> nhr(NodoDoble x) {
        if (x == null) {
            return null;
        }
        List<NodoDoble> Aux = new ArrayList();
        if (x.retornaLD() == null && x.retornaLI() == null) {
            Aux.add(x);
        } else {
            if (x.retornaLD() != null) {
                Aux.addAll(nhr(x.retornaLD()));
            }
            if (x.retornaLI() != null) {
                Aux.addAll(nhr(x.retornaLI()));
            }
        }
        return Aux;
    }
    public NodoDoble buscarNodo(String name){
        Stack x= new Stack();
        x.add(raiz);
        NodoDoble current=this.raiz;
        String aux;
        while(!x.isEmpty()){
            current=(NodoDoble)x.pop();
            aux=(String)current.retornaDato();
            if(aux.equals(name)){
                return current;
            }
            else{
                if(current.retornaLD()!=null){
                    x.remove(current);
                    x.add(current.retornaLD());
                }
                if(current.retornaLI()!=null){
                    x.remove(current);
                    x.add(current.retornaLI());
                }
            }
        }
        return null;
    }
    public NodoDoble padre(NodoDoble x) {
        if (x == raiz) {
            return raiz;
        }
        return pdr(x, raiz);
    }

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
        }while (pc != raiz);
        return aux;

    }

    public NodoDoble hermano(NodoDoble x) {
        if (x == null) {
            return null;
        }
        NodoDoble aux = padre(x);
        if (aux.retornaLD() != null && aux.retornaLD() != x) {
            return aux.retornaLD();
        }
        if (aux.retornaLI() != null && aux.retornaLI() != x) {
            return aux.retornaLI();
        }
        return null;
    }

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

    public NodoDoble tio(NodoDoble x) {
        if (x == null) {
            return null;
        }
        return hermano(padre(x));
    }

    public NodoDoble abuelo(NodoDoble x) {
        if (x == null) {
            return null;
        }
        return padre(padre(x));
    }
    public void construyeInPre(String inorden,String preorden)
        {   List in= Arrays.asList(inorden.split(","));
            List pre=Arrays.asList(preorden.split(","));
            raiz=inpre(in,pre);
 
            
        }
    private NodoDoble inpre(List in,List pre)
        {   NodoDoble x;
            int i,j,k;
            String aux1,aux2;
            List apre,ain;
            if(in.isEmpty()){return null;}
            x=new NodoDoble(pre.get(0));
            k=0;
            aux1=(String)in.get(0);
            aux2=(String) pre.get(0);
            while(!aux1.equals(aux2))
            {k+=1;
            aux1=(String)in.get(k);
            }
            
            ain=in.subList(0, k);
            apre=pre.subList(1, k+1);
            
            x.asignaLI(inpre(ain,apre));
            apre=pre.subList(k+1, in.size());
            ain=in.subList(k+1, in.size());
            x.asignaLD(inpre(ain,apre));
            return x;
        }
    public void construyeInPos(String inorden, String posorden)
        {List in= Arrays.asList(inorden.split(","));
            List pos=Arrays.asList(posorden.split(","));
            raiz=inpos(in,pos);
        }
    private NodoDoble inpos(List in, List pos)
        { NodoDoble x;
          int i,j,k;
          String aux1,aux2;
          List ain,apos;
          if(in.isEmpty()){return null;}
          x=new NodoDoble(pos.get(pos.size()-1));
          k=0;
            aux1=(String)in.get(in.size()-1);
            aux2=(String) pos.get(pos.size()-1);
            while(!aux1.equals(aux2))
            {k+=1;
            aux1=(String)in.get(in.size()-k);
            }
          if(k!=0){
          apos=pos.subList(pos.size()-k, pos.size()-1);
          ain=in.subList(in.size()-k+1, in.size());
              x.asignaLD(inpos(ain,apos));
          
          }
          if(in.size()!=1 && pos.size()!=1){
              if(k==0)
              {k+=1;}
              apos=pos.subList(0,pos.size()-k);
          ain=in.subList(0, in.size()-k);
          x.asignaLI(inpos(ain,apos));}


          return x;
        
        }
}
