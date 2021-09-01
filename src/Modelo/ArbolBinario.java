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
 */
public class ArbolBinario {
    private NodoDoble raiz;
    public static final int INORDEN = 0;
    public static final int PREORDEN = 1;
    public static final int POSORDEN = 2;
    private List<NodoDoble>Hojas;

    public ArbolBinario() {
        raiz = null;
        Hojas=new ArrayList();
    }
    public ArbolBinario(NodoDoble x) 
    	{ raiz=x;
    		Hojas=new ArrayList();
    	
    	}

    public boolean esVacio() {
        return (raiz == null);
    }

    public void agregar(double d) {
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
            if ((double) p.retornaDato() == d) {
                System.out.println("Dato ya existe");
                return;
            }
            q = p;
            if (d < (double) p.retornaDato()) {
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
        if (d > (double) q.retornaDato()) {
            q.asignaLD(n);
            System.out.println(n.retornaDato() + "Agregado a la derecha de " + q.retornaDato());
        } else {
            q.asignaLI(n);
            System.out.println(n.retornaDato() + "Agregado a la izquierda de " + q.retornaDato());
        }

    }

    public void mostrar(int opcion) {
        System.out.println();
        if (opcion == INORDEN) {
            System.out.println("INORDEN:");
            mostrarInorden(raiz);
        }
        if (opcion == PREORDEN) {
            System.out.println("PREORDEN:");
            mostrarPreorden(raiz);
        }
        if (opcion == POSORDEN) {
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
        if (izquierda > derecha){
            return (izquierda+1);
        }
        return (derecha+1);
    }
    public List<NodoDoble> nodoshoja()
    { 	 nhr(raiz);
    	return this.Hojas;
    	
    }
    public void nhr(NodoDoble x)
    	{ if(x==null) 
    		{return;}
    	  if(x.retornaLD()!=null && x.retornaLI()!=null) 
    	  	{this.Hojas.add(x);
    	  		return;
    	  	}
    	  else {
    		  if(x.retornaLD()!=null) {nhr(x.retornaLD());}
    		  if(x.retornaLI()!=null) {nhr(x.retornaLD());}
    	  }
    	  return;
    	  
    	}
    public List<NodoDoble> nhrv2(NodoDoble x)
    	{ if(x==null) {return null;}
    		List<NodoDoble> Aux=new ArrayList();
    		if(x.retornaLD()==null && x.retornaLI()==null) 
    			{Aux.add(x);}
    		else {
    			if(x.retornaLD()!=null) {Aux.addAll(nhrv2(x.retornaLD()));}
    			if(x.retornaLI()!=null) {Aux.addAll(nhrv2(x.retornaLI()));}
    		}
    	return Aux;
    	}
    public NodoDoble padre(NodoDoble x) 
    	{	if (x==raiz) 
    			{return raiz;}
    		return pdr(x,raiz);
    		
    	}
    private NodoDoble pdr(NodoDoble x,NodoDoble origen) 
    	{
    		if(origen.retornaLD()==null && origen.retornaLI()==null) {return null;}
    		else {    		
    			NodoDoble aux1;
    			NodoDoble aux2; 
    			if(origen.retornaLD()==x || origen.retornaLI()==x) 
    			{return origen;}

    		else { if(origen.retornaLD()!=null ) 
    				{aux1=pdr(x,origen.retornaLD());
    				if(aux1!=null) {return aux1;}}
    		 if(origen.retornaLI()!=null ) 
				{aux1=pdr(x,origen.retornaLI());
				if(aux1!=null) {return aux1;}}
    			
    		}
    			
    		}
    		return null;
    	}
    public List<NodoDoble> ancestros(NodoDoble x)
    	{	List aux=new ArrayList();
    		NodoDoble pc;
    		if(x==null) {return null;}
    		pc=padre(x);
    		while(pc!=raiz) 
    			{aux.add(pc);
    			 pc=padre(pc);}
    		return aux;
    	
    	}
    public NodoDoble hermano(NodoDoble x) 
    	{if(x==null) {return null;}
    	 NodoDoble aux=padre(x);
    	 if (aux.retornaLD()!=null && aux.retornaLD()!=x) {return aux.retornaLD();}
    	 if (aux.retornaLI()!=null && aux.retornaLI()!=x) {return aux.retornaLI();}
    	 return  null;
    	}
    public int esIzorDe(NodoDoble x) 

    	{ if(x==null) {return -1;}
    	  NodoDoble aux=padre(x);
    	  if(aux.retornaLD()==x) {return 1;}
    	  if(aux.retornaLI()==x) {return 0;}    	  
    	  return -1;
    	
    	}
    public NodoDoble tio(NodoDoble x) {
    	if(x==null) {return null;}
    	return hermano(padre(x));}
    public NodoDoble abuelo(NodoDoble x)
    {
    	if(x==null) {return null;}
    	return padre(padre(x));	
    }
    }
