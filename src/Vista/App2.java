/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ArbolControlador;
import Modelo.ArbolBinario;
import javax.swing.JFrame;

/**
 *
 * @author Sofito-Chan
 */
public class App2 {
    public static void main(String[] args) {
        
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        ArbolBinario a = new ArbolBinario(); //MODELO
        //String in = "b,c,a";
        //a.ConstruyeArbolBinario2(in);
        a.ConstruyeArbolBinario1(20, true);
        Lienzo l = new Lienzo(); //VISTA
        ArbolControlador objControlador = new ArbolControlador(a,l); //CONTROLADOR
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        // PINTAR ARBOL        
        objControlador.iniciar();
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //MOSTRAR LIENZO EN UNA VENTANA TODO
        JFrame ventana = new JFrame();
        ventana.getContentPane().add(l);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(1200, 700);
        ventana.setVisible(true);
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
    }
}
