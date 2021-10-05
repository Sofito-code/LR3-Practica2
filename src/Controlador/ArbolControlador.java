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

    public ArbolControlador(ArbolBinario arbol, Lienzo lienzo) {
        this.arbol = arbol;
        this.lienzo = lienzo;
    }

    public void iniciar() {
        lienzo.setArbol(arbol);
    }
}
