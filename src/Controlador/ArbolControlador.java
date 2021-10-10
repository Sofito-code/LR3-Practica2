/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArbolBinario;
import Vista.Lienzo;

/**
 * Esta clase se encarga de enlazar la estructura del árbol binario y el lienzo para dibujar el árbol.
 * 
 * @author Sofito-Chan
 * @author JohnDRD
 */
public class ArbolControlador {
    private ArbolBinario arbol;
    private Lienzo lienzo;
    boolean aleatorio;

    public ArbolControlador(ArbolBinario arbol, Lienzo lienzo) {
        this.arbol = arbol;
        this.lienzo = lienzo;
        this.aleatorio = false;
    }
    
    /**
     * Este método le asigna el árbol a el lienzo para pintarlo.
     */
    public void iniciar() {
        lienzo.setArbol(arbol);
    }   

    public Lienzo getLienzo() {
        return lienzo;
    }

    public ArbolBinario getArbol() {
        return arbol;
    }
    
}
