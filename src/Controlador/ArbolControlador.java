/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArbolBinario;
import Vista.Lienzo;

/**
 *
 * @author Sofito-Chan
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
     * Este método le asigna el arbol a el lienzo para pintarlo.
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
