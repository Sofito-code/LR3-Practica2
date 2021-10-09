/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ArbolControlador;
import Modelo.ArbolBinario;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Sofito-Chan
 */
public class App2 {
    public static void main(String[] args) {
        
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        String in = "b,c,a";
        String aa = "G,H,O,Q,R,T,X";
        String bb = "H,O,R,Q,X,T,G";
        ArbolBinario arbol = new ArbolBinario(); //MODELO        
        //arbol.ConstruyeArbolBinario2(in);        
        arbol.ConstruyeArbolBinario1(10, true);
        Lienzo lienzo = new Lienzo(); //VISTA
        ArbolControlador objControlador = new ArbolControlador(arbol,lienzo); //CONTROLADOR
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        // PINTAR ARBOL        
        objControlador.iniciar();
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //MOSTRAR LIENZO EN UNA VENTANA TODO
        JFrame ventana = new JFrame();
        ventana.add(lienzo);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(1200, 700);
        ventana.setVisible(true);
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
    }
}
